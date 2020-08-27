package dao;

import beans.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;
import dao.interfaces.DAO;
import exceptions.DAOException;
import java.sql.SQLException;

public class CategoriaDAO implements DAO<Categoria> {
    
    private static final String QUERY_BUSCAR_TODOS = "SELECT id_tipo_atendimento, nome_tipo_Atendimento FROM tb_tipo_atendimento";
    private static final String QUERY_BUSCAR = "SELECT id_tipo_atendimento, nome_tipo_Atendimento FROM tb_tipo_atendimento WHERE id_tipo_atendimento = ?";
    
    private Connection con = null;

    public CategoriaDAO() throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con = con;
    }

    @Override
    public Categoria buscar(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categoria> buscarTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Categoria t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Categoria t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Categoria t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
