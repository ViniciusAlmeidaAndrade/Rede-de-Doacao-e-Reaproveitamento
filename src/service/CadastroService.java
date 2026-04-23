package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Beneficiario;
import model.Doador;
import model.ItemDoacao;

public class CadastroService {
    private Scanner scanner = new Scanner(System.in);

    private List<Doador> doadores = new ArrayList<>();
    private List<Beneficiario> beneficiarios = new ArrayList<>();
    private List<ItemDoacao> itens = new ArrayList<>();

    public void cadastrarDoador() {
        System.out.println("\n===== Cadastro de Doador =====");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Tipo de Doador [PF/PJ]: ");
        String tipo = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Doador doador = new Doador(nome, telefone, endereco, tipo, email, senha);
        doadores.add(doador);
        System.out.println("✔ Doador cadastrado com sucesso! " + doador);
    }

    public void cadastrarBeneficiario() {
        System.out.println("\n===== Cadastro de Beneficiário =====");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Tipo de Beneficiário [Família/ONG/Escola/Abrigo]: ");
        String tipoBeneficiario = scanner.nextLine();

        System.out.print("Prioridade [Alta/Média/Baixa]: ");
        String prioridade = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Beneficiario beneficiario = new Beneficiario(nome, telefone, endereco, tipoBeneficiario, prioridade, email, senha);
        beneficiarios.add(beneficiario);
        System.out.println("✔ Beneficiário cadastrado com sucesso! " + beneficiario);
    }

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

    public void listarDoadores() {
        System.out.println("\n===== Lista de Doadores =====");
        if (doadores.isEmpty()) {
            System.out.println("Nenhum doador cadastrado.");
            return;
        }
        for (Doador d : doadores) {
            System.out.println(d);
        }
    }

    public void listarBeneficiarios() {
        System.out.println("\n===== Lista de Beneficiários =====");
        if (beneficiarios.isEmpty()) {
            System.out.println("Nenhum beneficiário cadastrado.");
            return;
        }
        for (Beneficiario b : beneficiarios) {
            System.out.println(b);
        }
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