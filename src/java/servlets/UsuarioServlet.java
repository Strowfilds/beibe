package servlets;

import beans.Login;
import beans.Usuario;
import beans.enums.TipoUsuarioEnum;
import exceptions.DAOException;
import facade.UsuarioFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

// <editor-fold defaultstate="collapsed" desc="processRequest method. Click on the + sign on the left to edit the code.">
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("msg", "Forma de acesso inválida.");
        session.setAttribute("code", 400);
        response.sendRedirect("erro.jsp");

    }
    // </editor-fold>

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        try {
            //  ================================================================ Conferindo acesso
            if (session.getAttribute("login") != null) {
                //  ============================================================ Conferindo opção
                if (action.equals("minhaconta")) {
                    //  ======================================================== Minha Conta
                    Login login = (Login) session.getAttribute("login");
                    Usuario usuario = UsuarioFacade.buscar(login.getId());
                    session.setAttribute("usuario", usuario);
                    response.sendRedirect("admin/minha-conta.jsp");
                } else {
                    //  ======================================================== Opção inválida
                    session.setAttribute("msg", "Opção inválida");
                    response.sendRedirect("erro.jsp");
                }
            } else {
                session.setAttribute("msg", "Acesso não autorizado!");
                response.sendRedirect("/erro.jsp");
            }
        } catch (DAOException daoex) {
            session.setAttribute("javax.servlet.jsp.jspException", daoex);
            session.setAttribute("javax.servlet.error.status_code", 500);
            session.setAttribute("msg", "ERRO: " + daoex.getMessage());
            response.sendRedirect("erro.jsp");
        } catch (Exception ex) {
            session.setAttribute("javax.servlet.jsp.jspException", ex);
            session.setAttribute("javax.servlet.error.status_code", 500);
            session.setAttribute("msg", "ERRO: " + ex.getMessage());
            response.sendRedirect("erro.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        try {
            if (session.getAttribute("login") != null) {

                if (action.equals("editar")) {
                    // ============================================================= EDITAR
                    String strId = request.getParameter("id");
                    if (strId == null) {
                        session.setAttribute("msg", "Invocação inválida: id é nulo");
                        response.sendRedirect("erro.jsp");
                        return;
                    } else {
                        String nome = request.getParameter("nome");
                        String endereco = request.getParameter("endereco");
                        int num = Integer.parseInt(request.getParameter("num"));
                        String compl = request.getParameter("compl");
                        String bairro = request.getParameter("bairro");
                        int cidade = Integer.parseInt(request.getParameter("cidade"));
                        int estado = Integer.parseInt(request.getParameter("estado"));
                        String cep = request.getParameter("cep").replace(".", "").replace("-", "");
                        String tel = request.getParameter("tel").replace("-", "");;
                        String senha = request.getParameter("senha");
                        int id = Integer.parseInt(strId);
                        UsuarioFacade.alterar(id, nome, endereco, num, compl, bairro, cidade, estado, cep, tel, senha);
                        response.sendRedirect("admin/index.jsp");
                    }
                }
            } else if (action.equals("autocadastro")) {
                // ============================================================= AUTOCADASTRO
                String nome = request.getParameter("nome");
                String cpf = request.getParameter("cpf").replace(".", "").replace("-", "");
                String email = request.getParameter("email");
                String endereco = request.getParameter("endereco");
                int num = Integer.parseInt(request.getParameter("num"));
                String compl = request.getParameter("compl");
                String bairro = request.getParameter("bairro");
                int cidade = Integer.parseInt(request.getParameter("cidade"));
                int estado = Integer.parseInt(request.getParameter("estado"));
                String cep = request.getParameter("cep");
                String tel = request.getParameter("tel");
                String senha = request.getParameter("senha");
                UsuarioFacade.criarNovoUsuario(nome, cpf, email, endereco, num, compl, bairro, cidade, estado, cep, tel, senha, 1);

                Usuario usuario = UsuarioFacade.buscarEmail(email);
                Login login = new Login();
                login.setId(usuario.getId());
                login.setNome(usuario.getNome());
                login.setTipoUsuario(TipoUsuarioEnum.getTipoUsuarioFromInt(usuario.getTipoUsuario().getId()));
                session = request.getSession();
                session.setAttribute("login", login);
                response.sendRedirect("admin/index.jsp");
            } else {
                session.setAttribute("msg", "Acesso não autorizado!");
                response.sendRedirect("/erro.jsp");
            }
        } catch (NumberFormatException e) {
            session.setAttribute("javax.servlet.jsp.jspException", e);
            session.setAttribute("javax.servlet.error.status_code", 500);
            session.setAttribute("msg", "Dados para apresentação inválido");
            response.sendRedirect("erro.jsp");
        } catch (DAOException de) {
            session.setAttribute("javax.servlet.jsp.jspException", de);
            session.setAttribute("javax.servlet.error.status_code", 500);
            session.setAttribute("msg", "ERRO: " + de.getMessage());
            response.sendRedirect("erro.jsp");
        } catch (Exception ex) {
            session.setAttribute("javax.servlet.jsp.jspException", ex);
            session.setAttribute("javax.servlet.error.status_code", 500);
            session.setAttribute("msg", "ERRO: " + ex.getMessage());
            response.sendRedirect("erro.jsp");
        }
    }

// <editor-fold defaultstate="collapsed" desc="getServletInfo method. Click on the + sign on the left to edit the code.">
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet de ações relacionadas aos usuários.";
    }// </editor-fold>

}
