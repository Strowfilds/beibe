package facade;

import beans.Usuario;
import dao.ConnectionFactory;
import dao.FuncionarioDAO;
import dao.TipoUsuarioDAO;
import exceptions.DAOException;
import java.util.List;

public class FuncionarioFacade {

    public static List<Usuario> buscarTodos() throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO(connFactory.getConnection());
            List<Usuario> funcionarios = funcionarioDAO.buscarTodos();
            for (Usuario funcionario : funcionarios) {
                funcionario.setEndereco(EnderecoFacade.buscarUsuario(funcionario.getId()));
                TipoUsuarioDAO tipousuarioDAO = new TipoUsuarioDAO(connFactory.getConnection());
                funcionario.setTipoUsuario(tipousuarioDAO.buscar(funcionario.getTipoUsuario().getId()));
            }
            return funcionarios;
        }
    }

    public static void remover(int id) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO(connFactory.getConnection());
            Usuario funcionario = UsuarioFacade.buscar(id);
            EnderecoFacade.remover(funcionario.getEndereco());
            funcionarioDAO.remover(funcionario);            
        }
    }

}
