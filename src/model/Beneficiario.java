package model;

public class Beneficiario extends Usuario {
    private String TipoBeneficiario;
    private String prioridade;

    public Beneficiario (String nome,
                   String telefone,
                   String endereco,
                   String email,
                   String senha) {
        super(nome, telefone, endereco, email, senha);
        this.TipoBeneficiario = TipoBeneficiario;
=======
                   String tipoBeneficiario,
                   String email,
                   String senha) {
        super(nome, telefone, endereco, email, senha);
        this.tipoBeneficiario = tipoBeneficiario;
>>>>>>> Stashed changes
        this.prioridade = prioridade;
    }

    public String getTipoBeneficiario(){
<<<<<<< Updated upstream
        return TipoBeneficiario;
    }
    public void setTipoBeneficiario(String TipoBeneficiario){
        this.TipoBeneficiario = TipoBeneficiario;
    }
=======
        return tipoBeneficiario;
    }
    public void setTipoBeneficiario(String TipoBeneficiario){
        this.tipoBeneficiario = TipoBeneficiario;
    }

>>>>>>> Stashed changes
    public String getPrioridade(){
        return prioridade;
    }
    public void setPrioridade(String prioridade){
        this.prioridade = prioridade;
    }
}
