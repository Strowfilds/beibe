package dao;

import beans.Categoria;
import beans.CategoriaDelSafe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.interfaces.DAO;
import exceptions.DAOException;
import java.sql.SQLException;

public class CategoriaDAO implements DAO<Categoria> {
    
    private static final String QUERY_BUSCAR_TODOS = "SELECT id_categoria, nome_categoria  FROM tb_categoria ";
    private static final String QUERY_BUSCAR = "SELECT id_categoria, nome_categoria FROM tb_categoria WHERE id_categoria = ?";
    private static final String QUERY_BUSCAR_TODOS_DEL_SAFE = "SELECT id_categoria, nome_categoria, deletesafe  FROM tb_categoria WHERE id_categoria = ?";
    private static final String QUERY_INSERIR = "INSERT INTO tb_categoria (nome_categoria) VALUES (?)";
    private static final String QUERY_ATUALIZAR = "UPDATE tb_categoria SET nome_categoria = ? WHERE id_categoria = ?";
    private static final String QUERY_REMOVER = "DELETE FROM tb_categoria WHERE id_categoria = ?";
    
    private Connection con = null;

    public CategoriaDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con = con;
    }

    @Override
    public Categoria buscar(int id) throws DAOException {
        Categoria categoria = null;
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("nome_categoria"));                
            } 
        } catch (SQLException e) {
            throw new DAOException("Erro buscando categoria: " + QUERY_BUSCAR + "/ " + Integer.toString(id), e);
        }
        return categoria;
    }

    @Override
    public List<Categoria> buscarTodos() throws DAOException {
        List<Categoria> categorias = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id_categoria"));
                c.setNome(rs.getString("nome_categoria"));                
                categorias.add(c);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas as categorias: " + QUERY_BUSCAR_TODOS, e);
        }
        return categorias;
    }
    
    public List<CategoriaDelSafe> buscarTodosDelSafe() throws DAOException {
        List<CategoriaDelSafe> categorias = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS_DEL_SAFE)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CategoriaDelSafe c = new CategoriaDelSafe();
                c.setId(rs.getInt("id_categoria"));
                c.setNome(rs.getString("nome_categoria"));                
                c.setDelSafe(rs.getBoolean("del_safe_categoria"));                
                categorias.add(c);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas as categorias: " + QUERY_BUSCAR_TODOS_DEL_SAFE, e);
        }
        return categorias;
    }

    @Override
    public void inserir(Categoria t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_INSERIR)) {
            stmt.setString(1, t.getNome());            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro inserindo categoria: " + QUERY_INSERIR + "/ " + t.toString(), ex);
        }
    }

    @Override
    public void atualizar(Categoria t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_ATUALIZAR)) {
            stmt.setString(1, t.getNome());            
            stmt.setInt(2, t.getId());            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro atualizando categoria: " + QUERY_ATUALIZAR + "/ " + t.toString(), ex);
        }
    }

    @Override
    public void remover(Categoria t) throws DAOException {
         try (PreparedStatement stmt = con.prepareStatement(QUERY_REMOVER)) {
            stmt.setInt(1, t.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro removendo categoria: " + QUERY_REMOVER + "/ " + t.toString(), e);
        }
    }
    
}
