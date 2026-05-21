package middleware;

import java.util.Scanner;

public class LeitorEntrada {
    private Scanner scanner;

    public LeitorEntrada(Scanner scanner) {
        this.scanner = scanner;
    }

    public String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public String lerTextoObrigatorio(String mensagem) {
        while (true) {
            String texto = lerTexto(mensagem).trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Campo obrigatório.");
        }
    }

    public int lerInteiro(String mensagem) {
        while (true) {
            String valor = lerTexto(mensagem).trim();
            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }
}
