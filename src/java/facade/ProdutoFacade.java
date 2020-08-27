/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Produto;
import beans.Usuario;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tacid
 */
public class ProdutoFacade {
    private ProdutoFacade(){}
    
    public void alterarProduto(Produto produto) throws SQLException{
        new ProdutoDAO().alterar(produto);
    }
    
    public void excluirProduto(int id)  throws SQLException{
        new ProdutoDAO().excluir(id);
    }
    
    public boolean checkExisteProduto(Usuario user)  throws SQLException{
        return new ProdutoDAO().existe(user);
    }
    
    public void inserirProduto(Produto p)  throws SQLException{
        new ProdutoDAO().inserir(p);
    }
    
    public List<Produto> listarProdutos()  throws SQLException{
        return new ProdutoDAO().listar();
    }
    
    public List<Produto> listarProdutosByCategoria(int categoria)  throws SQLException{
        return new ProdutoDAO().listar(categoria);
    }
    
    public Usuario consultarUsuario(Usuario user)  throws SQLException{
        return new ProdutoDAO().consultar(user);
    }
    
    public Usuario loginUsuario(Usuario user)  throws SQLException{
        return new ProdutoDAO().login(user);
    }
    
    public Produto buscarProduto(int id)  throws SQLException{
        return new ProdutoDAO().Buscar(id);
    }
    
    public int getUltimoProduto()  throws SQLException{
        return new ProdutoDAO().Ultimo();
    }              
}
