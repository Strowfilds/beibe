package servlets;

import beans.Categoria;
import beans.CategoriaDelSafe;
import beans.Login;
import exceptions.DAOException;
import facade.CategoriaFacade;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CategoriaServlet", urlPatterns = {"/CategoriaServlet"})
public class CategoriaServlet extends HttpServlet {

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
            if (session.getAttribute("login") != null) {
                Login login = (Login) session.getAttribute("login");
                if (login.getTipoUsuario().getId() < 2) {
                    // ========================================================= Privilégio insuficiente
                    session.setAttribute("msg", "Privilégio de acesso insuficiente!");
                    response.sendRedirect("/admin/erro.jsp");
                } else {
                    if (action.equals("novo")) {
                        // ===================================================== Nova categoria
                        response.sendRedirect("admin/edit-categoria.jsp?action=novo");
                    } else if (action.equals("listcategoria")) {
                        // ===================================================== Listar categorias
                        List<CategoriaDelSafe> categorias = CategoriaFacade.buscarCategoriasDelSafe();
                        session.setAttribute("categorias", categorias);
                        response.sendRedirect("admin/categorias.jsp");
                    } else if (action.equals("modificar")) {
                        // ===================================================== Modificar categoria
                        String strId = request.getParameter("id");
                        String nome = request.getParameter("nome");
                        int id = 0;
                        if (strId == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("/erro.jsp");
                            return;
                        } else {
                            id = Integer.parseInt(request.getParameter("id"));
                            String link = "admin/edit-categoria.jsp?action=modificar&id=" + id + "&nome=" + nome;
                            response.sendRedirect(link);
                        }
                    } else if (action.equals("remover")) {
                        // ===================================================== Remover categoria
                        String strId = request.getParameter("id");
                        int id = 0;
                        if (strId == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("/erro.jsp");
                            return;
                        } else {
                            id = Integer.parseInt(request.getParameter("id"));
                            CategoriaFacade.remover(id);
                            List<CategoriaDelSafe> categorias = CategoriaFacade.buscarCategoriasDelSafe();
                            session.setAttribute("categorias", categorias);
                            response.sendRedirect("admin/categorias.jsp");
                        }
                    } else {
                        // ===================================================== Opção invalida
                        session.setAttribute("msg", "Opção inválida");
                        response.sendRedirect("erro.jsp");
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
                Login login = (Login) session.getAttribute("login");
                if (login.getTipoUsuario().getId() < 2) {
                    // ========================================================= Privilégio insuficiente
                    session.setAttribute("msg", "Privilégio de acesso insuficiente!");
                    response.sendRedirect("/admin/erro.jsp");
                } else {
                    if (action.equals("adicionar")) {
                        // ===================================================== Adicionar categoria
                        String categoria = request.getParameter("categoria");
                        if (categoria == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("/erro.jsp");
                            return;
                        } else {
                            CategoriaFacade.inserir(categoria);
                            List<CategoriaDelSafe> categorias = CategoriaFacade.buscarCategoriasDelSafe();
                            session.setAttribute("categorias", categorias);
                            response.sendRedirect("admin/categorias.jsp");
                        }
                    } else if (action.equals("editar")) {
                        // ===================================================== Editar categoria
                        String strId = request.getParameter("id");
                        int id = 0;
                        if (strId == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("/erro.jsp");
                            return;
                        } else {
                            id = Integer.parseInt(request.getParameter("id"));
                            String nome = request.getParameter("categoria");
                            CategoriaFacade.atualizar(id, nome);
                            List<Categoria> categorias = CategoriaFacade.buscarCategorias();
                            session.setAttribute("categorias", categorias);
                            response.sendRedirect("admin/categorias.jsp");
                        }
                    } else if (action.equals("remover")) {
                        // ===================================================== Remover categoria
                        String strId = request.getParameter("id");
                        int id = 0;
                        if (strId == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("/erro.jsp");
                            return;
                        } else {
                            id = Integer.parseInt(request.getParameter("id"));
                            CategoriaFacade.remover(id);
                            List<CategoriaDelSafe> categorias = CategoriaFacade.buscarCategoriasDelSafe();
                            session.setAttribute("categorias", categorias);
                            response.sendRedirect("admin/categorias.jsp");
                        }
                    } else {
                        // ===================================================== Opção invalida
                        session.setAttribute("msg", "Opção inválida");
                        response.sendRedirect("erro.jsp");
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
