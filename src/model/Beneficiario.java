package model;

public class Beneficiario extends Usuario {
    private String tipo;
    private String prioridade;

    public Beneficiario (String nome,
                   String telefone,
                   String endereco,
                   String email,
                   String senha) {
        super(nome, telefone, endereco, email, senha);
        this.tipo = tipo;
        this.prioridade = prioridade;
    }

    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getPrioridade(){
        return prioridade;
    }
    public void setPrioridade(String prioridade){
        this.prioridade = prioridade;
    }
}
