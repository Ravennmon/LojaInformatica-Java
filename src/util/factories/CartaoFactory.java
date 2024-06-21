package util.factories;

import model.pagamento.Cartao;

public class CartaoFactory {
    public static Cartao criarCartao(String metodoPagamento, boolean credito, boolean debito) {
        return new Cartao(metodoPagamento, credito, debito);
    }
}
