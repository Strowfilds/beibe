package beans;

public class ProdutoDelSafe {
    
    private int id;
    private String nome;
    private String descricao;
    private Categoria categoria;
    private int peso;
    private boolean delSafe;

    public ProdutoDelSafe() {
    }

    public ProdutoDelSafe(int id, String nome, String descricao, Categoria categoria, int peso, boolean delSafe) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.peso = peso;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean isDelSafe() {
        return delSafe;
    }

    public void setDelSafe(boolean delSafe) {
        this.delSafe = delSafe;
    }
    
    
    
}
