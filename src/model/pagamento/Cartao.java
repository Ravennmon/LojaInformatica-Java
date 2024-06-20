package model.pagamento;

public class Cartao extends MetodoDePagamento{
    private boolean credito;
    private boolean debito;

    public Cartao(String metodoDePagamento, boolean credito, boolean debito) {
        super(metodoDePagamento);
        this.credito = credito;
        this.debito = debito;
    }

    @Override
    public void processarPagamento(float valor) {
        System.out.println("Processando pagamento de R$ " + valor + " com cartão de crédito.");
    }

    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    public boolean isDebito() {
        return debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }

    @Override
    public String toString() {
        return "Cartao [credito=" + credito + ", debito=" + debito + "]";
    }
}
