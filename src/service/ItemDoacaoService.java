package service;

import model.ItemDoacao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemDoacaoService {
    private Scanner scanner = new Scanner(System.in);
    private List<ItemDoacao> itens = new ArrayList<>();

    public void cadastrarItem() {
        System.out.println("\n===== Cadastro de Item para Doação =====");

        System.out.print("Nome do item: ");
        String nome = scanner.nextLine();

        System.out.print("Categoria [Roupa/Alimento/Móvel/Material Escolar/Outro]: ");
        String categoria = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = 0;
        while (true) {
            try {
                quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade <= 0) {
                    System.out.print("Quantidade deve ser maior que zero. Tente novamente: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Digite um número inteiro: ");
            }
        }

        System.out.print("Estado de conservação [Novo/Bom/Regular]: ");
        String conservacao = scanner.nextLine();

        System.out.print("Data de cadastro [dd/mm/aaaa]: ");
        String dataCadastro = scanner.nextLine();

        ItemDoacao item = new ItemDoacao(nome, categoria, descricao, quantidade, conservacao, dataCadastro, "Disponível");
        itens.add(item);
        System.out.println("✔ Item cadastrado com sucesso! " + item);
    }

    public void listarItens() {
        System.out.println("\n===== Lista de Itens Disponíveis =====");
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
            return;
        }
        for (ItemDoacao i : itens) {
            System.out.println(i);
        }
    }
}