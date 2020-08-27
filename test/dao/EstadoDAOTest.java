/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Estado;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class EstadoDAOTest {

    public EstadoDAOTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testSomeMethod() {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            EstadoDAO estadoDAO = new EstadoDAO(connFactory.getConnection());
            System.out.println("+++ TESTE");
            Estado estado = estadoDAO.buscar(1);
            System.out.println("+++ ESTADO: " + estado.getNome());
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(EstadoDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
