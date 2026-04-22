package service;
import java.util.Scanner;
import model.Doador;

public class CadastroService {
    private Scanner scanner = new Scanner(System.in);
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
}