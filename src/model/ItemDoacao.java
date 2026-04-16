package model;

public class ItemDoacao {
    private String nome;
    private String categoria;
    private String descricao;
    private int qtd;
    private String conservacao;
    private String data_cadastro;
    private String status;

    public ItemDoacao(String nome,
                      String categoria,
                      String descricao,
                      int qtd,
                      String conservacao,
                      String data_cadastro,
                      String status){
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.qtd = qtd;
        this.conservacao = conservacao;
        this.data_cadastro = data_cadastro;
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
        return qtd;
    }
    public void setQtd(int qtd){
        this.qtd = qtd;
    }

    public String getConservacao(){
        return conservacao;
    }
    public void setConservacao(String conservacao){
        this.conservacao = conservacao;
    }

    public String getDataCadastro(){
        return data_cadastro;
    }
    public void setDataCadastro(String data_cadastro){
        this.data_cadastro = data_cadastro;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}