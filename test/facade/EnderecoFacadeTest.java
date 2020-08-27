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
public class EnderecoFacadeTest {
    
    public EnderecoFacadeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSomeMethod() {
        try {
            assertTrue(EnderecoFacade.buscar(1).getId() == 1);
        } catch (Exception ex) {
            Logger.getLogger(EnderecoFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
