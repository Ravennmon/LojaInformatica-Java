package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.pagamento.MetodoDePagamento;
import util.Util;

public class Pedido implements Serializable{
    private int id;
    private Usuario usuario;
    private Map<Produto, Integer> produtos;
    private MetodoDePagamento metodoDePagamento;
    private FormaDeEntrega formaDeEntrega;
    private Endereco enderecoEntrega;
    private Date data;
    private float valorTotal;
    private String situacao;

    public Pedido() {
    }

    public Pedido(Usuario usuario, Map<Produto, Integer> produtos, MetodoDePagamento metodoDePagamento, FormaDeEntrega formaDeEntrega, Endereco enderecoEntrega) {
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
            produtos = new HashMap<Produto,Integer>();
        }

        Integer quantidade = produtos.getOrDefault(produto, 0);
        produtos.put(produto, quantidade + 1);
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

        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            Produto produto = entry.getKey();
            Integer quantidade = entry.getValue();
            valorTotal += produto.getPreco() * quantidade;
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

    public Map<Produto, Integer> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<Produto, Integer> produtos) {
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
