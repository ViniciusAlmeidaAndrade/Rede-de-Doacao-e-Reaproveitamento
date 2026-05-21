package service;

import middleware.LeitorEntrada;
import middleware.Validacoes;
import model.Doador;
import repository.DadosRepository;

public class DoadorService {
    private DadosRepository repository;
    private LeitorEntrada leitor;
    private Validacoes validacoes;

    public DoadorService(DadosRepository repository, LeitorEntrada leitor, Validacoes validacoes) {
        this.repository = repository;
        this.leitor = leitor;
        this.validacoes = validacoes;
    }

    public void cadastrarDoador() {
        System.out.println("\n===== Cadastro de Doador =====");

        String nome = leitor.lerTextoObrigatorio("Nome: ");
        String telefone = leitor.lerTextoObrigatorio("Telefone: ");
        String endereco = leitor.lerTextoObrigatorio("Endereco: ");
        String tipo = validacoes.normalizarOpcao(leitor.lerTextoObrigatorio(
                "Tipo de Doador [PF/PJ]: "),
                "tipo de doador",
                new String[]{"PF", "PJ"}
        );
        String email = leitor.lerTextoObrigatorio("Email: ");
        String senha = leitor.lerTextoObrigatorio("Senha: ");

        Doador doador = new Doador(nome, telefone, endereco, tipo, email, senha);
        repository.getDoadores().add(doador);
        System.out.println("Doador cadastrado com sucesso! " + doador);
    }

    public void listarDoadores() {
        System.out.println("\n===== Lista de Doadores =====");
        validacoes.validarListaNaoVazia(repository.getDoadores(), "doadores cadastrados");

        for (Doador d : repository.getDoadores()) {
            System.out.println(d);
        }
    }
}
