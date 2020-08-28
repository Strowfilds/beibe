package servlets;

import beans.Usuario;
import exceptions.DAOException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

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
        RequestDispatcher rd = null;
        request.setAttribute("msg", "Acesso não autorizado!");
        rd = getServletContext().getRequestDispatcher("/erro.jsp");
        rd.forward(request, response);
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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = null;
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        if (login == null || senha == null) {
            request.setAttribute("msg", "Invocação inválida: login ou senha nulos.");
            rd = request.getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
            return;
        }
        try {
            if (UsuariosFacade.checkLogin(login, senha)) {
                Usuario usuario = UsuariosFacade.getUsuario(login);
                LoginBean loginBean = new LoginBean(usuario.getIdUsuario(), usuario.getLoginUsuario());
                HttpSession session = request.getSession();
                session.setAttribute("dadosLogin", loginBean);
                rd = getServletContext().getRequestDispatcher("/portal.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Usuário/Senha inválidos.");
                rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
        } catch (CheckLoginException cle) {
            request.setAttribute("javax.servlet.jsp.jspException", cle);
            request.setAttribute("javax.servlet.error.status_code", 500);
            request.setAttribute("msg", "ERRO: " + cle.getMessage());
            rd = request.getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
        } catch (DAOException dex) {
            request.setAttribute("msg", "ERRO: " + dex.getMessage());
            rd = request.getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msg", "ERRO: " + ex.getMessage());
            rd = request.getRequestDispatcher("/erro.jsp");
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
