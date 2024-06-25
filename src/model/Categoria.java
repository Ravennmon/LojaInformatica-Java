package model;

import java.io.Serializable;

import util.GeraId;

public class Categoria  implements Serializable {
    private final int id;
    private String nome;
    private String descricao;

    public Categoria(String nome, String descricao) {
        this.id = GeraId.getProximoId(Categoria.class);
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Categoria [id= " + id + ", Nome= " + nome + ", Descricao= " + descricao + "]";
    }
}
