package dao;

import exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectionFactoryTest {
    
    public ConnectionFactoryTest() {
    }
    
    @Before
    public void setUp() {
    }

    //@Test
    public void testSomeMethod() {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            assertNotNull(connFactory.getConnection());
            
        } catch (DAOException ex) {
            Logger.getLogger(ConnectionFactoryTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ConnectionFactoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    
    
    @Test
    public void testeConnDB(){
        try{
        ConnectionFactory connFactory = new ConnectionFactory();
        Connection conn = connFactory.getConnection();
        PreparedStatement prst = conn.prepareStatement("SELECT id_estado, sigla_estado, nome_estado FROM tb_estado WHERE id_estado = 1;");
        ResultSet rs = prst.executeQuery();
        } catch (DAOException | SQLException ex) {
            Logger.getLogger(ConnectionFactoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
