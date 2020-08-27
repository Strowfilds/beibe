package facade;

import dao.AtendimentoDAO;
import beans.Atendimento;
import beans.Usuario;
import java.sql.SQLException;
import java.util.List;

public class AtendimentoFacade {
    private AtendimentoFacade(){}
    
    public static boolean checkUser(Usuario user) throws SQLException{
        return new AtendimentoDAO().existe(user);
    }
                                            
    public Atendimento getAtendimentoById(int a) throws SQLException{
        return new AtendimentoDAO().Buscar(a);
    }
    
    public static void resolverAtendimento(Atendimento a) throws SQLException{
        new AtendimentoDAO().resolver(a);
    }
    
    public static void deleteAtendimento(Atendimento a) throws SQLException{
        new AtendimentoDAO().excluir(a);
    }
    
    public List<Atendimento> listAtendimentos(String email, int status) throws SQLException{
        return new AtendimentoDAO().listar(email, status);
    }
}
