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
        
        HttpSession session = request.getSession();
        session.setAttribute("msg", "Forma de acesso inválida.");
        session.setAttribute("code", 400);
        response.sendRedirect("erro.jsp");
        
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

        // ===================================================================== INÍCIO/Recuperando dados <form>
        RequestDispatcher rd = null;
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        // ===================================================================== Verificando se os dados são válidos
        if (senha == null || senha == null) {
            session.setAttribute("msg", "Invocação inválida: login ou senha nulos.");
            response.sendRedirect("erro.jsp");
            return;
        }
        // ===================================================================== Verificando o login
        try {
            if (UsuarioFacade.checkLogin(email, senha)) {
        // ===================================================================== Configurando acesso                
                Usuario usuario = UsuarioFacade.buscarEmail(email);
                Login login = new Login();
                login.setId(usuario.getId());
                login.setNome(usuario.getNome());
                login.setTipoUsuario(TipoUsuarioEnum.getTipoUsuarioFromInt(usuario.getTipoUsuario().getId()));
                session = request.getSession();
                session.setAttribute("login", login);
                response.sendRedirect("AtendimentoServlet?action=home");                
            } else {
                session.setAttribute("msg", "Usuário/Senha inválidos.");
                session.setAttribute("code", 401);
                response.sendRedirect("erro.jsp");
            }
        } catch (BuscarUsuarioException buex) {
            session.setAttribute("code", "400.");
            session.setAttribute("msg", "ERRO: " + buex.getMessage());
            response.sendRedirect("erro.jsp");
        } catch (DAOException daoex) {
            session.setAttribute("code", "400.");
            session.setAttribute("msg", "ERRO: " + daoex.getMessage());
            response.sendRedirect("erro.jsp");
        } catch (Exception ex) {
            session.setAttribute("code", "500.");
            session.setAttribute("msg", "ERRO: " + ex.getMessage());
            response.sendRedirect("erro.jsp");
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
