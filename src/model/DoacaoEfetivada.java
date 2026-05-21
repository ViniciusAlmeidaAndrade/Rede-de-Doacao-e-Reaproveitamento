package model;

public class DoacaoEfetivada {
    private static int contadorId = 1;

    private int id;
    private ItemDoacao itemDoacao;
    private Doador doador;
    private Beneficiario beneficiario;
    private String dataEntrega;

    public DoacaoEfetivada (
                   ItemDoacao itemDoacao,
                   Doador doador,
                   Beneficiario beneficiario,
                   String dataEntrega) {
        this.id = contadorId++;
        this.itemDoacao = itemDoacao;
        this.doador = doador;
        this.beneficiario = beneficiario;
        this.dataEntrega = dataEntrega;
    }

    public int getId(){
        return id;
    }

    public ItemDoacao getItemDoacao(){
        return itemDoacao;
    }

    public Doador getDoador(){
        return doador;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    @Override
    public String toString() {
        return " ID da doação: " + getId() +
                " | Item doado: " + itemDoacao.getNome() +
                " | Doador: " + doador.getNome() +
                " | Beneficiario: " + beneficiario.getNome() +
                " | Data de entrega: " + getDataEntrega();
    }

}
