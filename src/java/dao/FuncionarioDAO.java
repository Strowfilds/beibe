package dao;

import beans.Cidade;
import beans.TipoUsuario;
import beans.Usuario;
import dao.interfaces.DAO;
import exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements DAO<Usuario> {

    private static final String QUERY_INSERIR = "INSERT INTO tb_usuario (nome_usuario, cpf_usuario, email_usuario, telefone_usuario, senha_usuario, id_tipo_usuario) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id_usuario, nome_usuario, cpf_usuario, email_usuario, telefone_usuario, senha_usuario, id_tipo_usuario FROM tb_usuario WHERE id_tipo_usuario = 2 OR id_tipo_usuario = 3";
    private static final String QUERY_REMOVER = "DELETE FROM tb_usuario WHERE id_usuario = ?";
    private static final String QUERY_BUSCAR = "SELECT id_usuario, nome_usuario, cpf_usuario, email_usuario, telefone_usuario, senha_usuario, id_tipo_usuario FROM tb_usuario WHERE id_usuario = ?";
    private static final String QUERY_ATUALIZAR = "UPDATE tb_usuario SET nome_usuario = ?, telefone_usuario = ?, senha_usuario = ? WHERE id_usuario = ?";

    private Connection con = null;

    public FuncionarioDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar UsuarioDAO.");
        }
        this.con = con;
    }

    @Override
    public Usuario buscar(int id) throws DAOException {
        Usuario usuario = null;
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setCpf(rs.getString("cpf_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setTelefone(rs.getString("telefone_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                TipoUsuario tipoUsuario = new TipoUsuario();
                tipoUsuario.setId(rs.getInt("id_tipo_usuario"));
                usuario.setTipoUsuario(tipoUsuario);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando usuario: " + QUERY_BUSCAR + "/ " + Integer.toString(id), e);
        }
        return usuario;
    }

    @Override
    public List<Usuario> buscarTodos() throws DAOException {
        List<Usuario> usuarios = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = null;
                usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setCpf(rs.getString("cpf_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setTelefone(rs.getString("telefone_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                TipoUsuario tipoUsuario = new TipoUsuario();
                tipoUsuario.setId(rs.getInt("id_tipo_usuario"));
                usuario.setTipoUsuario(tipoUsuario);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os funcionarios: " + QUERY_BUSCAR_TODOS, e);
        }
        return usuarios;
    }

    @Override
    public void inserir(Usuario t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_INSERIR)) {
            stmt.setString(1, t.getNome());
            stmt.setString(2, t.getCpf());
            stmt.setString(3, t.getEmail());
            stmt.setString(4, t.getTelefone());
            stmt.setString(5, t.getSenha());
            stmt.setInt(6, t.getTipoUsuario().getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro inserindo funcionario: " + QUERY_INSERIR + "/ " + t.toString(), ex);
        }
    }

    @Override
    public void atualizar(Usuario t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_ATUALIZAR)) {
            stmt.setString(1, t.getNome());
            stmt.setString(2, t.getTelefone());
            stmt.setString(3, t.getSenha());
            stmt.setInt(4, t.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro atualizando funcionario: " + QUERY_ATUALIZAR + "/ " + t.toString(), ex);
        }
    }

    @Override
    public void remover(Usuario t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_REMOVER)) {
            stmt.setInt(1, t.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro removendo usuario: " + QUERY_REMOVER + "/ " + t.toString(), e);
        }
    }

}
