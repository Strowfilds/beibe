package beans;

import java.io.Serializable;

public class Config implements Serializable {

    private String teste;

    public Config() {
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

}
