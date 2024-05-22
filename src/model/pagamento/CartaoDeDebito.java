package model.pagamento;

public class CartaoDeDebito extends Cartao{
    public CartaoDeDebito(String numeroCartao, String validade, String codigoSeguranca) {
        super("Cartão de Débito", numeroCartao, validade, codigoSeguranca);
    }

    @Override
    public void processarPagamento(float valor) {
        System.out.println("Processando pagamento de R$ " + valor + " com cartão de débito.");
    }
}
