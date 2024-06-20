package model;

import java.util.ArrayList;
import java.util.List;

import model.pagamento.MetodoDePagamento;
import util.Util;

public class Carrinho {
    private int id;
    private Usuario usuario;
    private List<Produto> produtos;
    private MetodoDePagamento metodoDePagamento;
    private FormaDeEntrega formaDeEntrega;
    private Endereco enderecoEntrega;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public MetodoDePagamento getMetodoDePagamento() {
        return metodoDePagamento;
    }

    public void setMetodoDePagamento(MetodoDePagamento metodoDePagamento) {
        this.metodoDePagamento = metodoDePagamento;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public FormaDeEntrega getFormaDeEntrega() {
        return formaDeEntrega;
    }

    public void setFormaDeEntrega(FormaDeEntrega formaDeEntrega) {
        this.formaDeEntrega = formaDeEntrega;
    }

    @Override
    public String toString() {
        return "Carrinho [id=" + id + ", usuario=" + usuario + ", produtos=" + produtos + ", metodoDePagamento="
                + metodoDePagamento + ", formaDeEntrega=" + formaDeEntrega + ", enderecoEntrega=" + enderecoEntrega
                + ", valorTotal=" + valorTotal + "]";
    }  
    
    
}
