package model;

public class Doador extends Usuario {
    private String tipo;

    public Doador (String nome,
                         String telefone,
                         String endereco,
                         String email,
                         String senha) {
        super(nome, telefone, endereco, email, senha);
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
