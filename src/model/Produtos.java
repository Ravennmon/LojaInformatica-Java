package model;


import java.io.Serializable;
import java.util.List;

public class Produtos implements Serializable, Comparable<Produtos>{
    private List<Produto> produtos;

    public Produtos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void add(Produto produto){
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Produtos [produtos=" + produtos + "]";
    }

    @Override
    public int compareTo(Produtos o) {
        return 0;
    }
    
}
