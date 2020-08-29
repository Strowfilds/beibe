package servlets;

import beans.Categoria;
import beans.Login;
import exceptions.DAOException;
import facade.CategoriaFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CategoriaServlet", urlPatterns = {"/CategoriaServlet"})
public class CategoriaServlet extends HttpServlet {

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
            out.println("<title>Servlet CategoriaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoriaServlet at " + request.getContextPath() + "</h1>");
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
                request.setAttribute("msg", "Privilégio de acesso insuficiente!");
                rd = getServletContext().getRequestDispatcher("/admin/erro.jsp");
                rd.forward(request, response);
            }
            // Conferindo opção ================================================
            if (action.equals("novo")) { // NOVO                
                response.sendRedirect("admin/edit-categoria.jsp?action=novo");
            } else if (action.equals("adicionar")) { // ADICIONAR
                String categoria = request.getParameter("categoria");

                if (categoria == null) {
                    request.setAttribute("msg", "Invocação inválida: categoria é nulo");
                    rd = request.getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                    return;
                } else {
                    try {
                        CategoriaFacade.inserir(categoria);
                        List<Categoria> categorias = CategoriaFacade.buscarCategorias();
                        session.setAttribute("categorias", categorias);
                        response.sendRedirect("admin/categorias.jsp");
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
            } else if (action.equals("listcategoria")) { // LISTAR
                try {
                    List<Categoria> categorias = CategoriaFacade.buscarCategorias();
                    session.setAttribute("categorias", categorias);
                    response.sendRedirect("admin/categorias.jsp");
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
                String nome = request.getParameter("nome");
                int id = 0;
                if (strId == null) {
                    request.setAttribute("msg", "Invocação inválida: id é nulo");
                    rd = request.getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                    return;
                } else {
                    try {
                        id = Integer.parseInt(request.getParameter("id"));
                        String link = "admin/edit-categoria.jsp?action=modificar&id=" + id + "&nome=" + nome;
                        response.sendRedirect(link);
                    } catch (NumberFormatException e) {
                        request.setAttribute("javax.servlet.jsp.jspException", e);
                        request.setAttribute("javax.servlet.error.status_code", 500);
                        request.setAttribute("msg", "Id para apresentação inválido: " + id);
                        rd = request.getRequestDispatcher("/erro.jsp");
                        rd.forward(request, response);
                    }
                }
            } else if (action.equals("remover")) {
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
                        CategoriaFacade.remover(id);
                        List<Categoria> categorias = CategoriaFacade.buscarCategorias();
                        session.setAttribute("categorias", categorias);
                        response.sendRedirect("admin/categorias.jsp");
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
                request.setAttribute("msg", "Privilégio de acesso insuficiente!");
                rd = getServletContext().getRequestDispatcher("/admin/erro.jsp");
                rd.forward(request, response);
            }
            // Conferindo opção ================================================
            if (action.equals("novo")) { // NOVO                
                response.sendRedirect("admin/edit-categoria.jsp?action=novo");
            } else if (action.equals("adicionar")) { // ADICIONAR
                String categoria = request.getParameter("categoria");
                if (categoria == null) {
                    request.setAttribute("msg", "Invocação inválida: categoria é nulo");
                    rd = request.getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                    return;
                } else {
                    try {
                        CategoriaFacade.inserir(categoria);
                        List<Categoria> categorias = CategoriaFacade.buscarCategorias();
                        session.setAttribute("categorias", categorias);
                        response.sendRedirect("admin/categorias.jsp");
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
            } else if (action.equals("editar")) { // =========================== EDITAR
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
                        String nome = request.getParameter("categoria");
                        CategoriaFacade.atualizar(id, nome);
                        List<Categoria> categorias = CategoriaFacade.buscarCategorias();
                        session.setAttribute("categorias", categorias);
                        response.sendRedirect("admin/categorias.jsp");
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
            } else if (action.equals("remover")) {
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
                        CategoriaFacade.remover(id);
                        List<Categoria> categorias = CategoriaFacade.buscarCategorias();
                        session.setAttribute("categorias", categorias);
                        response.sendRedirect("admin/categorias.jsp");
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
