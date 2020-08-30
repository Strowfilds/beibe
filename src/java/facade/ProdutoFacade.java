package facade;

import beans.Categoria;
import beans.Produto;
import dao.CategoriaDAO;
import dao.ConnectionFactory;
import dao.ProdutoDAO;
import exceptions.DAOException;
import java.util.List;

public class ProdutoFacade {
    
    public static Produto buscar(int id) throws Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connFactory.getConnection());
            Produto produto = produtoDAO.buscar(id);
            CategoriaDAO categoriaDAO = new CategoriaDAO(connFactory.getConnection());
            Categoria categoria = categoriaDAO.buscar(produto.getCategoria().getId());
            produto.setCategoria(categoria);
            return produto;            
        }
    }
    
    public static List<Produto> buscarTodos() throws Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connFactory.getConnection());
            List<Produto> produtos = produtoDAO.buscarTodos();
            CategoriaDAO categoriaDAO = new CategoriaDAO(connFactory.getConnection());
            for(Produto produto: produtos){
                produto.setCategoria(categoriaDAO.buscar(produto.getCategoria().getId()));
            }            
            return produtos;            
        }
    }
    
    public static void remover(Produto produto) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connFactory.getConnection());
            produtoDAO.remover(produto);
        }
    }

    public static void remover(int id) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connFactory.getConnection());
            Produto produto = produtoDAO.buscar(id);
            produtoDAO.remover(produto);
        }
    }   
    
    public static void inserir(Produto produto) throws DAOException, Exception {
    
    }

    public static void inserir(String produto, String descricao, int categoria, int peso) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {        
            ProdutoDAO produtoDAO = new ProdutoDAO(connFactory.getConnection());
            Produto novoProduto = new Produto();
            novoProduto.setNome(produto);
            novoProduto.setDescricao(descricao);
            Categoria novaCategoria = new Categoria();
            novaCategoria.setId(categoria);
            novoProduto.setCategoria(novaCategoria);
            novoProduto.setPeso(peso);
            produtoDAO.inserir(novoProduto);
        }
    }
    
    public static void atualizar(Produto produto) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connFactory.getConnection());            
            produtoDAO.atualizar(produto);
        }
    }   

    public static void atualizar(int id, String nome, String descricao, int categoria, int peso) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {        
            ProdutoDAO produtoDAO = new ProdutoDAO(connFactory.getConnection());
            Produto produto = new Produto();
            produto.setId(id);
            produto.setNome(nome);
            produto.setDescricao(descricao);
            Categoria novaCategoria = new Categoria();
            novaCategoria.setId(categoria);
            produto.setCategoria(novaCategoria);
            produto.setPeso(peso);
            produtoDAO.atualizar(produto);
        }
    }
    
    
}
