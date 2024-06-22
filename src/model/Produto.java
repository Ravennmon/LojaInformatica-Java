package model;

import util.GeraId;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private float preco;
    private int quantidadeEstoque;
    private Categoria categoria;

    public Produto(String nome, String descricao, float preco, int quantidadeEstoque, Categoria categoria) {
        this.id = GeraId.getProximoId(Produto.class);
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    public void removerQuantidadeEstoque(Produto produto, int quantidade) {
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
    }

    public void adicionarQuantidadeEstoque(Produto produto, int quantidade) {
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto [Id= " + id + ", Nome= " + nome + ", Descricao= " + descricao + ", Preco= " + preco
                + ", QuantidadeEstoque= " + quantidadeEstoque + ", Categoria= " + categoria + "]";
    }

    

    
}
