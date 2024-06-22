package model;

import java.io.Serializable;

import util.Util;

public class Produto implements Serializable{
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;
    private Categoria categoria;

    public Produto(String nome, String descricao, double preco, int quantidadeEstoque, Categoria categoria) {
        this.id = Util.gerarId();
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    public void diminuirQuantidadeEmEstoque(Produto produto, int quantidade){
        int quantidadeAtual = produto.getQuantidadeEstoque();
        if (quantidadeAtual < quantidade) {
            System.out.println("Não é possível diminuir a quantidade. Estoque insuficiente.");
        } else {
            produto.setQuantidadeEstoque(quantidadeAtual - quantidade);
        }
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto [Produto id= " + id + ", nome=" + nome + ", descrição= " + descricao + ", preço= " + preco
                + ", quantidade Estoque= " + quantidadeEstoque + ", categoria= " + categoria + "]";
    }

    

    
}
