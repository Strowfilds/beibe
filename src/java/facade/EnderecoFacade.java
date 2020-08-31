package facade;

import beans.Cidade;
import beans.Estado;
import beans.Endereco;
import dao.CidadeDAO;
import dao.ConnectionFactory;
import dao.EnderecoDAO;
import dao.EstadoDAO;
import exceptions.DAOException;
import java.util.List;

public class EnderecoFacade {

    public static Endereco buscar(int id) throws Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            EnderecoDAO enderecoDAO = new EnderecoDAO(connFactory.getConnection());
            Endereco endereco = enderecoDAO.buscar(id);
            EstadoDAO estadoDAO = new EstadoDAO(connFactory.getConnection());
            endereco.setEstado(estadoDAO.buscarEndereco(id));
            CidadeDAO cidadeDAO = new CidadeDAO(connFactory.getConnection());
            endereco.setCidade(cidadeDAO.buscarEndereco(id));
            return endereco;
        }
    }

    public static Endereco buscarUsuario(int id) throws Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            EnderecoDAO enderecoDAO = new EnderecoDAO(connFactory.getConnection());
            Endereco endereco = enderecoDAO.buscarUsuario(id);
            EstadoDAO estadoDAO = new EstadoDAO(connFactory.getConnection());
            endereco.setEstado(estadoDAO.buscar(endereco.getEstado().getId()));
            CidadeDAO cidadeDAO = new CidadeDAO(connFactory.getConnection());
            endereco.setCidade(cidadeDAO.buscar(endereco.getCidade().getId()));
            return endereco;
        }
    }

    public static List<Cidade> buscarCidadesEstado(int id) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            CidadeDAO cidadeDAO = new CidadeDAO(connFactory.getConnection());
            return cidadeDAO.buscarTodosEstado(id);
        }
    }

    public static List<Estado> buscarEstados() throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            EstadoDAO estadoDAO = new EstadoDAO(connFactory.getConnection());
            return estadoDAO.buscarTodos();
        }
    }

    public static void inserir(Endereco endereco) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            EnderecoDAO enderecoDAO = new EnderecoDAO(connFactory.getConnection());
            enderecoDAO.inserir(endereco);
        }
    }
    
    public static Endereco criarNovoEndereco(String endereco, int num, String compl, String bairro, int cidade, int estado, String cep){
        Endereco novoEndereco = new Endereco();
        novoEndereco.setEndereco(endereco);
        novoEndereco.setNumero(num);
        novoEndereco.setComplemento(compl);
        novoEndereco.setBairro(bairro);
        novoEndereco.setCep(cep);

        novoEndereco.setCidade(new Cidade());
        novoEndereco.getCidade().setId(cidade);
        novoEndereco.setEstado(new Estado());
        novoEndereco.getEstado().setId(estado);
        
        return novoEndereco;
    }     

    static void atualizar(Endereco endereco) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            EnderecoDAO enderecoDAO = new EnderecoDAO(connFactory.getConnection());
            enderecoDAO.atualizar(endereco);
        }
    }
}
