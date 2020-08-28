package servlets;

import beans.Login;
import beans.Usuario;
import beans.enums.TipoUsuarioEnum;
import exceptions.BuscarUsuarioException;
import exceptions.DAOException;
import facade.UsuarioFacade;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
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
        request.setAttribute("msg", "Forma de acesso inválida.");
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("/erro.jsp");
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
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        if (senha == null || senha == null) {
            request.setAttribute("msg", "Invocação inválida: login ou senha nulos.");
            rd = request.getRequestDispatcher("admin/erro.jsp");
            rd.forward(request, response);
            return;
        }
        try {
            if (UsuarioFacade.checkLogin(email, senha)) {
                Usuario usuario = UsuarioFacade.buscarEmail(email);
                Login login = new Login();
                login.setId(usuario.getId());
                login.setNome(usuario.getNome());
                login.setTipoUsuario(TipoUsuarioEnum.getTipoUsuarioFromInt(usuario.getTipoUsuario().getId()));
                HttpSession session = request.getSession();
                session.setAttribute("login", login);
                response.sendRedirect("admin/index.jsp");
                //rd = getServletContext().getRequestDispatcher("/admin/index.jsp");
                //rd.forward(request, response);                
            } else {
                request.setAttribute("msg", "Usuário/Senha inválidos.");
                rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
        } catch (BuscarUsuarioException buex) {
            request.setAttribute("msg", "ERRO: " + buex.getMessage());
            rd = request.getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
        } catch (DAOException daoex) {
            request.setAttribute("msg", "ERRO: " + daoex.getMessage());
            rd = request.getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msg", "ERRO: " + ex.getMessage());
            rd = request.getRequestDispatcher("/erro.jsp");
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
        return "Servlet - Login";
    }// </editor-fold>

}
