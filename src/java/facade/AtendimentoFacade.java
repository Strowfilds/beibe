package facade;

import beans.Atendimento;
import beans.Produto;
import beans.TipoAtendimento;
import beans.Usuario;
import dao.AtendimentoDAO;
import dao.ConnectionFactory;
import dao.TipoAtendimentoDAO;
import exceptions.DAOException;
import java.util.Date;
import java.util.List;

public class AtendimentoFacade {

    public static Atendimento buscar(int id) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            AtendimentoDAO atendimentoDAO = new AtendimentoDAO(connFactory.getConnection());
            Atendimento atendimento = atendimentoDAO.buscar(id);
            return atendimento;
        }
    }

    public static List<Atendimento> buscarTodos() throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            AtendimentoDAO atendimentoDAO = new AtendimentoDAO(connFactory.getConnection());
            return atendimentoDAO.buscarTodos();
        }
    }
    
    public static List<Atendimento> buscarAtendimentosAbertos() throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            AtendimentoDAO atendimentoDAO = new AtendimentoDAO(connFactory.getConnection());
            return atendimentoDAO.buscarTodosAbertos();
        }
    }

    public static List<Atendimento> buscarUsuario(int id) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            AtendimentoDAO atendimentoDAO = new AtendimentoDAO(connFactory.getConnection());
            List<Atendimento> atendimentos = atendimentoDAO.buscarUsuario(id);
            for(Atendimento atendimento : atendimentos){
                Produto produto = ProdutoFacade.buscar(atendimento.getProduto().getId());
                atendimento.setProduto(produto);
                TipoAtendimento tipoAtendimento = AtendimentoFacade.buscarTipoAtendimento(atendimento.getTipoAtendimento().getId());
                atendimento.setTipoAtendimento(tipoAtendimento);
            }
            return atendimentos;
        }
    }
    
    public static List<TipoAtendimento> buscarTiposAtendimento() throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            TipoAtendimentoDAO tipoAtendimentoDAO = new TipoAtendimentoDAO(connFactory.getConnection());
            return tipoAtendimentoDAO.buscarTodos();
        }
    }
    
    public static TipoAtendimento buscarTipoAtendimento(int id) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            TipoAtendimentoDAO tipoAtendimentoDAO = new TipoAtendimentoDAO(connFactory.getConnection());
            return tipoAtendimentoDAO.buscar(id);
        }
    }
    
    public static void atualizar(Atendimento atendimento) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            AtendimentoDAO atendimentoDAO = new AtendimentoDAO(connFactory.getConnection());
            atendimentoDAO.atualizar(atendimento);
        }
    }

    public static void inserir(Date data, String descricao, int idproduto, int idTipoAtendimento, int id) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            AtendimentoDAO atendimentoDAO = new AtendimentoDAO(connFactory.getConnection());
            Atendimento atendimento = new Atendimento();
            atendimento.setDataHora(data);
            atendimento.setAberto(true);
            atendimento.setDescricao(descricao);
            atendimento.setSolucao("Em aberto");
            Usuario usuario = UsuarioFacade.buscar(id);
            atendimento.setUsuario(usuario);
            Produto produto = ProdutoFacade.buscar(idproduto);
            atendimento.setProduto(produto);
            TipoAtendimento tipoAtendimento = new TipoAtendimento();
            tipoAtendimento.setId(idTipoAtendimento);
            atendimento.setTipoAtendimento(tipoAtendimento);
            atendimentoDAO.inserir(atendimento);
        }
    }

}
