package model;

public class Item {
    private String nome;
    private String categoria;
    private String descricao;
    private int qtd;
    private String conservacao;
    private String data_cadastro;
    private String status;

    public Item (String nome,
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
}
