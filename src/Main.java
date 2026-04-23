import java.util.Scanner;
import util.MenuUtil;
import service.CadastroService;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CadastroService cadastroService = new CadastroService();
        int opcao;

        MenuUtil.exibirMenu();
        opcao = MenuUtil.lerOpcao(scanner);

        switch (opcao) {
            case 1:
                cadastroService.cadastrarDoador();
                break;
            case 2:
                cadastroService.cadastrarBeneficiario();
                break;
            case 3:
                cadastroService.cadastrarItem();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }

    scanner.close();
    }
}
