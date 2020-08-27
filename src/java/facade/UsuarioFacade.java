package facade;

import beans.Usuario;
import dao.ConnectionFactory;
import dao.UsuarioDAO;
import java.security.MessageDigest;

public class UsuarioFacade {

    public static Usuario buscar(int id) throws Exception {
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connFactory.getConnection());
            Usuario usuario = usuarioDAO.buscar(id);
            usuario.setEndereco(EnderecoFacade.buscarUsuario(id));
            return usuario;
        }
    }
    
    public static Usuario buscarEmail(String email)throws Exception{
        try (ConnectionFactory connFactory = new ConnectionFactory()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connFactory.getConnection());
            Usuario usuario = usuarioDAO.buscarEmail(email);
            usuario.setEndereco(EnderecoFacade.buscarUsuario(usuario.getId()));
            return usuario;
        }
    }

    public static boolean checkLogin(String email, String senha) throws Exception {
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

}
