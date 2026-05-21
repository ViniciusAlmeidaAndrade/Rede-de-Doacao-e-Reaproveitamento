package repository;

import model.Doador;
import model.Beneficiario;
import model.ItemDoacao;
import model.Solicitacao;
import model.DoacaoEfetivada;
import java.util.ArrayList;
import java.util.List;

public class DadosRepository {
    private List<Doador> doadores = new ArrayList<>();
    private List<Beneficiario> beneficiarios = new ArrayList<>();
    private List<ItemDoacao> itensDoacao = new ArrayList<>();
    private List<Solicitacao> solicitacoes = new ArrayList<>();
    private List<DoacaoEfetivada> doacoesEfetivadas = new ArrayList<>();


    public List<Doador> getDoadores() {
        return doadores;
    }

    public List<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public List<ItemDoacao> getItens() {
        return itensDoacao;
    }

    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public List<DoacaoEfetivada> getDoacoesEfetivadas() {
        return doacoesEfetivadas;
    }
}
