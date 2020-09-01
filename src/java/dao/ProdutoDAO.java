package dao;

import beans.Produto;
import beans.Categoria;
import beans.ProdutoDelSafe;
import dao.interfaces.DAO;
import exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements DAO<Produto> {
    
    private static final String QUERY_BUSCAR = "SELECT id_produto, nome_produto, descricao_produto, id_categoria, peso_produto FROM tb_produto WHERE id_produto = ?";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id_produto, nome_produto, descricao_produto, id_categoria, peso_produto FROM tb_produto";
    private static final String QUERY_BUSCAR_TODOS_SAFE_DEL = "SELECT id_produto, nome_produto, descricao_produto, id_categoria, peso_produto, (SELECT COUNT(id_produto) FROM tb_atendimento pr WHERE pr.id_produto = ca.id_produto) FROM tb_produto AS ca;";
    private static final String QUERY_BUSCAR_CATEGORIA = "SELECT id_produto, nome_produto, descricao_produto, id_categoria, peso_produto FROM tb_produto WHERE id_categoria = ?";
    private static final String QUERY_INSERIR = "INSERT INTO tb_produto(nome_produto, descricao_produto, id_categoria, peso_produto) VALUES(?, ?, ?, ?)";
    private static final String QUERY_ATUALIZAR = "UPDATE tb_produto SET nome_produto = ?, descricao_produto = ?, id_categoria = ?, peso_produto = ? WHERE id_produto = ?";
    private static final String QUERY_REMOVER = "DELETE FROM tb_produto WHERE id_produto = ?";
    
    private Connection con = null;
    
    public ProdutoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar ProdutoDAO.");
        }
        this.con = con;
    }
    
    @Override
    public Produto buscar(int id) throws DAOException {
        Produto produto = new Produto();        
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {                
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setDescricao(rs.getString("descricao_produto"));
                produto.setPeso(rs.getInt("peso_produto"));
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id_categoria"));
                produto.setCategoria(categoria);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando produto: " + QUERY_BUSCAR + "/ " + Integer.toString(id), e);
        }
        return produto;
    }
    
    @Override
    public List<Produto> buscarTodos() throws DAOException {
        List<Produto> produtos = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome_produto"));
                p.setDescricao(rs.getString("descricao_produto"));
                p.setPeso(rs.getInt("peso_produto"));
                Categoria c = new Categoria();
                c.setId(rs.getInt("id_categoria"));
                p.setCategoria(c);
                produtos.add(p);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os produtos: " + QUERY_BUSCAR_TODOS, e);
        }
        return produtos;
    }
    
    public List<ProdutoDelSafe> buscarTodosSafeDel() throws DAOException {
        List<ProdutoDelSafe> produtos = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_TODOS_SAFE_DEL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoDelSafe p = new ProdutoDelSafe();
                p.setId(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome_produto"));
                p.setDescricao(rs.getString("descricao_produto"));
                p.setPeso(rs.getInt("peso_produto"));
                Categoria c = new Categoria();
                c.setId(rs.getInt("id_categoria"));
                p.setCategoria(c);
                p.setDelSafe((rs.getInt("count") == 0 ));   
                produtos.add(p);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os produtos: " + QUERY_BUSCAR_TODOS_SAFE_DEL, e);
        }
        return produtos;
    }
    
    @Override
    public void inserir(Produto t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_INSERIR)) {
            stmt.setString(1, t.getNome());
            stmt.setString(2, t.getDescricao());
            stmt.setInt(3, t.getCategoria().getId());
            stmt.setInt(4, t.getPeso());            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro inserindo produto: " + QUERY_INSERIR + "/ " + t.toString(), ex);
        }
    }
    
    @Override
    public void atualizar(Produto t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_ATUALIZAR)) {
            stmt.setString(1, t.getNome());
            stmt.setString(2, t.getDescricao());
            stmt.setInt(3, t.getCategoria().getId());
            stmt.setInt(4, t.getPeso()); 
            stmt.setInt(5, t.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro atualizando produto: " + QUERY_ATUALIZAR + "/ " + t.toString(), ex);
        }
    }
    
    @Override
    public void remover(Produto t) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_REMOVER)) {
            stmt.setInt(1, t.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro removendo produto: " + QUERY_REMOVER + "/ " + t.toString(), e);
        }
    }
    
}
