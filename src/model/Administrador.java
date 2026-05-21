package model;

public class Administrador extends Usuario{
    public Administrador (String nome,
                         String telefone,
                         String endereco,
                         String email,
                         String senha) {
        super(nome, telefone, endereco, email, senha);
    }

    @Override
    public String toString() {
        return super.toString() + " | Perfil: Administrador";
    }
}
