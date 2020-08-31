package dao;

import beans.Cidade;
import beans.Endereco;
import beans.Endereco;
import beans.Estado;
import dao.interfaces.DAO;
import exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EnderecoDAO implements DAO<Endereco> {

    private static final String QUERY_BUSCAR = "SELECT id_endereco, rua_endereco, numero_endereco, complemento_endereco, bairro_endereco, cep_endereco, id_cidade, id_estado, id_usuario FROM tb_endereco WHERE id_endereco = ?";
    private static final String QUERY_BUSCAR_USUARIO = "SELECT en.id_endereco, en.rua_endereco, en.numero_endereco, en.complemento_endereco, en.bairro_endereco, en.cep_endereco, en.id_cidade, en.id_estado, en.id_usuario FROM tb_endereco AS en JOIN tb_usuario AS us ON us.id_usuario = en.id_usuario WHERE us.id_usuario = ?";
    private static final String QUERY_INSERIR = "INSERT INTO tb_endereco (rua_endereco, numero_endereco, complemento_endereco, bairro_endereco, cep_endereco, id_cidade, id_estado, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String QUERY_ATUALIZAR = "UPDATE tb_endereco SET rua_endereco = ?, numero_endereco = ?, complemento_endereco = ?, bairro_endereco = ?, cep_endereco = ?, id_cidade = ?, id_estado = ? WHERE id_endereco = ?";
    private static final String QUERY_REMOVER = "DELETE FROM tb_endereco WHERE id_endereco = ?";

    private Connection con = null;

    public EnderecoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con = con;
    }

    @Override
    public Endereco buscar(int id) throws DAOException {
        Endereco endereco = null;
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                endereco = new Endereco();
                endereco.setId(rs.getInt("id_endereco"));
                endereco.setEndereco(rs.getString("rua_endereco"));
                endereco.setNumero(rs.getInt("numero_endereco"));
                endereco.setComplemento(rs.getString("complemento_endereco"));
                endereco.setBairro(rs.getString("bairro_endereco"));
                endereco.setCep(rs.getString("cep_endereco"));
                endereco.getCidade().setId(rs.getInt("id_cidade"));
                endereco.getEstado().setId(rs.getInt("id_estado"));
                endereco.setIdUsuario(rs.getInt("id_usuario"));
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando endereco: " + QUERY_BUSCAR + "/ " + Integer.toString(id), e);
        }
        return endereco;
    }

    public Endereco buscarUsuario(int id) throws DAOException {
        Endereco endereco = null;
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_USUARIO)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                endereco = new Endereco();
                endereco.setId(rs.getInt("id_endereco"));
                endereco.setEndereco(rs.getString("rua_endereco"));
                endereco.setNumero(rs.getInt("numero_endereco"));
                endereco.setComplemento(rs.getString("complemento_endereco"));
                endereco.setBairro(rs.getString("bairro_endereco"));
                endereco.setCep(rs.getString("cep_endereco"));
                Cidade cidade = new Cidade();
                endereco.setCidade(cidade);
                endereco.getCidade().setId(rs.getInt("id_cidade"));
                Estado estado = new Estado();
                endereco.setEstado(estado);
                endereco.getEstado().setId(rs.getInt("id_estado"));
                endereco.setIdUsuario(rs.getInt("id_usuario"));
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando endereco: " + QUERY_BUSCAR_USUARIO + "/ " + Integer.toString(id), e);
        }
        return endereco;
    }

    @Override
    public List<Endereco> buscarTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Endereco t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_INSERIR)) {
            stmt.setString(1, t.getEndereco());
            stmt.setInt(2, t.getNumero());
            stmt.setString(3, t.getComplemento());
            stmt.setString(4, t.getBairro());
            stmt.setString(5, t.getCep());
            stmt.setInt(6, t.getCidade().getId());
            stmt.setInt(7, t.getEstado().getId());
            stmt.setInt(8, t.getIdUsuario());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro inserindo endereco: " + QUERY_INSERIR + "/ " + t.toString(), ex);
        }
    }

    @Override
    public void atualizar(Endereco t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_ATUALIZAR)) {
            stmt.setString(1, t.getEndereco());
            stmt.setInt(2, t.getNumero());
            stmt.setString(3, t.getComplemento());
            stmt.setString(4, t.getBairro());
            stmt.setString(5, t.getCep());
            stmt.setInt(6, t.getCidade().getId());
            stmt.setInt(7, t.getEstado().getId());
            stmt.setInt(8, t.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro atualizando endereco: " + QUERY_INSERIR + "/ " + t.toString(), ex);
        }
    }

    @Override
    public void remover(Endereco t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_REMOVER)) {
            stmt.setInt(1, t.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro removendo endereco: " + QUERY_REMOVER + "/ " + t.toString(), ex);
        }
    }

}
