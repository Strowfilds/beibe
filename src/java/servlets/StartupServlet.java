package servlets;

import beans.Config;
import exceptions.DAOException;
import facade.EnderecoFacade;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "StartupServlet", urlPatterns = {"/StartupServlet"}, loadOnStartup = 1)
public class StartupServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) {
        try {
            Config conf = new Config();
            conf.setTeste("String teste");
            ServletContext ctx = config.getServletContext();
            ctx.setAttribute("configuracao", conf);
            ctx.setAttribute("estados", EnderecoFacade.buscarEstados());            
        } catch (DAOException daoex) {
            throw new RuntimeException(daoex.getMessage(), daoex);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
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
