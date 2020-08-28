package dao;

import beans.Produto;
import beans.Categoria;
import dao.interfaces.DAO;
import exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements DAO<Produto> {
    
    private static final String QUERY_BUSCAR_TODOS = "SELECT id_produto, nome_produto, descricao_produto, id_categoria, peso_categoria FROM tb_produto";
    private static final String QUERY_BUSCAR = "SELECT id_produto, nome_produto, descricao_produto, id_categoria, peso_categoria FROM tb_produto WHERE id_produto = ?";
    private static final String QUERY_BUSCAR_CATEGORIA = "SELECT id_tipo_atendimento, nome_tipo_Atendimento FROM tb_tipo_atendimento WHERE id_tipo_atendimento = ?";
    
    private Connection con = null;
    
    ProdutoDAO(Connection con) throws DAOException {
    if (con == null) {
            throw new DAOException("Conexão nula ao criar ProdutoDAO.");
        }
        this.con = con;
    }

    @Override
    public Produto buscar(int id) throws DAOException {
        Produto produto = null;
        Categoria categoria = null;
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                categoria = new Categoria();
                produto.setId(rs.getInt("id_produto"));
                categoria.setId(rs.getInt("id_categoria"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setDescricao(rs.getString("descricao_produto"));
                produto.setPeso(rs.getInt("peso_categoria"));
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando estado: " + QUERY_BUSCAR + "/ " + Integer.toString(id), e);
        }
        return produto;
    }

    @Override
    public List<Produto> buscarTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Produto t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Produto t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Produto t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
