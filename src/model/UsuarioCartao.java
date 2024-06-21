package model;

public class UsuarioCartao{
    private String titular;
    private String numero;
    private String validade;
    private String cvv;
    private boolean credito;
    private boolean debito;

    public UsuarioCartao(String titular, String numero, String validade, String cvv, boolean credito, boolean debito) {
        this.titular = titular;
        this.numero = numero;
        this.validade = validade;
        this.cvv = cvv;
        this.credito = credito;
        this.debito = debito;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
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
        return "Cartao [titular=" + titular + ", numero=" + numero + ", validade=" + validade + ", cvv=" + cvv
                + ", credito=" + credito + ", debito=" + debito + "]";
    }

    


}
