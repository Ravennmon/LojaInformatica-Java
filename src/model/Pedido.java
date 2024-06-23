package model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import model.pagamento.MetodoDePagamento;
import util.GeraId;
import util.factories.CollectionFactory;

public class Pedido {
    private final int id;
    private Usuario usuario;
    private List<ProdutoCarrinho> produtos;
    private Date data;
    private String situacao;
    private float valorTotal;
    private MetodoDePagamento metodoDePagamento;
    private FormaDeEntrega formaDeEntrega;
    private Endereco enderecoEntrega;
    private UsuarioCartao cartao;

    public Pedido(Usuario usuario, List<ProdutoCarrinho> produtos, MetodoDePagamento metodoDePagamento, FormaDeEntrega formaDeEntrega, Endereco enderecoEntrega) {
        this.id = GeraId.getProximoId(Pedido.class);
        this.usuario = Objects.requireNonNull(usuario, "Usuario não pode ser nulo");
        this.produtos = CollectionFactory.createArrayList();
        this.metodoDePagamento = Objects.requireNonNull(metodoDePagamento, "MetodoDePagamento não pode ser nulo");
        this.formaDeEntrega = Objects.requireNonNull(formaDeEntrega, "FormaDeEntrega não pode ser nulo");
        this.enderecoEntrega = Objects.requireNonNull(enderecoEntrega, "EnderecoEntrega não pode ser nulo");
        this.situacao = "Em processamento";
        this.data = new Date();
        this.valorTotal = calculaValorTotal();
    }

    public void adicionarProduto(ProdutoCarrinho produto) {
        produtos.add(produto);
        valorTotal += produto.getPreco();
    }

    public void removerProduto(ProdutoCarrinho produto) {
        if (produtos.remove(produto)) {
            valorTotal -= produto.getPreco();
        }
    }

    public float calculaValorTotal() {
        return produtos.stream()
                .map(ProdutoCarrinho::getPreco)
                .reduce(0.0f, Float::sum);
    }

    public void processarPedido() {
        metodoDePagamento.processarPagamento(valorTotal);
        this.situacao = "Concluído";
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

    public MetodoDePagamento getMetodoDePagamento() {
        return metodoDePagamento;
    }

    public void setMetodoDePagamento(MetodoDePagamento metodoDePagamento) {
        this.metodoDePagamento = metodoDePagamento;
    }

    public Date getData() {
        return data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public String getSituacao() {
        return situacao;
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

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public UsuarioCartao getCartao() {
        return cartao;
    }

    public void setCartao(UsuarioCartao cartao) {
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", produtos=" + produtos +
                ", metodoDePagamento=" + metodoDePagamento +
                ", formaDeEntrega=" + formaDeEntrega +
                ", enderecoEntrega=" + enderecoEntrega +
                ", cartao=" + cartao +
                ", data=" + data +
                ", valorTotal=" + valorTotal +
                ", situacao='" + situacao + '\'' +
                '}';
    }
}
