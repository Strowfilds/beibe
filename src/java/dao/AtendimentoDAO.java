package dao;

import beans.Atendimento;
import beans.TipoAtendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;
import exceptions.DAOException;
import java.sql.SQLException;

/**
 *
 * @author Ana Nicole
 */
public class AtendimentoDAO extends ConnectionFactory {
    
    private static final String QUERY_BUSCAR_TODOS = "SELECT id_tipo_atendimento, nome_tipo_Atendimento FROM tb_tipo_atendimento";
    private static final String QUERY_BUSCAR = "SELECT id_tipo_atendimento, nome_tipo_Atendimento FROM tb_tipo_atendimento WHERE id_tipo_atendimento = ?";
    
    private Connection con = null;

    public AtendimentoDAO()  throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con = con;
    }

    public void resolver(Atendimento a) {
        try {
            try (Connection conexao = getConexao()) {
                PreparedStatement pstmt;
                pstmt = conexao
                        .prepareStatement("Update atendimento SET solucao = ?, situacao = true where id = ? ");
                pstmt.setString(1, a.getSolucao());
                pstmt.setInt(2, a.getId());

                pstmt.execute();
                pstmt.close();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void alterar(Usuario usuario) {
        try {
            try (Connection conexao = getConexao()) {
                PreparedStatement pstmt;
                pstmt = conexao
                        .prepareStatement("Update usuario SET nome = ?, senha = ?, telefone = ?, cidade = ?, cep = ?, bairro = ?, rua = ?, numero = ?, complemento = ? where email = ? ");
                pstmt.setString(1, usuario.getNome());
                pstmt.setString(2, usuario.getSenha());
                pstmt.setString(3, usuario.getTel());
                pstmt.setInt(4, usuario.getCidade());
                pstmt.setString(5, usuario.getCep());
                pstmt.setString(6, usuario.getBairro());
                pstmt.setString(7, usuario.getRua());
                pstmt.setInt(8, usuario.getNr());
                pstmt.setString(9, usuario.getComplemento());
                pstmt.setString(10, usuario.getEmail());

                pstmt.execute();
                pstmt.close();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void excluir(Atendimento a) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Delete from atendimento where id = ? ")) {
                pstm.setInt(1, a.getId());
                pstm.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean existe(Usuario user) {
        boolean achou = false;
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Select * from usuario where email =	?")) {
                pstm.setString(1, user.getEmail());
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    achou = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return achou;
    }

    public void inserir(Atendimento atendimento) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstmt = conexao.prepareStatement("Insert into atendimento (tipo, produto, cliente, descricao, situacao) values (?,?,?,?,?)")) {

                pstmt.setInt(1, atendimento.getTipoId());
                pstmt.setInt(2, atendimento.getProdutoId());
                pstmt.setString(3, atendimento.getCliente());
                pstmt.setString(4, atendimento.getDescricao());
                pstmt.setBoolean(5, false);
                pstmt.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Atendimento> listar(String email, int status) {
        List<Atendimento> lista = new ArrayList<>();
        Atendimento a;
        TipoAtendimento t;
        try {
            try (Connection conexao = getConexao(); Statement stm = conexao.createStatement()) {
                ResultSet rs, rst;
                PreparedStatement pstm;
                if (email == null) {
                    if (status == 1) {
                        rs = stm.executeQuery("Select * from atendimento WHERE situacao = false ORDER BY id");
                    } else {
                        rs = stm.executeQuery("Select * from atendimento ORDER BY id");
                    }
                } else {

                    pstm = conexao.prepareStatement("Select * from atendimento WHERE cliente = ? ORDER BY id");
                    pstm.setString(1, email);
                    rs = pstm.executeQuery();
                }
                while (rs.next()) {
                    a = new Atendimento();
                    a.setId(rs.getInt("id"));
                    a.setCliente(rs.getString("cliente"));
                    a.setDescricao(rs.getString("descricao"));
                    a.setProduto(rs.getInt("produto"));
                    a.setSituacao(rs.getBoolean("situacao"));
                    a.setSolucao(rs.getString("solucao"));
                    a.setTipo(rs.getInt("tipo"));

                    pstm = conexao.prepareStatement("Select * from tipoatendimento WHERE id = ?");
                    pstm.setInt(1, a.getTipoId());
                    rst = pstm.executeQuery();
                    if (rst.next()) {
                        t = new TipoAtendimento();
                        t.setId(rst.getInt("id"));
                        t.setNome(rst.getString("nome"));

                        a.setTipo(t);
                    }

                    lista.add(a);
                }
            }
        } catch (SQLException e) {
            System.out.println("Listar: " + e);
        }

        return lista;
    }

    public Usuario consultar(Usuario user) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Select * from usuario where email = ? and senha = ?")) {
                pstm.setString(1, user.getEmail());
                pstm.setString(1, user.getSenha());
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    user.setNome(rs.getString("nome"));
                    user.setEmail(rs.getString("email"));
                    user.setSenha(rs.getString("senha"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    public Atendimento Buscar(int a) {
        Atendimento atendimento = new Atendimento();
        TipoAtendimento t;
        try (Connection conexao = getConexao(); PreparedStatement pstm = conexao.prepareStatement("Select * from atendimento where id = ?")) {
            pstm.setInt(1, a);
            ResultSet rs = pstm.executeQuery();
            ResultSet rst;
            PreparedStatement pstmt;
            while (rs.next()) {
                //atendimento.setAbertura(rs.getDate("abertura"));
                // atendimento.setFim(rs.getDate("fim"));
                atendimento.setCliente(rs.getString("cliente"));
                atendimento.setDescricao(rs.getString("descricao"));
                atendimento.setId(rs.getInt("id"));
                atendimento.setProduto(rs.getInt("produto"));
                atendimento.setSituacao(rs.getBoolean("situacao"));
                atendimento.setSolucao(rs.getString("solucao"));
                atendimento.setTipo(rs.getInt("tipo"));

                pstmt = conexao.prepareStatement("Select * from tipoatendimento WHERE id = ?");
                pstmt.setInt(1, atendimento.getTipoId());
                rst = pstmt.executeQuery();
                if (rst.next()) {
                    t = new TipoAtendimento();
                    t.setId(rst.getInt("id"));
                    t.setNome(rst.getString("nome"));

                    atendimento.setTipo(t);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return atendimento;
    }
}
