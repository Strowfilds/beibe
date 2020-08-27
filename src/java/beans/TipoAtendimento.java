package beans;

import java.io.Serializable;

/**
 *
 * @author Ana Nicole
 */
public class TipoAtendimento implements Serializable {

    private int id;
    private String nome;

    public TipoAtendimento() {
    }

    public TipoAtendimento(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

}
