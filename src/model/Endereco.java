package model;

import util.GeraId;

public class Endereco {
    private final int id;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private int usuarioId;

    public Endereco(String cep, String estado, String cidade, String bairro, String rua, String numero, String complemento) {
        this.id = GeraId.getProximoId(Endereco.class);
        setCep(cep);
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        setRua(rua);
        setNumero(numero);
        this.complemento = complemento;
    }

    public int getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        if (rua == null || rua.isEmpty()) {
            throw new IllegalArgumentException("A rua é obrigatória.");
        }
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("O número é obrigatório.");
        }
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if (cidade == null || cidade.isEmpty()) {
            throw new IllegalArgumentException("A cidade é obrigatória.");
        }
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException("O estado é obrigatório.");
        }
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep == null || cep.isEmpty()) {
            throw new IllegalArgumentException("O CEP é obrigatório.");
        }
        this.cep = cep;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Endereco [id=" + id + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento
                + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + ", usuarioId="
                + usuarioId + "]";
    }
}
