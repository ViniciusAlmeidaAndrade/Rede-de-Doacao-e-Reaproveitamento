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
            case 4:
                cadastroService.listarDoadores();
                break;
            case 5:
                cadastroService.listarBeneficiarios();
                break;
            case 6:
                cadastroService.listarItens();
                break;
            case 0:
                System.out.println("Encerrando o sistema. Até logo!");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }


        scanner.close();
    }
}
