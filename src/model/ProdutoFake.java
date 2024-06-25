package model;

import java.io.Serializable;

public class ProdutoFake implements Serializable {
    private String nome;
    private String descricao;
    private float preco;
    private int quantidadeEstoque;

    public ProdutoFake(String nome, String descricao, float preco, int quantidadeEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "ProdutoFake [nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", quantidadeEstoque="
                + quantidadeEstoque + "]";
    }
}
