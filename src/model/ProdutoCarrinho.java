package model;

import util.Util;

public class ProdutoCarrinho {
    private int id;
    private Produto produto;
    private float preco;
    private int quantidade;


    public ProdutoCarrinho(Produto produto, float preco, int quantidade) {
        this.id = Util.gerarId();
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Produto getProduto() {
        return produto;
    }


    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    public float getPreco() {
        return preco;
    }


    public void setPreco(float preco) {
        this.preco = preco;
    }


    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }

    public float getPrecoTotal() {
        return this.preco * this.quantidade;
    }


    @Override
    public String toString() {
        return "ProdutoCarrinho [id=" + id + ", produto=" + produto + ", preco=" + preco + ", quantidade=" + quantidade
                + "]";
    }    
}
