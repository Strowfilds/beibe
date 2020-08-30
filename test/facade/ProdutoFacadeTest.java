/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import exceptions.DAOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class ProdutoFacadeTest {
    
    public ProdutoFacadeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSomeMethod() {
        try{
        assertNotNull(ProdutoFacade.buscarTodos());
        } catch (DAOException ex) {
            ex.getMessage();
            ex.printStackTrace();
            Logger.getLogger(UsuarioFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
