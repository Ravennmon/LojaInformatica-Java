package model;

import java.util.HashMap;
import java.util.Map;

import dto.CarrinhoRepository;
import model.pagamento.MetodoDePagamento;
import util.Util;

public class Carrinho implements CarrinhoRepository{
    
    private int id;
    private Usuario usuario;
    private Map<Produto, Integer> produtos;
    private MetodoDePagamento metodoDePagamento;
    private FormaDeEntrega formaDeEntrega;
    private Endereco enderecoEntrega;
    private float valorTotal;

    public Carrinho(Usuario usuario) {
        this.id = Util.gerarId();
        this.usuario = usuario;
        this.produtos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto) {
        int quantidade = produtos.getOrDefault(produto, 0);
        produtos.put(produto, quantidade + 1);
        valorTotal += produto.getPreco();
    }
    public void adicionarProduto(Produto produto, int quantidade) {
        int quantidadeAtual = produtos.getOrDefault(produto, 0);
        produtos.put(produto, quantidadeAtual + quantidade);
        valorTotal += produto.getPreco() * quantidade;
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
    }

    public void removerProduto(Produto produto) {
        if (produtos.containsKey(produto)) {
            int quantidade = produtos.get(produto);
            if (quantidade > 1) {
                produtos.put(produto, quantidade - 1);
            } else {
                produtos.remove(produto);
            }
            valorTotal -= produto.getPreco();
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + 1);
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

    public Map<Produto, Integer> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<Produto, Integer> produtos) {
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
