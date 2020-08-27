package facade;

import beans.Endereco;
import dao.CidadeDAO;
import dao.ConnectionFactory;
import dao.EnderecoDAO;
import dao.EstadoDAO;

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
}
