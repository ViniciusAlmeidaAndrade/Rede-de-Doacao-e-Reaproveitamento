package service;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import model.Beneficiario;
import model.Doador;
import model.ItemDoacao;

public class CadastroService {
    private Scanner scanner = new Scanner(System.in);

    private List<Doador> doadores = new ArrayList<>();
    private List<Beneficiario> beneficiarios = new ArrayList<>();
    private List<ItemDoacao> itens = new ArrayList<>();

    public void cadastrarDoador(){
        System.out.println("\nRealizando Cadastro do Doador\n");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        System.out.print("Tipo de Doador[PF/PJ]: ");
        String tipo = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Doador doador = new Doador(nome, telefone, endereco, tipo, email, senha);
        System.out.println("Doador cadastrado com sucesso!");

    }

    public void cadastrarBeneficiario(){
        System.out.println("\nRealizando Cadastro do Beneficiario\n");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        System.out.print("Tipo de Beneficiario[Escola, ONG, Igreja, etc...]: ");
        String tipoBeneficiario = scanner.nextLine();

        System.out.print("Prioridade: ");
        String prioridade = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Beneficiario beneficiario = new Beneficiario(nome, telefone, endereco, tipoBeneficiario, prioridade, email, senha);
        System.out.println("Beneficiario cadastrado com sucesso!");
    }

    public void cadastrarItem(){
        System.out.println("\nRealizando Cadastro do Item para Doação\n");
        System.out.print("nome: ");
        String nome = scanner.nextLine();

        System.out.print("categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("descricao: ");
        String descricao = scanner.nextLine();

        System.out.print("Quantidade do Item Doado: ");
        int  qtd = scanner.nextInt();

        System.out.print("conservacao: ");
        String conservacao = scanner.nextLine();

        System.out.print("data_cadastro: ");
        String data_cadastro = scanner.nextLine();

        System.out.print("status: ");
        String status = scanner.nextLine();

        ItemDoacao itemDoacao = new ItemDoacao(nome, categoria, descricao, qtd, conservacao, data_cadastro, status);
        System.out.println("Item cadastrado com sucesso!");
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
