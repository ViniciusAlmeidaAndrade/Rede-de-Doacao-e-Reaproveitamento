package model;

public class Solicitacao {
    private static int contadorId = 1;

    private int id;
    private Beneficiario beneficiario;
    private ItemDoacao itemDoacao;
    private int quantidadeSolicitada;
    private String justificativa;
    private String status;
    private String dataSolicitacao;

    public Solicitacao(Beneficiario beneficiario,
                       ItemDoacao itemDoacao,
                       int quantidadeSolicitada,
                       String justificativa,
                       String status,
                       String dataSolicitacao) {
        this.id = contadorId++;
        this.beneficiario = beneficiario;
        this.itemDoacao = itemDoacao;
        this.quantidadeSolicitada = quantidadeSolicitada;
        this.justificativa = justificativa;
        this.status = status;
        this.dataSolicitacao = dataSolicitacao;
    }

    public int getId() {
        return id;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }
    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public ItemDoacao getItemDoacao() {
        return itemDoacao;
    }
    public void setItemDoacao(ItemDoacao itemDoacao) {
        this.itemDoacao = itemDoacao;
    }

    public int getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }
    public void setQuantidadeSolicitada(int quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

    public String getJustificativa() {
        return justificativa;
    }
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    @Override
    public String toString(){
        return "[ID da solicitação: " + id + "] " +
                " | Beneficiario: " + beneficiario.getNome() +
                " | Item solicitado: " + itemDoacao.getNome() +
                " | Quantidade solicitada: " + quantidadeSolicitada +
                " | Justificativa: " + justificativa +
                " | Status: " + status +
                " | Data da solicitacao: " + dataSolicitacao;
    }
}
