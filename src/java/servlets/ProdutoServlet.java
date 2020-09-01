package servlets;

import beans.Categoria;
import beans.Login;
import beans.Produto;
import beans.ProdutoDelSafe;
import exceptions.DAOException;
import facade.CategoriaFacade;
import facade.ProdutoFacade;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

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
                if (login.getTipoUsuario().getId() < 2) {
                    // ========================================================= Privilégio insuficiente
                    session.setAttribute("msg", "Acesso não autorizado!");
                    response.sendRedirect("admin/erro.jsp");
                } else {
                    if (action.equals("novo")) {
                        List<Categoria> categorias = CategoriaFacade.buscarCategorias();
                        session.setAttribute("categorias", categorias);
                        response.sendRedirect("admin/edit-produto.jsp?action=novo");
                    } else if (action.equals("listproduto")) {
                        List<ProdutoDelSafe> produtos = ProdutoFacade.buscarTodosSafeDel();
                        session.setAttribute("produtos", produtos);
                        response.sendRedirect("admin/produtos.jsp");
                    } else if (action.equals("modificar")) {
                        String strId = request.getParameter("id");
                        int id = 0;
                        if (strId == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("admin/erro.jsp");
                            return;
                        } else {
                            id = Integer.parseInt(request.getParameter("id"));
                            Produto produto = ProdutoFacade.buscar(id);
                            session.setAttribute("produto", produto);
                            response.sendRedirect("admin/edit-produto.jsp?action=modificar");
                        }
                    } else if (action.equals("remover")) {
                        String strId = request.getParameter("id");
                        int id = 0;
                        if (strId == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("admin/erro.jsp");
                            return;
                        } else {
                            id = Integer.parseInt(strId);
                            ProdutoFacade.remover(id);
                            List<ProdutoDelSafe> produtos = ProdutoFacade.buscarTodosSafeDel();
                            session.setAttribute("produtos", produtos);
                            response.sendRedirect("admin/produtos.jsp");
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
                if (login.getTipoUsuario().getId() < 2) {
                    // ========================================================= Privilégio insuficiente
                    session.setAttribute("msg", "Acesso não autorizado!");
                    response.sendRedirect("admin/erro.jsp");
                } else {
                    if (action.equals("adicionar")) {
                        String produto = request.getParameter("produto");
                        String categoriaStr = request.getParameter("categoria");
                        String descricao = request.getParameter("descricao");
                        String pesoStr = request.getParameter("peso");
                        int categoria = Integer.parseInt(categoriaStr);
                        int peso = Integer.parseInt(pesoStr);
                        ProdutoFacade.inserir(produto, descricao, categoria, peso);
                        List<ProdutoDelSafe> produtos = ProdutoFacade.buscarTodosSafeDel();
                        session.setAttribute("produtos", produtos);
                        response.sendRedirect("admin/produtos.jsp");
                    } else if (action.equals("editar")) {
                        String strId = request.getParameter("id");
                        String nome = request.getParameter("produto");
                        String strCategoria = request.getParameter("categoria");
                        String descricao = request.getParameter("descricao");
                        String strPeso = request.getParameter("peso");
                        int id = 0;
                        int peso = 0;
                        int categoria = 0;
                        if (strId == null) {
                            session.setAttribute("msg", "Invocação inválida: id é nulo");
                            response.sendRedirect("admin/erro.jsp");
                            return;
                        } else {
                            id = Integer.parseInt(strId);
                            peso = Integer.parseInt(strPeso);
                            categoria = Integer.parseInt(strCategoria);
                            ProdutoFacade.atualizar(id, nome, descricao, categoria, peso);
                            List<ProdutoDelSafe> produtos = ProdutoFacade.buscarTodosSafeDel();
                            session.setAttribute("produtos", produtos);
                            response.sendRedirect("admin/produtos.jsp");
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
