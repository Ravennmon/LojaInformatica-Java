
package model;

import java.util.List;
import java.util.Objects;

import model.pagamento.MetodoDePagamento;
import util.GeraId;
import util.factories.CollectionFactory;

public class Carrinho {
    private final int id;
    private Usuario usuario;
    private List<ProdutoCarrinho> produtos;
    private float valorTotal;
    private MetodoDePagamento metodoDePagamento;
    private FormaDeEntrega formaDeEntrega;
    private Endereco enderecoEntrega;
    private UsuarioCartao cartao;

    public Carrinho(Usuario usuario) {
        this.id = GeraId.getProximoId(Carrinho.class);
        this.usuario = Objects.requireNonNull(usuario, "Usuario cannot be null");
        this.produtos = CollectionFactory.createArrayList();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        ProdutoCarrinho produtoCarrinho = produtos.stream()
                .filter(p -> p.getProduto().getId() == produto.getId())
                .findFirst()
                .orElse(null);

        if (produtoCarrinho != null) {
            produtoCarrinho.adicionarQuantidade(quantidade);
        } else {
            produtoCarrinho = new ProdutoCarrinho(produto, produto.getPreco(), quantidade);
            produtos.add(produtoCarrinho);
        }
        valorTotal += produto.getPreco() * quantidade;
    }

    public void removerProduto(ProdutoCarrinho produto) {
        if (produtos.remove(produto)) {
            valorTotal -= produto.getPreco() * produto.getQuantidade();
        }
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<ProdutoCarrinho> getProdutos() {
        return produtos;
    }

    public float getValorTotal() {
        return valorTotal;
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
        return "Carrinho [id=" + id + ", usuario=" + usuario + ", produtos=" + produtos + ", valorTotal=" + valorTotal
                + ", metodoDePagamento=" + metodoDePagamento + ", formaDeEntrega=" + formaDeEntrega
                + ", enderecoEntrega=" + enderecoEntrega + ", cartao=" + cartao + "]";
    }

}
