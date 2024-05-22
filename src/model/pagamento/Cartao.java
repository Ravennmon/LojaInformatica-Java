package model.pagamento;

public class Cartao extends MetodoDePagamento{
    private String numeroCartao;
    private String validade;
    private String codigoSeguranca;

    public Cartao(String metodoDePagamento, String numeroCartao, String validade, String codigoSeguranca) {
        super(metodoDePagamento);
        
        this.numeroCartao = numeroCartao;
        this.validade = validade;
        this.codigoSeguranca = codigoSeguranca;
    }

    @Override
    public void processarPagamento(float valor) {
        System.out.println("Processando pagamento de R$ " + valor + " com cartão de crédito.");
    }

    public String getNumeroCartao() {

        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    @Override
    public String toString() {
        return "CartaoDeCredito [numeroCartao=" + numeroCartao + ", descricao=" + descricao + ", validade=" + validade
                + ", cartao=" + cartao + ", codigoSeguranca=" + codigoSeguranca + ", ativo=" + ativo + "]";
    }

    

}
