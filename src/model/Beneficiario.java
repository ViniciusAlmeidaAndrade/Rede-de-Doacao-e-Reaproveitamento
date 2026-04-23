package model;

public class Beneficiario extends Usuario {
    private String tipoBeneficiario;
    private String prioridade;

    public Beneficiario (String nome,
                         String telefone,
                         String endereco,
                         String tipoBeneficiario,
                         String prioridade,
                         String email,
                         String senha) {
        super(nome, telefone, endereco, email, senha);
        this.tipoBeneficiario = tipoBeneficiario;
        this.prioridade = prioridade;
    }

    public String getTipoBeneficiario(){
        return tipoBeneficiario;
    }
    public void setTipoBeneficiario(String tipoBeneficiario){
        this.tipoBeneficiario = tipoBeneficiario;
    }

    public String getPrioridade(){
        return prioridade;
    }
    public void setPrioridade(String prioridade){
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: " + tipoBeneficiario + " | Prioridade: " + prioridade;
    }

}