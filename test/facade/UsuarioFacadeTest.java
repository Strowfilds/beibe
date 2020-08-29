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
public class UsuarioFacadeTest {
    
    
    
    public UsuarioFacadeTest() {
    }
    
    @Before
    public void setUp() {
        
    }

    //@Test
    public void testSomeMethod() {
        try{
         UsuarioFacade.buscarEmail("email@email.email");
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //@Test
    public void teste(){
        System.out.println("Oi");
    }
    
    @Test
    public void testCheckLogin() {
        try{
         assertTrue(UsuarioFacade.checkLogin("email6@email6.email6", "senha"));
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //@Test
    public void adicionarNovoUsuarioTest(){
        //String nome, String cpf, String email, String endereco, int num, String compl, String bairro, int cidade, int estado, String cep, String tel, String psw, int tipoUsuario
        try{
        UsuarioFacade.criarNovoUsuario("Kaique Alexandre Barros", "75873220299", "email6@email6.email6", "Rua Alta Tensão", 722, "AP-34", "Vila Capixaba", 2878, 18, "29148001", "2725498528", "senha", 1);
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
