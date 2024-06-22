package model;

import util.GeraId;

public class ProdutoCarrinho {
    private int id;
    private Produto produto;
    private float preco;
    private int quantidade;


    public ProdutoCarrinho(Produto produto, float preco, int quantidade) {
        this.id = GeraId.getProximoId(ProdutoCarrinho.class);
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
        return "Produto Carrinho [Id= " + id + ", Produto= " + produto + ", Preco= " + preco + ", Quantidade= " + quantidade
                + "]";
    }   
}
