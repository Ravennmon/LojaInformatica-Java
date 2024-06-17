package model;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class Carrinho {
    private int id;
    private Usuario usuario;
    private List<Produto> produtos;
    private float valorTotal;

    public Carrinho(Usuario usuario) {
        this.id = Util.gerarId();
        this.usuario = usuario;
    }

    public void adicionarProduto(Produto produto) {
        if (produtos == null) {
            produtos = new ArrayList<>();
        }

        produtos.add(produto);
        valorTotal += produto.getPreco();
    }

    public void removerProduto(Produto produto) {
        if (produtos != null) {
            produtos.remove(produto);
            valorTotal -= produto.getPreco();
        }
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
