/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Categoria;
import beans.Produto;
import beans.TipoAtendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Ana Nicole
 */
public class ProdutoDAO extends ConnectionFactory {

    public ProdutoDAO() {
    }

    public void alterar(Produto produto) {
        try {
            try (Connection conexao = getConexao()) {
                PreparedStatement pstmt;
                pstmt = conexao
                        .prepareStatement("Update produto SET nome = ?, descricao = ?, peso = ?, categoria = ? where id = ? ");
                pstmt.setString(1, produto.getNome());
                pstmt.setString(2, produto.getDescricao());
                pstmt.setInt(3, produto.getPeso());
                pstmt.setInt(4, produto.getCategoriaId());
                pstmt.setInt(5, produto.getId());
            
                pstmt.execute();
                pstmt.close();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void excluir(int id) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Delete from produto where id = ? ")) {
                pstm.setInt(1, id);
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

    public void inserir(Produto p) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstmt = conexao.prepareStatement("Insert into produto (id,nome,descricao,categoria,peso) values (?,?,?,?,?)")) {

                pstmt.setInt(1, p.getId());
                pstmt.setString(2, p.getNome());
                pstmt.setString(3, p.getDescricao());
                pstmt.setInt(4, p.getCategoriaId());
                pstmt.setInt(5, p.getPeso());
                pstmt.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        Produto p;
        Categoria c;
        try {
            try (Connection conexao = getConexao(); Statement stm = conexao.createStatement()) {
                ResultSet rs = stm.executeQuery("Select * from produto ORDER BY id");
                ResultSet rst;
                PreparedStatement pstm;
                while (rs.next()) {
                    p = new Produto();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setCategoria(rs.getInt("categoria"));
                    p.setPeso(rs.getInt("peso"));
                    
                    pstm = conexao.prepareStatement("Select * from categoria WHERE id = ?");
                    pstm.setInt(1, p.getCategoriaId());
                    rst = pstm.executeQuery();
                    if(rst.next()){
                        c = new Categoria();
                        c.setId(rst.getInt("id"));
                        c.setNome(rst.getString("nome"));
                        
                        p.setCategoria(c);
                    }
                    
                    lista.add(p);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
public List<Produto> listar(int categoria) {
        List<Produto> lista = new ArrayList<>();
        Produto p;
        Categoria c;
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao.prepareStatement("Select * from produto WHERE categoria = ? ORDER BY id")) {
                pstm.setInt(1, categoria);
                ResultSet rs = pstm.executeQuery();
                ResultSet rst;
                PreparedStatement stm;
                while (rs.next()) {
                    p = new Produto();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setCategoria(rs.getInt("categoria"));
                    p.setPeso(rs.getInt("peso"));
                    
                    stm = conexao.prepareStatement("Select * from categoria WHERE id = ?");
                    stm.setInt(1, p.getCategoriaId());
                    rst = stm.executeQuery();
                    if(rst.next()){
                        c = new Categoria();
                        c.setId(rst.getInt("id"));
                        c.setNome(rst.getString("nome"));
                        
                        p.setCategoria(c);
                    }
                    
                    lista.add(p);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
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

    public Usuario login(Usuario user) {
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao
                    .prepareStatement("Select * from usuario where email = ? and senha = ?")) {
                pstm.setString(1, user.getEmail());
                pstm.setString(2, user.getSenha());
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

    public Produto Buscar(int id) {
        Produto produto = new Produto();
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao.prepareStatement("Select * from produto where id = ?")) {
                pstm.setInt(1, id);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setCategoria(rs.getInt("categoria"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setPeso(rs.getInt("peso"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return produto;
    }

    public int Ultimo() {
        int ultimo = 0;
        try {
            try (Connection conexao = getConexao(); PreparedStatement pstm = conexao.prepareStatement("Select max (id) from produto")) {
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    ultimo = rs.getInt("max");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ultimo;
    }
}
