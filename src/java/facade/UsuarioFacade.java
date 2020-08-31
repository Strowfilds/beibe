package facade;

import beans.TipoUsuario;
import beans.Usuario;
import dao.ConnectionFactory;
import dao.TipoUsuarioDAO;
import dao.UsuarioDAO;
import exceptions.BuscarUsuarioException;
import exceptions.DAOException;
import java.security.MessageDigest;

public class UsuarioFacade {

    public static Usuario buscar(int id) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connFactory.getConnection());
            Usuario usuario = usuarioDAO.buscar(id);
            usuario.setEndereco(EnderecoFacade.buscarUsuario(id));
            TipoUsuarioDAO tipousuarioDAO = new TipoUsuarioDAO(connFactory.getConnection());
            usuario.setTipoUsuario(tipousuarioDAO.buscar(usuario.getTipoUsuario().getId()));
            return usuario;
        }
    }

    public static Usuario buscarEmail(String email) throws BuscarUsuarioException, DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connFactory.getConnection());
            Usuario usuario = usuarioDAO.buscarEmail(email);
            usuario.setEndereco(EnderecoFacade.buscarUsuario(usuario.getId()));
            TipoUsuarioDAO tipousuarioDAO = new TipoUsuarioDAO(connFactory.getConnection());
            usuario.setTipoUsuario(tipousuarioDAO.buscar(usuario.getTipoUsuario().getId()));
            return usuario;
        }
    }

    public static boolean checkLogin(String email, String senha) throws BuscarUsuarioException, DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connFactory.getConnection());
            Usuario usuario = usuarioDAO.buscarEmail(email);
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            String senhaHex = hexString.toString();
            return usuario.getSenha().equalsIgnoreCase(senhaHex);
        }
    }

    public static void adicionar(Usuario usuario) throws DAOException, Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connFactory.getConnection());
            usuarioDAO.inserir(usuario);
            int id = usuarioDAO.buscarEmail(usuario.getEmail()).getId();
            usuario.setId(id);
            usuario.getEndereco().setIdUsuario(id);
            EnderecoFacade.inserir(usuario.getEndereco());
        }
    }

    public static void criarNovoUsuario(String nome, String cpf, String email, String endereco, int num, String compl, String bairro, int cidade, int estado, String cep, String tel, String psw, int tipoUsuario) throws DAOException, Exception {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setCpf(cpf);
        novoUsuario.setEmail(email);
        novoUsuario.setTelefone(tel);

        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(psw.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        String senhaHex = hexString.toString();

        novoUsuario.setSenha(senhaHex);
        TipoUsuario novoTipoUsuario = new TipoUsuario();
        novoTipoUsuario.setId(tipoUsuario);
        novoUsuario.setTipoUsuario(novoTipoUsuario);

        novoUsuario.setEndereco(EnderecoFacade.criarNovoEndereco(endereco, num, compl, bairro, cidade, estado, cep));

        UsuarioFacade.adicionar(novoUsuario);
    }

    public static void alterar(int id, String nome, String endereco, int num, String compl, String bairro, int cidade, int estado, String cep, String tel, String senha) throws DAOException, Exception {
        Usuario novoUsuario = UsuarioFacade.buscar(id);
        novoUsuario.setNome(nome);        
        novoUsuario.setTelefone(tel);
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        String senhaHex = hexString.toString();
        novoUsuario.setSenha(senhaHex);       

        novoUsuario.setEndereco(EnderecoFacade.buscarUsuario(id));
        
        novoUsuario.getEndereco().setEndereco(endereco);
        novoUsuario.getEndereco().setNumero(num);
        novoUsuario.getEndereco().setComplemento(compl);
        novoUsuario.getEndereco().setBairro(bairro);
        novoUsuario.getEndereco().setCep(cep);
        novoUsuario.getEndereco().getCidade().setId(cidade);
        novoUsuario.getEndereco().getEstado().setId(estado);
        
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connFactory.getConnection());
            usuarioDAO.atualizar(novoUsuario);          
            EnderecoFacade.atualizar(novoUsuario.getEndereco());
        }
        }

}
