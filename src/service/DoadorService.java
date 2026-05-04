package service;

import model.Doador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoadorService {
    private static Scanner scanner = new Scanner(System.in);

    private List<Doador> doadores = new ArrayList<>();

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
}