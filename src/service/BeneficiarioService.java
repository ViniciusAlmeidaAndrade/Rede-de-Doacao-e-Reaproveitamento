package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Beneficiario;

public class BeneficiarioService {
    private Scanner scanner = new Scanner(System.in);

    private List<Beneficiario> beneficiarios = new ArrayList<>();

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
}