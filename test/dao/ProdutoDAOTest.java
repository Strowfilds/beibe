package dao;

import beans.Categoria;
import beans.Estado;
import beans.Produto;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class ProdutoDAOTest {

    Categoria categoria = new Categoria();
    Produto produto = new Produto();

    public ProdutoDAOTest() {
    }

    @Before
    public void setUp() {
        produto.setNome("Teste Produto Nome");
        produto.setDescricao("Teste Produto Descrição");
        categoria.setId(4);
        produto.setCategoria(categoria);
    }

    //@Test
    public void testSomeMethod() {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connFactory.getConnection());
            produtoDAO.inserir(produto);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(EstadoDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testSomeMethodBuscar() {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connFactory.getConnection());
            Produto produto = produtoDAO.buscar(1);
            System.out.println(produto.getNome());
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(EstadoDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
