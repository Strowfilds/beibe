/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class TipoUsuarioDAOTest {

    public TipoUsuarioDAOTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testSomeMethod() {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO(connFactory.getConnection());
            tipoUsuarioDAO.buscar(3);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(TipoUsuarioDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
