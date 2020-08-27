/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Categoria;
import beans.Usuario;
import dao.CategoriaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dandi
 */
public class CategoriaFacade {
    private CategoriaFacade() {}
    
    public void updateCategoria(Categoria categoria) throws SQLException{
        new CategoriaDAO().alterar(categoria);
    }
            
    public void deleteCategoria(int id) throws SQLException{
        new CategoriaDAO().excluir(id);
    }
    
    public void inserirCategoria(Categoria categoria) throws SQLException{
        new CategoriaDAO().inserir(categoria);
    }
            
    public List<Categoria> listarCategoria() throws SQLException{
        return new CategoriaDAO().listar();
    }
            
    public Usuario getUserByUser(Usuario user) throws SQLException{
        return new CategoriaDAO().consultar(user);
    }
            
    public Usuario login(Usuario user) throws SQLException{
        return new CategoriaDAO().login(user);
    }
            
    public Categoria getCategoriaById(int id) throws SQLException{
        return new CategoriaDAO().Buscar(id);
    }
            
    public int getUltimoValorCategoria() throws SQLException{
        return new CategoriaDAO().Ultimo();
    }
}
