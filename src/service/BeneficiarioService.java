package service;

import middleware.LeitorEntrada;
import middleware.Validacoes;
import model.Beneficiario;
import repository.DadosRepository;

public class BeneficiarioService {
    private DadosRepository repository;
    private LeitorEntrada leitor;
    private Validacoes validacoes;

    public BeneficiarioService(DadosRepository repository, LeitorEntrada leitor, Validacoes validacoes) {
        this.repository = repository;
        this.leitor = leitor;
        this.validacoes = validacoes;
    }

    public void cadastrarBeneficiario() {
        System.out.println("\n===== Cadastro de Beneficiário =====");

        String nome = leitor.lerTextoObrigatorio("Nome: ");
        String telefone = leitor.lerTextoObrigatorio("Telefone: ");
        String endereco = leitor.lerTextoObrigatorio("Endereco: ");
        String tipoBeneficiario = validacoes.normalizarOpcao(leitor.lerTextoObrigatorio("Tipo de Beneficiario [Familia/ONG/Escola/Abrigo]: "),
                "tipo de beneficiario",
                new String[]{"Familia", "ONG", "Escola", "Abrigo"}
        );
        String prioridade = validacoes.normalizarOpcao(leitor.lerTextoObrigatorio("Prioridade [Alta/Media/Baixa]: "),
                "prioridade",
                new String[]{"Alta", "Media", "Baixa"}
        );
        String email = leitor.lerTextoObrigatorio("Email: ");
        String senha = leitor.lerTextoObrigatorio("Senha: ");

        Beneficiario beneficiario = new Beneficiario(nome, telefone, endereco, tipoBeneficiario, prioridade, email, senha);
        repository.getBeneficiarios().add(beneficiario);
        System.out.println("Beneficiário cadastrado com sucesso! " + beneficiario);
    }

    public void listarBeneficiarios() {
        System.out.println("\n===== Lista de Beneficiários =====");
        validacoes.validarListaNaoVazia(repository.getBeneficiarios(), "beneficiarios cadastrados");

        for (Beneficiario b : repository.getBeneficiarios()) {
            System.out.println(b);
        }
    }
}
