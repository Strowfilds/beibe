package facade;

import beans.Categoria;
import beans.Usuario;
import dao.CategoriaDAO;
import dao.ConnectionFactory;
import exceptions.DAOException;
import java.util.List;

public class CategoriaFacade {

    public static Categoria buscar(int id) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connFactory.getConnection());
            Categoria categoria = categoriaDAO.buscar(id);
            return categoria;
        }
    }

    public static List<Categoria> buscarCategorias() throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connFactory.getConnection());
            return categoriaDAO.buscarTodos();
        }
    }

    public static void inserir(Categoria categoria) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connFactory.getConnection());
            categoriaDAO.inserir(categoria);
        }
    }

    public static void inserir(String nome) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connFactory.getConnection());
            Categoria categoria = new Categoria();
            categoria.setNome(nome);
            categoriaDAO.inserir(categoria);
        }
    }

    public static void atualizar(Categoria categoria) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connFactory.getConnection());
            categoriaDAO.atualizar(categoria);
        }
    } 
    
    public static void atualizar(int id, String nome) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connFactory.getConnection());
            Categoria categoria = new Categoria();
            categoria.setId(id);
            categoria.setNome(nome);
            categoriaDAO.atualizar(categoria);
        }
    } 

    public static void remover(Categoria categoria) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connFactory.getConnection());
            categoriaDAO.remover(categoria);
        }
    }

}
