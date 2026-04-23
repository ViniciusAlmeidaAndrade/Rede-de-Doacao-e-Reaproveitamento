package util;
import java.util.Scanner;

public class MenuUtil{

    public static void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("   Rede Solidária de Doação              ");
        System.out.println("========================================");
        System.out.println("  [1] Cadastrar Doador");
        System.out.println("  [2] Cadastrar Beneficiário");
        System.out.println("  [3] Cadastrar Item para Doação");
        System.out.println("  [4] Listar Doadores");
        System.out.println("  [5] Listar Beneficiários");
        System.out.println("  [6] Listar Itens Disponíveis");
        System.out.println("  [0] Sair");
        System.out.println("========================================");
    }

    public static int lerOpcao(Scanner scanner) {
        System.out.print("Escolha uma opção: ");
        while (true) {
            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                return opcao;
            } catch (NumberFormatException e) {
                System.out.print("Opção inválida. Digite um número: ");
            }
        }
    }

}