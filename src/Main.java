import java.util.Scanner;

import exception.RegraDeNegocioException;
import middleware.LeitorEntrada;
import middleware.Validacoes;
import repository.DadosRepository;
import service.SolicitacaoService;
import util.MenuUtil;
import service.BeneficiarioService;
import service.DoadorService;
import service.ItemDoacaoService;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DadosRepository repository = new DadosRepository();
        LeitorEntrada leitor = new LeitorEntrada(scanner);
        Validacoes validacoes = new Validacoes();

        DoadorService doadorService = new DoadorService(repository, leitor, validacoes);
        BeneficiarioService beneficiarioService = new BeneficiarioService(repository, leitor, validacoes);
        ItemDoacaoService itemDoacaoService = new ItemDoacaoService(repository, leitor, validacoes);
        SolicitacaoService solicitacaoService = new SolicitacaoService(repository, leitor, validacoes, itemDoacaoService);
        int opcao;

        do {
            MenuUtil.exibirMenu();
            opcao = MenuUtil.lerOpcao(scanner);

            try {
                switch (opcao) {
                    case 1:
                        doadorService.cadastrarDoador();
                        break;
                    case 2:
                        beneficiarioService.cadastrarBeneficiario();
                        break;
                    case 3:
                        itemDoacaoService.cadastrarItem();
                        break;
                    case 4:
                        doadorService.listarDoadores();
                        break;
                    case 5:
                        beneficiarioService.listarBeneficiarios();
                        break;
                    case 6:
                        itemDoacaoService.listarItens();
                        break;
                    case 7:
                        itemDoacaoService.filtrarItens();
                        break;
                    case 8:
                        solicitacaoService.criarSolicitacao();
                        break;
                    case 9:
                        solicitacaoService.listarSolicitacoes();
                        break;
                    case 10:
                        solicitacaoService.filtrarSolicitacoesPorStatus();
                        break;
                    case 11:
                        solicitacaoService.atualizarStatusSolicitacao();
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema. Ate logo!");
                        break;
                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                }
            } catch (RegraDeNegocioException e) {
                System.out.println("Erro de regra de negocio: " + e.getMessage());
            }

        } while (opcao != 0);

        scanner.close();
    }
}
