package dao;

import beans.Atendimento;
import beans.Produto;
import beans.TipoAtendimento;
import beans.Usuario;
import dao.interfaces.DAO;
import exceptions.DAOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDAO implements DAO<Atendimento> {

    private static final String QUERY_BUSCAR = "SELECT id_atendimento, data_hora_atendimento, atendimento_aberto, descricao_atendimento, solucao_atendimento, id_produto, id_tipo_atendimento, id_usuario FROM tb_atendimento WHERE id_atendimento = ?";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id_atendimento, data_hora_atendimento, atendimento_aberto, descricao_atendimento, solucao_atendimento, id_produto, id_tipo_atendimento, id_usuario FROM tb_atendimento";
    private static final String QUERY_BUSCAR_TODOS_ABERTOS = "SELECT id_atendimento, data_hora_atendimento, atendimento_aberto, descricao_atendimento, solucao_atendimento, id_produto, id_tipo_atendimento, id_usuario FROM tb_atendimento WHERE atendimento_aberto = 't'";
    private static final String QUERY_BUSCAR_TODOS_USUARIO = "SELECT id_atendimento, data_hora_atendimento, atendimento_aberto, descricao_atendimento, solucao_atendimento, id_produto, id_tipo_atendimento, id_usuario FROM tb_atendimento WHERE id_usuario = ?";
    private static final String QUERY_INSERIR = "INSERT INTO tb_atendimento (data_hora_atendimento, atendimento_aberto, descricao_atendimento, solucao_atendimento, id_produto, id_tipo_atendimento, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String QUERY_ATUALIZAR = "UPDATE tb_atendimento SET atendimento_aberto = ?, descricao_atendimento = ?, solucao_atendimento = ?, id_produto = ? WHERE id_atendimento = ?";
    private static final String QUERY_REMOVER = "DELETE FROM tb_atendimento WHERE id_atendimento = ?";

    private Connection con = null;

    public AtendimentoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con = con;
    }

    @Override
    public Atendimento buscar(int id) throws DAOException {
        Atendimento atendimento = null;
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                atendimento = new Atendimento();
                atendimento.setId(rs.getInt("id_atendimento"));
                atendimento.setDataHora(rs.getDate("data_hora_atendimento"));
                atendimento.setAberto(rs.getBoolean("atendimento_aberto"));
                atendimento.setDescricao(rs.getString("descricao_atendimento"));
                atendimento.setSolucao(rs.getString("solucao_atendimento"));
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_produto"));
                atendimento.setProduto(produto);
                TipoAtendimento tipoAtendimento = new TipoAtendimento();
                tipoAtendimento.setId(rs.getInt("id_tipo_atendimento"));
                atendimento.setTipoAtendimento(tipoAtendimento);
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                atendimento.setUsuario(usuario);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando atendimento: " + QUERY_BUSCAR + "/ " + Integer.toString(id), e);
        }
        return atendimento;
    }

    @Override
    public List<Atendimento> buscarTodos() throws DAOException {
        List<Atendimento> atendimentos = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento = new Atendimento();
                atendimento.setId(rs.getInt("id_atendimento"));
                atendimento.setDataHora(rs.getDate("data_hora_atendimento"));
                atendimento.setAberto(rs.getBoolean("atendimento_aberto"));
                atendimento.setDescricao(rs.getString("descricao_atendimento"));
                atendimento.setSolucao(rs.getString("solucao_atendimento"));
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_produto"));
                atendimento.setProduto(produto);
                TipoAtendimento tipoAtendimento = new TipoAtendimento();
                tipoAtendimento.setId(rs.getInt("id_tipo_atendimento"));
                atendimento.setTipoAtendimento(tipoAtendimento);
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                atendimento.setUsuario(usuario);
                atendimentos.add(atendimento);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os atendimentos: " + QUERY_BUSCAR_TODOS, e);
        }
        return atendimentos;
    }

    public List<Atendimento> buscarTodosAbertos() throws DAOException {
        List<Atendimento> atendimentos = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS_ABERTOS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento = new Atendimento();
                atendimento.setId(rs.getInt("id_atendimento"));
                atendimento.setDataHora(rs.getDate("data_hora_atendimento"));
                atendimento.setAberto(rs.getBoolean("atendimento_aberto"));
                atendimento.setDescricao(rs.getString("descricao_atendimento"));
                atendimento.setSolucao(rs.getString("solucao_atendimento"));
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_produto"));
                atendimento.setProduto(produto);
                TipoAtendimento tipoAtendimento = new TipoAtendimento();
                tipoAtendimento.setId(rs.getInt("id_tipo_atendimento"));
                atendimento.setTipoAtendimento(tipoAtendimento);
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                atendimento.setUsuario(usuario);
                atendimentos.add(atendimento);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os atendimentos abertos: " + QUERY_BUSCAR_TODOS, e);
        }
        return atendimentos;
    }

    public List<Atendimento> buscarUsuario(int id) throws DAOException {
               List<Atendimento> atendimentos = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS_USUARIO)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento = new Atendimento();
                atendimento.setId(rs.getInt("id_atendimento"));
                atendimento.setDataHora(rs.getDate("data_hora_atendimento"));
                atendimento.setAberto(rs.getBoolean("atendimento_aberto"));
                atendimento.setDescricao(rs.getString("descricao_atendimento"));
                atendimento.setSolucao(rs.getString("solucao_atendimento"));
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_produto"));
                atendimento.setProduto(produto);
                TipoAtendimento tipoAtendimento = new TipoAtendimento();
                tipoAtendimento.setId(rs.getInt("id_tipo_atendimento"));
                atendimento.setTipoAtendimento(tipoAtendimento);
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                atendimento.setUsuario(usuario);
                atendimentos.add(atendimento);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os atendimentos do usuario: " + QUERY_BUSCAR_TODOS_USUARIO, e);
        }
        return atendimentos;
    }

    @Override
    public void inserir(Atendimento t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_INSERIR)) {
            stmt.setDate(1, new Date(t.getDataHora().getTime()));
            stmt.setBoolean(2, t.isAberto());
            stmt.setString(3, t.getDescricao());
            stmt.setString(4, t.getSolucao());
            stmt.setInt(5, t.getProduto().getId());
            stmt.setInt(6, t.getTipoAtendimento().getId());
            stmt.setInt(7, t.getUsuario().getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro inserindo atendimento: " + QUERY_INSERIR + "/ " + t.toString(), ex);
        }
    }

    @Override
    public void atualizar(Atendimento t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_ATUALIZAR)) {
            stmt.setBoolean(1, t.isAberto());
            stmt.setString(2, t.getDescricao());
            stmt.setString(3, t.getSolucao());
            stmt.setInt(4, t.getProduto().getId());
            stmt.setInt(5, t.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro atualizando atendimento: " + QUERY_ATUALIZAR + "/ " + t.toString(), ex);
        }
    }

    @Override
    public void remover(Atendimento t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_REMOVER)) {
            stmt.setInt(1, t.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro removendo atendimento: " + QUERY_REMOVER + "/ " + t.toString(), e);
        }
    }

}
