package model;

import java.util.ArrayList;
import java.util.List;

import model.pagamento.MetodoDePagamento;
import util.Util;
import util.factories.CollectionFactory;

public class Carrinho {
    private int id;
    private Usuario usuario;
    private List<ProdutoCarrinho> produtos;
    private MetodoDePagamento metodoDePagamento;
    private FormaDeEntrega formaDeEntrega;
    private Endereco enderecoEntrega;
    private float valorTotal;
    private UsuarioCartao cartao;

    public Carrinho(Usuario usuario) {
        this.id = Util.gerarId();
        this.usuario = usuario;
        this.produtos = CollectionFactory.createArrayList();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        ProdutoCarrinho produtoCarrinho = produtos.stream().filter(p -> p.getProduto().getId() == produto.getId()).findFirst().orElse(null);

        if (produtoCarrinho != null) {
            produtoCarrinho.adicionarQuantidade(quantidade);
            valorTotal += produto.getPreco() * quantidade;
        } else {
            ProdutoCarrinho novoProdutoCarrinho = new ProdutoCarrinho(produto, produto.getPreco(), quantidade);

            produtos.add(novoProdutoCarrinho);
            valorTotal += produto.getPreco();
        }
    }

    public void removerProduto(ProdutoCarrinho produto) {
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

    public List<ProdutoCarrinho> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoCarrinho> produtos) {
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

    public UsuarioCartao getCartao() {
        return cartao;
    }

    public void setCartao(UsuarioCartao cartao) {
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return "Carrinho [id=" + id + ", usuario=" + usuario + ", produtos=" + produtos + ", metodoDePagamento="
                + metodoDePagamento + ", formaDeEntrega=" + formaDeEntrega + ", enderecoEntrega=" + enderecoEntrega
                + ", valorTotal=" + valorTotal + ", cartao=" + cartao + "]";
    }      
}
