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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AtendiemntoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AtendiemntoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        // Conferindo acesso ===================================================
        if (session.getAttribute("login") != null) {
            Login login = (Login) session.getAttribute("login");
            if (login.getTipoUsuario().getId() < 2) {
                if (action.equals("novo")) { // ====================================NOVO                
                    try {
                        Usuario usuario = UsuarioFacade.buscar(login.getId());
                        Atendimento atendimento = new Atendimento();
                        atendimento.setUsuario(usuario);
                        session.setAttribute("atendimento", atendimento);
                        List<TipoAtendimento> tiposAtendimento = AtendimentoFacade.buscarTiposAtendimento();
                        session.setAttribute("tiposatendimento", tiposAtendimento);
                        List<Produto> produtos = ProdutoFacade.buscarTodos();
                        session.setAttribute("produtos", produtos);
                        response.sendRedirect("admin/edit-atendimento.jsp?action=novo");
                    } catch (Exception ex) {
                        request.setAttribute("javax.servlet.jsp.jspException", ex);
                        request.setAttribute("javax.servlet.error.status_code", 500);
                        request.setAttribute("msg", "ERRO: " + ex.getMessage());
                        rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                } else if (action.equals("listatendimentosusuario")) { // ======================LISTAR
                    try {
                        List<Atendimento> atendimentos = AtendimentoFacade.buscarUsuario(login.getId());
                        session.setAttribute("atendimentos", atendimentos);
                        response.sendRedirect("admin/atendimentos_cliente.jsp");
                    } catch (DAOException daoex) {
                        request.setAttribute("javax.servlet.jsp.jspException", daoex);
                        request.setAttribute("javax.servlet.error.status_code", 500);
                        request.setAttribute("msg", "ERRO: " + daoex.getMessage());
                        rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    } catch (Exception ex) {
                        request.setAttribute("javax.servlet.jsp.jspException", ex);
                        request.setAttribute("javax.servlet.error.status_code", 500);
                        request.setAttribute("msg", "ERRO: " + ex.getMessage());
                        rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                } else if (action.equals("home")) { // ======================== HOME
                    try {
                        List<Atendimento> atendimentos = AtendimentoFacade.buscarUsuario(login.getId());
                        session.setAttribute("atendimentos", atendimentos);
                        response.sendRedirect("admin/index.jsp");
                    } catch (DAOException daoex) {
                        request.setAttribute("javax.servlet.jsp.jspException", daoex);
                        request.setAttribute("javax.servlet.error.status_code", 500);
                        request.setAttribute("msg", "ERRO: " + daoex.getMessage());
                        rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    } catch (Exception ex) {
                        request.setAttribute("javax.servlet.jsp.jspException", ex);
                        request.setAttribute("javax.servlet.error.status_code", 500);
                        request.setAttribute("msg", "ERRO: " + ex.getMessage());
                        rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    request.setAttribute("msg", "Opção inválida");
                    rd = getServletContext().getRequestDispatcher("/admin/erro.jsp");
                    rd.forward(request, response);
                }

            } else {
                // Conferindo opção ================================================
                if (action.equals("listatendimentos")) { // ======================LISTAR
                    try {
                        List<Atendimento> atendimentos = AtendimentoFacade.buscarTodos();
                        session.setAttribute("atendimentos", atendimentos);
                        response.sendRedirect("admin/atendimentos_funcionario.jsp");
                    } catch (DAOException daoex) {
                        request.setAttribute("javax.servlet.jsp.jspException", daoex);
                        request.setAttribute("javax.servlet.error.status_code", 500);
                        request.setAttribute("msg", "ERRO: " + daoex.getMessage());
                        rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    } catch (Exception ex) {
                        request.setAttribute("javax.servlet.jsp.jspException", ex);
                        request.setAttribute("javax.servlet.error.status_code", 500);
                        request.setAttribute("msg", "ERRO: " + ex.getMessage());
                        rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                } else if (action.equals("modificar")) { // =========================== EDITAR
                    String strId = request.getParameter("id");
                    int id = 0;
                    if (strId == null) {
                        request.setAttribute("msg", "Invocação inválida: id é nulo");
                        rd = request.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                        return;
                    } else {
                        try {
                            id = Integer.parseInt(request.getParameter("id"));
                            Produto produto = ProdutoFacade.buscar(id);
                            session.setAttribute("produto", produto);
                            response.sendRedirect("admin/edit-produto.jsp?action=modificar");
                        } catch (NumberFormatException e) {
                            request.setAttribute("javax.servlet.jsp.jspException", e);
                            request.setAttribute("javax.servlet.error.status_code", 500);
                            request.setAttribute("msg", "Id para apresentação inválido: " + id);
                            rd = request.getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        } catch (DAOException daoex) {
                            request.setAttribute("javax.servlet.jsp.jspException", daoex);
                            request.setAttribute("javax.servlet.error.status_code", 500);
                            request.setAttribute("msg", "ERRO: " + daoex.getMessage());
                            rd = getServletContext().getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        } catch (Exception ex) {
                            request.setAttribute("javax.servlet.jsp.jspException", ex);
                            request.setAttribute("javax.servlet.error.status_code", 500);
                            request.setAttribute("msg", "ERRO: " + ex.getMessage());
                            rd = request.getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        }
                    }
                } else if (action.equals("remover")) { //=========================== REMOVER
                    String strId = request.getParameter("id");
                    int id = 0;
                    if (strId == null) {
                        request.setAttribute("msg", "Invocação inválida: id é nulo");
                        rd = request.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                        return;
                    } else {
                        try {
                            id = Integer.parseInt(strId);
                            ProdutoFacade.remover(id);
                            List<Produto> produtos = ProdutoFacade.buscarTodos();
                            session.setAttribute("produtos", produtos);
                            response.sendRedirect("admin/produtos.jsp");
                        } catch (NumberFormatException e) {
                            request.setAttribute("javax.servlet.jsp.jspException", e);
                            request.setAttribute("javax.servlet.error.status_code", 500);
                            request.setAttribute("msg", "Id para apresentação inválido: " + id);
                            rd = request.getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        } catch (DAOException de) {
                            request.setAttribute("javax.servlet.jsp.jspException", de);
                            request.setAttribute("javax.servlet.error.status_code", 500);
                            request.setAttribute("msg", "ERRO: " + de.getMessage());
                            rd = request.getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        } catch (Exception ex) {
                            request.setAttribute("javax.servlet.jsp.jspException", ex);
                            request.setAttribute("javax.servlet.error.status_code", 500);
                            request.setAttribute("msg", "ERRO: " + ex.getMessage());
                            rd = request.getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        }
                    }
                } else {
                    request.setAttribute("msg", "Opção inválida");
                    rd = getServletContext().getRequestDispatcher("/admin/erro.jsp");
                    rd.forward(request, response);
                }
                // Conferindo opção ================================================
            }
        } else {
            request.setAttribute("msg", "Acesso não autorizado!");
            rd = getServletContext().getRequestDispatcher("/admin/erro.jsp");
            rd.forward(request, response);
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

        RequestDispatcher rd = null;
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        // Conferindo acesso ===================================================
        if (session.getAttribute("login") != null) {
            Login login = (Login) session.getAttribute("login");
            if (login.getTipoUsuario().getId() < 2) {
                if (action.equals("adicionar")) { // ADICIONAR 

                    Date data = new Date();
                    String descricao = request.getParameter("descricao");
                    String strProduto = request.getParameter("produto");
                    String strTipoAtendimento = request.getParameter("tipoatendimento");
                    String strId = request.getParameter("id");
                    if (strId == null) {
                        request.setAttribute("msg", "Invocação inválida: id é nulo");
                        rd = request.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                        return;
                    } else {
                        try {
                            int produto = Integer.parseInt(strProduto);
                            int tipoAtendimento = Integer.parseInt(strTipoAtendimento);
                            int id = Integer.parseInt(strId);
                            AtendimentoFacade.inserir(data, descricao, produto, tipoAtendimento, id);
                            List<Atendimento> atendimentos = AtendimentoFacade.buscarUsuario(id);
                            session.setAttribute("atendimentos", atendimentos);
                            response.sendRedirect("admin/atendimentos_cliente.jsp");
                        } catch (NumberFormatException e) {
                            request.setAttribute("javax.servlet.jsp.jspException", e);
                            request.setAttribute("javax.servlet.error.status_code", 500);
                            request.setAttribute("msg", "Dados para apresentação inválido.");
                            rd = request.getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        } catch (DAOException de) {
                            request.setAttribute("javax.servlet.jsp.jspException", de);
                            request.setAttribute("javax.servlet.error.status_code", 500);
                            request.setAttribute("msg", "ERRO: " + de.getMessage());
                            rd = request.getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        } catch (Exception ex) {
                            request.setAttribute("javax.servlet.jsp.jspException", ex);
                            request.setAttribute("javax.servlet.error.status_code", 500);
                            request.setAttribute("msg", "ERRO: " + ex.getMessage());
                            rd = request.getRequestDispatcher("/erro.jsp");
                            rd.forward(request, response);
                        }
                    }
                } else {
                    request.setAttribute("msg", "Opção inválida");
                    rd = getServletContext().getRequestDispatcher("/admin/erro.jsp");
                    rd.forward(request, response);
                }

            } else {
                // Conferindo opção ================================================
                if (action.equals("listatendimentos")) { // ======================LISTAR
                    try {
                        List<Atendimento> atendimentos = AtendimentoFacade.buscarTodos();
                        session.setAttribute("atendimentos", atendimentos);
                        response.sendRedirect("admin/atendimentos_funcionario.jsp");
                    } catch (DAOException daoex) {
                        request.setAttribute("javax.servlet.jsp.jspException", daoex);
                        request.setAttribute("javax.servlet.error.status_code", 500);
                        request.setAttribute("msg", "ERRO: " + daoex.getMessage());
                        rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    } catch (Exception ex) {
                        request.setAttribute("javax.servlet.jsp.jspException", ex);
                        request.setAttribute("javax.servlet.error.status_code", 500);
                        request.setAttribute("msg", "ERRO: " + ex.getMessage());
                        rd = getServletContext().getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    request.setAttribute("msg", "Opção inválida");
                    rd = getServletContext().getRequestDispatcher("/admin/erro.jsp");
                    rd.forward(request, response);
                }
                // Conferindo opção ================================================
            }
        } else {
            request.setAttribute("msg", "Acesso não autorizado!");
            rd = getServletContext().getRequestDispatcher("/admin/erro.jsp");
            rd.forward(request, response);
        }

    }

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
