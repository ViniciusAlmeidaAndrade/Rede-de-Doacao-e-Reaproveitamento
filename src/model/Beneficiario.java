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
        this.prioridade = prioridade;
    }

    public String getTipoBeneficiario(){
        return TipoBeneficiario;
    }
    public void setTipoBeneficiario(String TipoBeneficiario){
        this.TipoBeneficiario = TipoBeneficiario;
    }
    public String getPrioridade(){
        return prioridade;
    }
    public void setPrioridade(String prioridade){
        this.prioridade = prioridade;
    }
}
