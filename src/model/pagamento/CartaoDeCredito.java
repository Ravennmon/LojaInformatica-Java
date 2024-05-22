package model.pagamento;

public class CartaoDeCredito extends Cartao{
    public CartaoDeCredito(String numeroCartao, String validade, String codigoSeguranca) {
        super("Cartão de Crédito", numeroCartao, validade, codigoSeguranca);
    }

    @Override
    public void processarPagamento(float valor) {
        System.out.println("Processando pagamento de R$ " + valor + " com cartão de crédito.");
    }
}
