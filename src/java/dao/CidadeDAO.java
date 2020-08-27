package dao;

import beans.Cidade;
import dao.interfaces.DAO;
import exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO implements DAO<Cidade> {

    private static final String QUERY_BUSCAR_TODOS = "SELECT id_cidade, nome_cidade, id_estado FROM tb_cidade";
    private static final String QUERY_BUSCAR_TODOS_ESTADO = "SELECT id_cidade, nome_cidade, id_estado FROM tb_cidade WHERE id_estado = ?";
    private static final String QUERY_BUSCAR = "SELECT id_cidade, nome_cidade, id_estado FROM tb_cidade WHERE id_cidade = ?";
    private static final String QUERY_BUSCAR_ENDERECO = "SELECT ci.id_cidade, ci.nome_cidade, ci.id_estado FROM tb_cidade AS ci JOIN tb_endereco AS en ON en.id_cidade = ci.id_cidade WHERE en.id_endereco = ?";

    private Connection con = null;

    public CidadeDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar CidadeDAO.");
        }
        this.con = con;
    }

    @Override
    public Cidade buscar(int id) throws DAOException {
        Cidade cidade = null;
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cidade = new Cidade();
                cidade.setId(rs.getInt("id_cidade"));
                cidade.setNome(rs.getString("nome_cidade"));
                cidade.setIdEstado(rs.getInt("id_estado"));
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando cidade: " + QUERY_BUSCAR + "/ " + Integer.toString(id), e);
        }
        return cidade;
    }

    @Override
    public List<Cidade> buscarTodos() throws DAOException {
        List<Cidade> cidades = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cidade c = new Cidade();
                c.setId(rs.getInt("id_cidade"));
                c.setNome(rs.getString("nome_cidade"));
                c.setIdEstado(rs.getInt("id_estado"));
                cidades.add(c);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas as cidades: " + QUERY_BUSCAR_TODOS, e);
        }
        return cidades;
    }

    public List<Cidade> buscarTodosEstado(int id) throws DAOException {
        List<Cidade> cidades = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS_ESTADO)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Cidade c = new Cidade();
                c.setId(rs.getInt("id_cidade"));
                c.setNome(rs.getString("nome_cidade"));
                c.setIdEstado(rs.getInt("id_estado"));
                cidades.add(c);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todos as cidades: " + QUERY_BUSCAR_TODOS, e);
        }
        return cidades;
    }

    public Cidade buscarEndereco(int id) throws DAOException {
        Cidade cidade = null;
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_ENDERECO)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cidade = new Cidade();
                cidade.setId(rs.getInt("id_cidade"));
                cidade.setNome(rs.getString("nome_cidade"));
                cidade.setIdEstado(rs.getInt("id_estado"));
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando cidade: " + QUERY_BUSCAR_ENDERECO + "/ " + Integer.toString(id), e);
        }
        return cidade;
    }

    @Override
    public void inserir(Cidade t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Cidade t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Cidade t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
