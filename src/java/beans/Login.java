package beans;

import beans.enums.TipoUsuarioEnum;
import java.io.Serializable;

// Controle de login, objeto deve constar no escopo da sessão
public class Login implements Serializable {

    private int id;
    private String nome;
    private TipoUsuarioEnum tipoUsuario;

    public Login() {
    }

    public Login(int id, String nome, TipoUsuarioEnum tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
