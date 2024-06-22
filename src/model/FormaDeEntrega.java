package model;

import java.io.Serializable;

import util.Util;

public class FormaDeEntrega implements Serializable{
    private int id;
    private String nome;
    private float valor;

    public FormaDeEntrega(String nome, float valor) {
        this.id = Util.gerarId();
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "FormaDeEntrega [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
    }    
}
