package model;

public class Doador extends Usuario {
    private String tipoDoador;

    public Doador (String nome,
                         String telefone,
                         String endereco,
                         String tipoDoador,
                         String email,
                         String senha) {
        super(nome, telefone, endereco, email, senha);
        this.tipoDoador = tipoDoador;
    }

    public String getTipoDoador(){
        return tipoDoador;
    }
    public void setTipoDoador(String TipoDoador){
        this.tipoDoador = TipoDoador;
    }
}
