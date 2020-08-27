/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Usuario;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ana
 */
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
        
        response.setContentType("text/html;charset=UTF-8");
        UsuarioDAO user = new UsuarioDAO();
        Usuario usuario = new Usuario();

        usuario.setEmail(request.getParameter("login"));
        usuario.setSenha(request.getParameter("senha"));

        usuario = user.login(usuario);

        if (usuario.getNome() != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", usuario);
            session.setAttribute("login", usuario.getEmail());
            session.setAttribute("perfil", usuario.getPerfil());
            switch (usuario.getPerfilId()) {
                case 1:
                    {
                        RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/portalCliente.jsp");
                        rd.forward(request, response);
                        break;
                    }
                case 2:
                    {
                        RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/portalFuncionario.jsp");
                        rd.forward(request, response);
                        break;
                    }
                case 3:
                    {
                        RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/portalGerente.jsp");
                        rd.forward(request, response);
                        break;
                    }
                default:
                    {
                        RequestDispatcher rd = getServletContext().
                                getRequestDispatcher("/index.jsp");
                        rd.forward(request, response);
                        break;
                    }
            }
            System.out.println(usuario.getPerfil());
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("msg", "Usuário/Senha inválidos.");
            rd.forward(request, response);
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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
