package servlets;

import beans.Login;
import beans.Usuario;
import exceptions.DAOException;
import facade.FuncionarioFacade;
import facade.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

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
            // ================================================================= Conferindo acesso
            if (session.getAttribute("login") != null) {
                Login login = (Login) session.getAttribute("login");
                if (login.getTipoUsuario().getId() < 3) {
                    // ========================================================= Privilégio insuficiente
                    session.setAttribute("msg", "Acesso não autorizado!");
                    response.sendRedirect("admin/erro.jsp");
                } else {
                    if (action.equals("listfuncionarios")) {
                        // ===================================================== Listar funcionários
                        List<Usuario> funcionarios = FuncionarioFacade.buscarTodos();
                        session.setAttribute("funcionarios", funcionarios);
                        response.sendRedirect("admin/funcionarios.jsp");
                    } else if (action.equals("novo")) {
                        // ===================================================== Novo funcionários                        
                        response.sendRedirect("admin/edit-funcionario.jsp?action=novo");
                    } else if (action.equals("remover")) {
                        // ===================================================== Remover funcionário                        
                        String strId = request.getParameter("id");
                        int id = 0;
                        if (strId == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("admin/erro.jsp");
                            return;
                        } else {
                            id = Integer.parseInt(strId);
                            FuncionarioFacade.remover(id);
                            List<Usuario> funcionarios = FuncionarioFacade.buscarTodos();
                            session.setAttribute("funcionarios", funcionarios);
                            response.sendRedirect("admin/funcionarios.jsp");
                        }
                    } else if (action.equals("modificar")) {
                        String strId = request.getParameter("id");
                        int id = 0;
                        if (strId == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("admin/erro.jsp");
                            return;
                        } else {
                            id = Integer.parseInt(request.getParameter("id"));
                            Usuario funcionario = UsuarioFacade.buscar(id);
                            session.setAttribute("funcionario", funcionario);
                            response.sendRedirect("admin/edit-funcionario.jsp?action=modificar");
                        }
                    } else {
                        session.setAttribute("msg", "Opção inválida");
                        response.sendRedirect("erro.jsp");
                    }
                }
            } else {
                // ============================================================= Acesso não autorizado
                session.setAttribute("msg", "Acesso não autorizado!");
                response.sendRedirect("admin/erro.jsp");
            }
        } catch (NumberFormatException e) {
            session.setAttribute("javax.servlet.jsp.jspException", e);
            session.setAttribute("javax.servlet.error.status_code", 500);
            session.setAttribute("msg", "Dados para apresentação inválidos.");
            response.sendRedirect("erro.jsp");
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
            // ================================================================= Conferindo acesso
            if (session.getAttribute("login") != null) {
                Login login = (Login) session.getAttribute("login");
                if (login.getTipoUsuario().getId() < 3) {
                    // ========================================================= Privilégio insuficiente
                    session.setAttribute("msg", "Acesso não autorizado!");
                    response.sendRedirect("admin/erro.jsp");
                } else {
                    if (action.equals("adicionar")) {
                        String nome = request.getParameter("nome");
                        String cpf = request.getParameter("cpf").replace(".", "").replace("-", "").replace(" ", "");
                        String email = request.getParameter("email");
                        String endereco = request.getParameter("endereco");
                        int num = Integer.parseInt(request.getParameter("num"));
                        String compl = request.getParameter("compl");
                        String bairro = request.getParameter("bairro");
                        int cidade = Integer.parseInt(request.getParameter("cidade"));
                        int estado = Integer.parseInt(request.getParameter("estado"));
                        String cep = request.getParameter("cep").replace(".", "").replace("-", "").replace(" ", "");
                        String tel = request.getParameter("tel").replace(".", "").replace("-", "").replace(" ", "");
                        String senha = request.getParameter("senha");
                        UsuarioFacade.criarNovoUsuario(nome, cpf, email, endereco, num, compl, bairro, cidade, estado, cep, tel, senha, 2);
                        List<Usuario> funcionarios = FuncionarioFacade.buscarTodos();
                        session.setAttribute("funcionarios", funcionarios);
                        response.sendRedirect("admin/funcionarios.jsp");
                    } else if (action.equals("editar")) {
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
                    } else {
                        session.setAttribute("msg", "Opção inválida");
                        response.sendRedirect("erro.jsp");
                    }
                }
            } else {
                // ============================================================= Acesso não autorizado
                session.setAttribute("msg", "Acesso não autorizado!");
                response.sendRedirect("admin/erro.jsp");
            }
        } catch (NumberFormatException e) {
            session.setAttribute("javax.servlet.jsp.jspException", e);
            session.setAttribute("javax.servlet.error.status_code", 500);
            session.setAttribute("msg", "Dados para apresentação inválidos.");
            response.sendRedirect("erro.jsp");
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

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
