package middleware;

import exception.RegraDeNegocioException;
import model.ItemDoacao;

import java.util.List;

public class Validacoes {

    public void validarTextoObrigatorio(String texto, String nomeCampo) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new RegraDeNegocioException("O campo " + nomeCampo + " e obrigatorio.");
        }
    }

    public void validarQuantidade(int quantidade, String nomeCampo) {
        if (quantidade <= 0) {
            throw new RegraDeNegocioException("O campo " + nomeCampo + " deve ser maior que 0.");
        }
    }
    public void validarCampoNulo(Object objeto, String nomeCampo) {
        if (objeto == null) {
            throw new RegraDeNegocioException("O campo " + nomeCampo + " é obrigatorio.");
        }
    }

    public void validarEstoque(int quantidadeSolicitada, ItemDoacao item) {
        validarCampoNulo(item, "item");
        validarQuantidade(quantidadeSolicitada, "quantidade solicitada");

        if (!"Disponivel".equalsIgnoreCase(item.getStatus())) {
            throw new RegraDeNegocioException("O item selecionado nao esta disponivel para solicitacao.");
        }

        if (quantidadeSolicitada > item.getQuantidade()) {
            throw new RegraDeNegocioException(
                    "Quantidade solicitada maior que o estoque disponivel do item."
            );
        }
    }

    public void validarListaNaoVazia(List lista, String nomeLista) {
        if (lista == null || lista.isEmpty()) {
            throw new RegraDeNegocioException("Nao ha " + nomeLista + " no sistema.");
        }
    }

    public String normalizarOpcao(String valor, String nomeCampo, String[] opcoesPermitidas) {
        validarTextoObrigatorio(valor, nomeCampo);

        for (String opcao : opcoesPermitidas) {
            if (opcao.equalsIgnoreCase(valor.trim())) {
                return opcao;
            }
        }

        String mensagem = "Valor invalido para " + nomeCampo + ". Opcoes permitidas: ";

        for (int i = 0; i < opcoesPermitidas.length; i++) {
            mensagem += opcoesPermitidas[i];

            if (i < opcoesPermitidas.length - 1) {
                mensagem += ", ";
            }
        }

        throw new RegraDeNegocioException(mensagem);
    }
}
