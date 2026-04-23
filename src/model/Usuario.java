package model;

public class Usuario {
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private String senha;

    public Usuario(String nome,
                   String telefone,
                   String endereco,
                   String email,
                   String senha) {

        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
