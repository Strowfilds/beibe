/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class UsuarioFacadeTest {
    
    public UsuarioFacadeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSomeMethod() {
        try{
         UsuarioFacade.buscarEmail("email@email.email");
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //@Test
    public void testCheckLogin() {
        try{
         assertTrue(UsuarioFacade.checkLogin("email@email.email", "senha"));
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
