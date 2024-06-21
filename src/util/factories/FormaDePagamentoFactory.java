package util.factories;

import model.FormaDeEntrega;

public class FormaDePagamentoFactory {
    public static FormaDeEntrega criarFormaDePagamento(String nome, float valor) {
        return new FormaDeEntrega(nome, valor);
    }
}
