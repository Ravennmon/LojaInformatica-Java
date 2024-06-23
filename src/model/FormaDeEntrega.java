package model;

import util.GeraId;

public class FormaDeEntrega {
    private final int id;
    private String nome;
    private float valor;

    public FormaDeEntrega(String nome, float valor) {
        this.id = GeraId.getProximoId(FormaDeEntrega.class);
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "FormaDeEntrega [id= " + id + ", Nome= " + nome + ", Valor= " + valor + "]";
    }    
}
