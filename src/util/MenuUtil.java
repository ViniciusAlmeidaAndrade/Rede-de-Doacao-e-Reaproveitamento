package util;
import java.util.Scanner;

public class MenuUtil{
    public static void exibirMenu(){
        System.out.println("=========Menu=========\nCadastrar Doador[1]\nCadastrar Beneficiário[2]\nCadastrar Item[3]\nSair[0]");
    }

    public static int lerOpcao(Scanner scanner) {
        System.out.print("\nDigite o numero correspondente para o que você deseja: ");
        return scanner.nextInt();
    }
}