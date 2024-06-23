package model;

import util.GeraId;

public class UsuarioCartao{
    private final int id;
    private String titular;
    private String numero;
    private String validade;
    private String cvv;
    private boolean credito;
    private boolean debito;
    private int usuarioId;

    public UsuarioCartao(String titular, String numero, String validade, String cvv, boolean credito, boolean debito) {
        this.id = GeraId.getProximoId(UsuarioCartao.class);
        setTitular(titular);
        setNumero(numero);
        setValidade(validade);
        setCvv(cvv);
        this.credito = credito;
        this.debito = debito;
    }

    public int getId() {
        return id;
    }
    
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular == null || titular.isEmpty()) {
            throw new IllegalArgumentException("O titular do cartão é obrigatório.");
        }
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("O número do cartão é obrigatório.");
        }
        this.numero = numero;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        if (validade == null || validade.isEmpty()) {
            throw new IllegalArgumentException("A validade do cartão é obrigatória.");
        }
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        if (cvv == null || cvv.isEmpty()) {
            throw new IllegalArgumentException("O CVV do cartão é obrigatório.");
        }
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

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "UsuarioCartao [id=" + id + ", titular=" + titular + ", numero=" + numero + ", validade=" + validade
                + ", cvv=" + cvv + ", credito=" + credito + ", debito=" + debito + ", usuarioId=" + usuarioId + "]";
    }

    
}
