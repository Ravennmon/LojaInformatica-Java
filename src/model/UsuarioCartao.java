package model;

import util.GeraId;

public class UsuarioCartao{
    private int id;
    private String titular;
    private String numero;
    private String validade;
    private String cvv;
    private boolean credito;
    private boolean debito;

    public UsuarioCartao(String titular, String numero, String validade, String cvv, boolean credito, boolean debito) {
        this.id = GeraId.getProximoId(UsuarioCartao.class);
        this.titular = titular;
        this.numero = numero;
        this.validade = validade;
        this.cvv = cvv;
        this.credito = credito;
        this.debito = debito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Usuario Cartao [Id= " + id + ", Titular= " + titular + ", Numero= " + numero + ", Validade= " + validade
                + ", Cvv= " + cvv + ", Credito= " + credito + ", Debito= " + debito + "]";
    }
}
