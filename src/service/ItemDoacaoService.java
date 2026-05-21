package service;

import exception.RegraDeNegocioException;
import middleware.LeitorEntrada;
import middleware.Validacoes;
import model.ItemDoacao;
import repository.DadosRepository;

import java.util.ArrayList;
import java.util.List;

public class ItemDoacaoService {
    private DadosRepository repository;
    private LeitorEntrada leitor;
    private Validacoes validacoes;

    public ItemDoacaoService(DadosRepository repository, LeitorEntrada leitor, Validacoes validacoes) {
        this.repository = repository;
        this.leitor = leitor;
        this.validacoes = validacoes;
    }

    public void cadastrarItem() {
        System.out.println("\n===== Cadastro de Item para Doação =====");

        String nome = leitor.lerTextoObrigatorio("Nome do item: ");
        String categoria = validacoes.normalizarOpcao(
                leitor.lerTextoObrigatorio("Categoria [Roupa/Alimento/Movel/Material Escolar/Outro]: "),
                "categoria",
                new String[]{"Roupa", "Alimento", "Movel", "Material Escolar", "Outro"}
        );
        String descricao = leitor.lerTextoObrigatorio("Descricao: ");
        int quantidade = leitor.lerInteiro("Quantidade: ");
        validacoes.validarQuantidade(quantidade, "quantidade");

        String conservacao = validacoes.normalizarOpcao(leitor.lerTextoObrigatorio(
                "Estado de conservacao [Novo/Bom/Regular]: "),
                "estado de conservacao",
                new String[]{"Novo", "Bom", "Regular"}
        );
        String dataCadastro = leitor.lerTextoObrigatorio("Data de cadastro [dd/mm/aaaa]: ");

        ItemDoacao item = new ItemDoacao(
                nome,
                categoria,
                descricao,
                quantidade,
                conservacao,
                dataCadastro,
                "Disponivel"
        );
        repository.getItens().add(item);
        System.out.println("Item cadastrado com sucesso! " + item);
    }

    public void listarItens() {
        System.out.println("\n===== Lista de Itens =====");
        validacoes.validarListaNaoVazia(repository.getItens(), "itens cadastrados");

        for (ItemDoacao i : repository.getItens()) {
            System.out.println(i);
        }
    }

    public void listarItensDisponiveis() {
        List<ItemDoacao> itensDisponiveis = new ArrayList<>();

        for (ItemDoacao item : repository.getItens()) {
            if (item.getStatus().equalsIgnoreCase("Disponivel")) {
                itensDisponiveis.add(item);
            }
        }

        validacoes.validarListaNaoVazia(itensDisponiveis, "itens disponiveis");

        System.out.println("\n===== Itens Disponiveis =====");
        for (ItemDoacao item : itensDisponiveis) {
            System.out.println(item);
        }
    }

    public void filtrarItens() {
        validacoes.validarListaNaoVazia(repository.getItens(), "itens cadastrados");

        String categoria = leitor.lerTexto("Filtrar por categoria (enter para ignorar): ").trim();
        String status = leitor.lerTexto("Filtrar por status (enter para ignorar): ").trim();

        List<ItemDoacao> itensFiltrados = new ArrayList<>();

        for (ItemDoacao item : repository.getItens()) {
            boolean categoriaValida = categoria.isEmpty() || item.getCategoria().equalsIgnoreCase(categoria);
            boolean statusValido = status.isEmpty() || item.getStatus().equalsIgnoreCase(status);

            if (categoriaValida && statusValido) {
                itensFiltrados.add(item);
            }
        }

        if (itensFiltrados.isEmpty()) {
            throw new RegraDeNegocioException("Nenhum item encontrado com os filtros informados.");
        }

        System.out.println("\n===== Itens Filtrados =====");
        for (ItemDoacao item : itensFiltrados) {
            System.out.println(item);
        }
    }

    public ItemDoacao buscarItemPorId(int id) {
        for (ItemDoacao item : repository.getItens()) {
            if (item.getId() == id) {
                return item;
            }
        }

        throw new RegraDeNegocioException("Item nao encontrado para o ID informado.");
    }

    public void baixarEstoque(ItemDoacao item, int quantidade) {
        validacoes.validarEstoque(quantidade, item);
        item.setQuantidade(item.getQuantidade() - quantidade);
        atualizarStatusConformeEstoque(item);
    }

    public void atualizarStatusConformeEstoque(ItemDoacao item) {
        if (item.getQuantidade() <= 0) {
            item.setStatus("Esgotado");
        } else {
            item.setStatus("Disponivel");
        }
    }
}
