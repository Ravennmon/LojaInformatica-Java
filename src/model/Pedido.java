package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.pagamento.MetodoDePagamento;
import util.Util;

public class Pedido {
    private int id;
    private Usuario usuario;
    private List<Produto> produtos;
    private MetodoDePagamento metodoDePagamento;
    private FormaDeEntrega formaDeEntrega;
    private Endereco enderecoEntrega;
    private Date data;
    private float valorTotal;
    private String situacao;

    public Pedido() {
    }

    public Pedido(Usuario usuario, List<Produto> produtos, MetodoDePagamento metodoDePagamento, FormaDeEntrega formaDeEntrega, Endereco enderecoEntrega) {
        this.id = Util.gerarId();
        this.usuario = usuario;
        this.produtos = produtos;
        this.metodoDePagamento = metodoDePagamento;
        this.situacao = "Em processamento";
        this.valorTotal = calculaValorTotal();
        this.data = new Date();
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

    public float calculaValorTotal() {
        float valorTotal = 0.0f;

        for (Produto produto : produtos) {
            valorTotal += produto.getPreco();
        }

        return valorTotal;
    }

    public void processarPedido() {
        metodoDePagamento.processarPagamento(valorTotal);
        situacao = "Concluído";
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

    public MetodoDePagamento getMetodoDePagamento() {
        return metodoDePagamento;
    }

    public void setMetodoDePagamento(MetodoDePagamento metodoDePagamento) {
        this.metodoDePagamento = metodoDePagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public FormaDeEntrega getFormaDeEntrega() {
        return formaDeEntrega;
    }

    public void setFormaDeEntrega(FormaDeEntrega formaDeEntrega) {
        this.formaDeEntrega = formaDeEntrega;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", usuario=" + usuario + ", produtos=" + produtos + ", metodoDePagamento="
                + metodoDePagamento + ", formaDeEntrega=" + formaDeEntrega + ", enderecoEntrega=" + enderecoEntrega
                + ", data=" + data + ", valorTotal=" + valorTotal + ", situacao=" + situacao + "]";
    }

    

    

    
}
