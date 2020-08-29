package servlets;

import beans.Endereco;
import beans.Login;
import beans.Usuario;
import beans.enums.TipoUsuarioEnum;
import facade.UsuarioFacade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

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
        if (action.equals("autocadastro")) { // = = = AUTOCADASTRO = = =            
            try {
                String nome = request.getParameter("nome");
                String cpf = request.getParameter("cpf").replace(".", "").replace("-", "");;
                String email = request.getParameter("email");
                String endereco = request.getParameter("endereco");
                int num = Integer.parseInt(request.getParameter("num"));
                String compl = request.getParameter("compl");
                String bairro = request.getParameter("bairro");
                int cidade = Integer.parseInt(request.getParameter("cidade"));
                int estado = Integer.parseInt(request.getParameter("estado"));
                String cep = request.getParameter("cep");
                String tel = request.getParameter("tel");
                String senha = request.getParameter("senha");
                UsuarioFacade.criarNovoUsuario(nome, cpf, email, endereco, num, compl, bairro, cidade, estado, cep, tel, senha, 1);
                
                Usuario usuario = UsuarioFacade.buscarEmail(email);
                Login login = new Login();
                login.setId(usuario.getId());
                login.setNome(usuario.getNome());
                login.setTipoUsuario(TipoUsuarioEnum.getTipoUsuarioFromInt(usuario.getTipoUsuario().getId()));
                HttpSession session = request.getSession();
                session.setAttribute("login", login);
                response.sendRedirect("admin/index.jsp");
            } catch (NumberFormatException nfe) {

            } catch (Exception ex) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            rd = getServletContext().getRequestDispatcher("/erro.jsp");
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
        return "Servlet de ações relacionadas aos usuários.";
    }// </editor-fold>

}
