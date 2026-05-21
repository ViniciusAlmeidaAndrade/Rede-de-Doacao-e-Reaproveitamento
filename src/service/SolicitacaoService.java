package service;

import exception.RegraDeNegocioException;
import middleware.LeitorEntrada;
import middleware.Validacoes;
import model.Beneficiario;
import model.ItemDoacao;
import model.Solicitacao;
import repository.DadosRepository;

import java.util.ArrayList;
import java.util.List;

public class SolicitacaoService {
    private DadosRepository repository;
    private LeitorEntrada leitor;
    private Validacoes validacoes;
    private ItemDoacaoService itemDoacaoService;

    public SolicitacaoService(
            DadosRepository repository,
            LeitorEntrada leitor,
            Validacoes validacoes,
            ItemDoacaoService itemDoacaoService
    ) {
        this.repository = repository;
        this.leitor = leitor;
        this.validacoes = validacoes;
        this.itemDoacaoService = itemDoacaoService;
    }

    public void criarSolicitacao() {
        System.out.println("\n===== Solicitacao de Item =====");
        validacoes.validarListaNaoVazia(repository.getBeneficiarios(), "beneficiarios cadastrados");
        validacoes.validarListaNaoVazia(repository.getItens(), "itens cadastrados");

        listarBeneficiariosResumido();
        int idBeneficiario = leitor.lerInteiro("Informe o ID do beneficiario: ");
        Beneficiario beneficiario = buscarBeneficiarioPorId(idBeneficiario);

        itemDoacaoService.listarItensDisponiveis();
        int idItem = leitor.lerInteiro("Informe o ID do item desejado: ");
        ItemDoacao item = itemDoacaoService.buscarItemPorId(idItem);

        int quantidadeSolicitada = leitor.lerInteiro("Quantidade solicitada: ");
        validacoes.validarEstoque(quantidadeSolicitada, item);

        String justificativa = leitor.lerTextoObrigatorio("Justificativa da solicitacao: ");
        String dataSolicitacao = leitor.lerTextoObrigatorio("Data da solicitacao [dd/mm/aaaa]: ");

        Solicitacao solicitacao = new Solicitacao(
                beneficiario,
                item,
                quantidadeSolicitada,
                justificativa,
                "Pendente",
                dataSolicitacao
        );

        repository.getSolicitacoes().add(solicitacao);
        System.out.println("Solicitacao criada com sucesso! " + solicitacao);
    }

    public void listarSolicitacoes() {
        System.out.println("\n===== Lista de Solicitacoes =====");
        validacoes.validarListaNaoVazia(repository.getSolicitacoes(), "solicitacoes cadastradas");

        for (Solicitacao solicitacao : repository.getSolicitacoes()) {
            System.out.println(solicitacao);
        }
    }

    public void filtrarSolicitacoesPorStatus() {
        validacoes.validarListaNaoVazia(repository.getSolicitacoes(), "solicitacoes cadastradas");

        String status = validacoes.normalizarOpcao(
                leitor.lerTextoObrigatorio("Status para filtro [Pendente/Aprovada/Recusada/Cancelada/Concluida]: "),
                "status",
                new String[]{"Pendente", "Aprovada", "Recusada", "Cancelada", "Concluida"}
        );

        List<Solicitacao> solicitacoesFiltradas = new ArrayList<>();

        for (Solicitacao solicitacao : repository.getSolicitacoes()) {
            if (solicitacao.getStatus().equalsIgnoreCase(status)) {
                solicitacoesFiltradas.add(solicitacao);
            }
        }

        if (solicitacoesFiltradas.isEmpty()) {
            throw new RegraDeNegocioException("Nenhuma solicitacao encontrada para o status informado.");
        }

        System.out.println("\n===== Solicitacoes Filtradas =====");
        for (Solicitacao solicitacao : solicitacoesFiltradas) {
            System.out.println(solicitacao);
        }
    }

    public void atualizarStatusSolicitacao() {
        System.out.println("\n===== Atualizacao de Status =====");
        listarSolicitacoes();

        int idSolicitacao = leitor.lerInteiro("Informe o ID da solicitacao: ");
        Solicitacao solicitacao = buscarSolicitacaoPorId(idSolicitacao);
        String novoStatus = validacoes.normalizarOpcao(
                leitor.lerTextoObrigatorio("Novo status [Aprovada/Recusada/Cancelada/Concluida]: "),
                "novo status",
                new String[]{"Aprovada", "Recusada", "Cancelada", "Concluida"}
        );

        aplicarMudancaStatus(solicitacao, novoStatus);
        System.out.println("Status atualizado com sucesso! " + solicitacao);
    }

    private void aplicarMudancaStatus(Solicitacao solicitacao, String novoStatus) {
        String statusAtual = solicitacao.getStatus();

        if (statusAtual.equalsIgnoreCase("Pendente")) {
            if (novoStatus.equalsIgnoreCase("Aprovada")) {
                itemDoacaoService.baixarEstoque(
                        solicitacao.getItemDoacao(),
                        solicitacao.getQuantidadeSolicitada()
                );
                solicitacao.setStatus("Aprovada");
                return;
            }

            if (novoStatus.equalsIgnoreCase("Recusada") || novoStatus.equalsIgnoreCase("Cancelada")) {
                solicitacao.setStatus(novoStatus);
                return;
            }
        }

        if (statusAtual.equalsIgnoreCase("Aprovada") && novoStatus.equalsIgnoreCase("Concluida")) {
            solicitacao.setStatus("Concluida");
            return;
        }

        throw new RegraDeNegocioException(
                "Transicao de status invalida. Status atual: " + statusAtual + "."
        );
    }

    private Beneficiario buscarBeneficiarioPorId(int idBeneficiario) {
        for (Beneficiario beneficiario : repository.getBeneficiarios()) {
            if (beneficiario.getId() == idBeneficiario) {
                return beneficiario;
            }
        }

        throw new RegraDeNegocioException("Beneficiario nao encontrado para o ID informado.");
    }

    private Solicitacao buscarSolicitacaoPorId(int idSolicitacao) {
        for (Solicitacao solicitacao : repository.getSolicitacoes()) {
            if (solicitacao.getId() == idSolicitacao) {
                return solicitacao;
            }
        }

        throw new RegraDeNegocioException("Solicitacao nao encontrada para o ID informado.");
    }

    private void listarBeneficiariosResumido() {
        System.out.println("\n===== Beneficiarios =====");
        for (Beneficiario beneficiario : repository.getBeneficiarios()) {
            System.out.println(
                    "[ID: " + beneficiario.getId() + "] " +
                            beneficiario.getNome() +
                            " | Prioridade: " + beneficiario.getPrioridade()
            );
        }
    }

}
