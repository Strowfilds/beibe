package beans;

import java.io.Serializable;
import java.sql.Date;

public class Atendimento implements Serializable {

    private int id;
    private Date dataHora;
    private boolean aberto;
    private String descricao;
    private String solucao;
    private Produto produto;
    private TipoAtendimento tipoAtendimento;
    private Usuario usuario;

    public Atendimento() {
    }

    public Atendimento(int id, Date dataHora, boolean aberto, String descricao, String solucao, Produto produto, TipoAtendimento tipoAtendimento, Usuario usuario) {
        this.id = id;
        this.dataHora = dataHora;
        this.aberto = aberto;
        this.descricao = descricao;
        this.solucao = solucao;
        this.produto = produto;
        this.tipoAtendimento = tipoAtendimento;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
