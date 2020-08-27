package dao;

import beans.TipoAtendimento;
import dao.interfaces.DAO;
import exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoAtendimentoDAO implements DAO<TipoAtendimento> {

    private static final String QUERY_BUSCAR_TODOS = "SELECT id_tipo_atendimento, nome_tipo_Atendimento FROM tb_tipo_atendimento";
    private static final String QUERY_BUSCAR = "SELECT id_tipo_atendimento, nome_tipo_Atendimento FROM tb_tipo_atendimento WHERE id_tipo_atendimento = ?";

    private Connection con = null;

    public TipoAtendimentoDAO() throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con = con;
    }

    @Override
    public TipoAtendimento buscar(int id) throws DAOException {
        TipoAtendimento tipoAtendimento = null;
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tipoAtendimento = new TipoAtendimento();
                tipoAtendimento.setId(rs.getInt("id_tipo_atendimento"));
                tipoAtendimento.setNome(rs.getString("nome_tipo_Atendimento"));
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando tipo atendimento: " + QUERY_BUSCAR + "/ " + Integer.toString(id), e);
        }
        return tipoAtendimento;
    }

    @Override
    public List<TipoAtendimento> buscarTodos() throws DAOException {
        List<TipoAtendimento> tiposAtendimento = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoAtendimento ta = new TipoAtendimento();
                ta.setId(rs.getInt("id_tipo_atendimento"));
                ta.setNome(rs.getString("nome_tipo_Atendimento"));
                tiposAtendimento.add(ta);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os tipos atendimento: " + QUERY_BUSCAR_TODOS, e);
        }
        return tiposAtendimento;
    }

    @Override
    public void inserir(TipoAtendimento t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(TipoAtendimento t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(TipoAtendimento t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
