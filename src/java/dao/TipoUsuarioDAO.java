package dao;

import beans.TipoUsuario;
import beans.TipoUsuario;
import dao.interfaces.DAO;
import exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoUsuarioDAO implements DAO<TipoUsuario>{

    private static final String QUERY_BUSCAR_TODOS = "SELECT id_tipo_usuario, nome_tipo_usuario FROM tb_tipo_usuario";
    
    private Connection con = null;

    public TipoUsuarioDAO()  throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con = con;
    }    
    
    @Override
    public TipoUsuario buscar(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoUsuario> buscarTodos() throws DAOException {
        List<TipoUsuario> tiposUsuario = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoUsuario tu = new TipoUsuario();
                tu.setId(rs.getInt("id_tipo_atendimento"));
                tu.setNome(rs.getString("nome_tipo_Atendimento"));
                tiposUsuario.add(tu);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os tipos atendimento: " + QUERY_BUSCAR_TODOS, e);
        }
        return tiposUsuario;
    }

    @Override
    public void inserir(TipoUsuario t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(TipoUsuario t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(TipoUsuario t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
