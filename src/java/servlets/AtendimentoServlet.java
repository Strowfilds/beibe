package servlets;

import beans.Atendimento;
import beans.Categoria;
import beans.Login;
import beans.Produto;
import beans.TipoAtendimento;
import beans.Usuario;
import exceptions.DAOException;
import facade.AtendimentoFacade;
import facade.CategoriaFacade;
import facade.ProdutoFacade;
import facade.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AtendimentoServlet", urlPatterns = {"/AtendimentoServlet"})
public class AtendimentoServlet extends HttpServlet {

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

        RequestDispatcher rd = null;
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        try {
            // ================================================================= Conferindo acesso
            if (session.getAttribute("login") != null) {
                Login login = (Login) session.getAttribute("login");
                if (login.getTipoUsuario().getId() == 1) {
                    // ========================================================= Opções cliente
                    if (action.equals("novo")) {
                        // ===================================================== Novo atendimento
                        Usuario usuario = UsuarioFacade.buscar(login.getId());
                        Atendimento atendimento = new Atendimento();
                        atendimento.setUsuario(usuario);
                        session.setAttribute("atendimento", atendimento);
                        List<TipoAtendimento> tiposAtendimento = AtendimentoFacade.buscarTiposAtendimento();
                        session.setAttribute("tiposatendimento", tiposAtendimento);
                        List<Produto> produtos = ProdutoFacade.buscarTodos();
                        session.setAttribute("produtos", produtos);
                        response.sendRedirect("admin/edit-atendimento.jsp?action=novo");
                    } else if (action.equals("listatendimentosusuario")) {
                        // ===================================================== Listagem atendimentos
                        List<Atendimento> atendimentos = AtendimentoFacade.buscarUsuario(login.getId());
                        session.setAttribute("atendimentos", atendimentos);
                        response.sendRedirect("admin/atendimentos_cliente.jsp");
                    } else if (action.equals("home")) {
                        // ===================================================== Home Page
                        List<Atendimento> atendimentos = AtendimentoFacade.buscarUsuario(login.getId());
                        session.setAttribute("atendimentos", atendimentos);
                        response.sendRedirect("admin/index.jsp");
                    } else {
                        session.setAttribute("msg", "Opção inválida");
                        response.sendRedirect("erro.jsp");
                    }
                } else {
                    // ========================================================= Opções ADM
                    if (action.equals("listatendimentos")) {
                        // ===================================================== Listar atendimentos
                        List<Atendimento> atendimentos = AtendimentoFacade.buscarTodos();
                        session.setAttribute("atendimentos", atendimentos);
                        response.sendRedirect("admin/atendimentos_funcionario.jsp");
                    } else if (action.equals("home")) {
                        // ===================================================== Home
                        List<Atendimento> atendimentosAbertos = AtendimentoFacade.buscarAtendimentosAbertos();
                        int atendimentosQtd = atendimentosAbertos.size();
                        List<Atendimento> atendimentos = AtendimentoFacade.buscarTodos();
                        int atendimentosQtdTotal = atendimentos.size();
                        session.setAttribute("atendimentosQtd", atendimentosQtd);
                        session.setAttribute("atendimentosQtdTotal", atendimentosQtdTotal);
                        session.setAttribute("atendimentos", atendimentosAbertos);
                        response.sendRedirect("admin/index.jsp");
                    } else if (action.equals("modificar")) {
                        // ===================================================== Modificar
                        String strId = request.getParameter("id");
                        int id = 0;
                        if (strId == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("/erro.jsp");
                            return;
                        } else {
                            id = Integer.parseInt(request.getParameter("id"));
                            Atendimento atendimento = AtendimentoFacade.buscar(id);
                            session.setAttribute("atendimento", atendimento);
                            response.sendRedirect("admin/edit-atendimento.jsp?action=modificar");
                        }
                    } else {
                        // ===================================================== Opção invalida
                        session.setAttribute("msg", "Opção inválida");
                        response.sendRedirect("erro.jsp");
                    }
                }
            } else {
                // ============================================================= Acesso não autorizado
                request.setAttribute("msg", "Acesso não autorizado!");
                rd = getServletContext().getRequestDispatcher("/admin/erro.jsp");
                rd.forward(request, response);
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
                if (login.getTipoUsuario().getId() == 1) {
                    // ========================================================= Opções cliente
                    if (action.equals("adicionar")) {
                        // ===================================================== Adicionar
                        Date data = new Date();
                        String descricao = request.getParameter("descricao");
                        String strProduto = request.getParameter("produto");
                        String strTipoAtendimento = request.getParameter("tipoatendimento");
                        String strId = request.getParameter("id");
                        if (strId == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("/erro.jsp");                            
                            return;
                        } else {
                            int produto = Integer.parseInt(strProduto);
                            int tipoAtendimento = Integer.parseInt(strTipoAtendimento);
                            int id = Integer.parseInt(strId);
                            AtendimentoFacade.inserir(data, descricao, produto, tipoAtendimento, id);
                            List<Atendimento> atendimentos = AtendimentoFacade.buscarUsuario(id);
                            session.setAttribute("atendimentos", atendimentos);
                            response.sendRedirect("admin/atendimentos_cliente.jsp");
                        }
                    } else {
                        // ===================================================== Cliente opção inválida
                        session.setAttribute("msg", "Opção inválida");
                        response.sendRedirect("/admin/erro.jsp");                        
                    }
                } else {
                    // ========================================================= Opções ADM
                    if (action.equals("listatendimentos")) {
                        // ===================================================== Listar atendimento
                        List<Atendimento> atendimentos = AtendimentoFacade.buscarTodos();
                        session.setAttribute("atendimentos", atendimentos);
                        response.sendRedirect("admin/atendimentos_funcionario.jsp");
                    } else if (action.equals("modificar")) {
                        // ===================================================== Modificar atendimento
                        String strId = request.getParameter("idAtendimento");
                        int id = 0;
                        if (strId == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("/erro.jsp");                            
                            return;
                        } else {
                            id = Integer.parseInt(strId);
                            Atendimento atendimento = AtendimentoFacade.buscar(id);
                            atendimento.setAberto(request.getParameter("resolvido") != null);
                            atendimento.setSolucao((String) request.getAttribute("solucao"));                        
                            AtendimentoFacade.atualizar(atendimento);
                            response.sendRedirect("admin/index.jsp");
                        }
                    } else {
                        session.setAttribute("msg", "Opção inválida");
                        response.sendRedirect("/admin/erro.jsp");
                    }
                }
            } else {
                // ============================================================= Acesso não autorizado
                session.setAttribute("msg", "Acesso não autorizado!");
                response.sendRedirect("/admin/erro.jsp");                
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

// <editor-fold defaultstate="collapsed" desc="getServletInfo method. Click on the + sign on the left to edit the code.">
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
