package model;

public class Entregador extends Usuario{
    private boolean disponivel;

    public Entregador (String nome,
                         String telefone,
                         String endereco,
                         boolean disponivel,
                         String email,
                         String senha) {
        super(nome, telefone, endereco, email, senha);
        this.disponivel = disponivel;
    }

    public boolean getDisponivel(){
        return disponivel;
    }
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return super.toString() + " Entregado: " + getNome() + " | Disponível: " + disponivel;
    }
}
