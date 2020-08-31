package beans;

import java.io.Serializable;

public class CategoriaDelSafe implements Serializable {

    private int id;
    private String nome;
    private boolean delSafe;

    public CategoriaDelSafe() {
    }

    public CategoriaDelSafe(int id, String nome, boolean delSafe) {
        this.id = id;
        this.nome = nome;
        this.delSafe = delSafe;
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

    public boolean isDelSafe() {
        return delSafe;
    }

    public void setDelSafe(boolean delSafe) {
        this.delSafe = delSafe;
    }

}
