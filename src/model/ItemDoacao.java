package model;

public class ItemDoacao {
    private static int contadorId = 1;

    private int id;
    private String nome;
    private String categoria;
    private String descricao;
    private int quantidade;
    private String conservacao;
    private String dataCadastro;
    private String status;

    public ItemDoacao(String nome,
                      String categoria,
                      String descricao,
                      int quantidade,
                      String conservacao,
                      String dataCadastro,
                      String status){
        this.id = contadorId++;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.conservacao = conservacao;
        this.dataCadastro = dataCadastro;
        this.status = status;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public int getQtd(){
        return quantidade;
    }
    public void setQtd(int quantidade){
        this.quantidade = quantidade;
    }

    public String getConservacao(){
        return conservacao;
    }
    public void setConservacao(String conservacao){
        this.conservacao = conservacao;
    }

    public String getDataCadastro(){
        return dataCadastro;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "[ID: " + id + "] " + nome +
                " | Categoria: " + categoria +
                " | Quantidade: " + quantidade +
                " | Conservação: " + conservacao +
                " | Status: " + status +
                " | Cadastrado em: " + dataCadastro;
    }
}