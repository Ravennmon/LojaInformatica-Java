package model;

import java.util.Date;
import java.util.List;

import model.pagamento.MetodoDePagamento;
import util.GeraId;
import util.factories.CollectionFactory;

public class Pedido {
    private int id;
    private Usuario usuario;
    private List<ProdutoCarrinho> produtos;
    private MetodoDePagamento metodoDePagamento;
    private FormaDeEntrega formaDeEntrega;
    private Endereco enderecoEntrega;
    private UsuarioCartao cartao;
    private Date data;
    private float valorTotal;
    private String situacao;

    public Pedido() {
    }

    public Pedido(Usuario usuario, List<ProdutoCarrinho> produtos, MetodoDePagamento metodoDePagamento, FormaDeEntrega formaDeEntrega, Endereco enderecoEntrega) {
        this.id = GeraId.getProximoId(Pedido.class);
        this.usuario = usuario;
        this.produtos = produtos;
        this.metodoDePagamento = metodoDePagamento;
        this.situacao = "Em processamento";
        this.valorTotal = calculaValorTotal();
        this.data = new Date();
    }

    public void adicionarProduto(ProdutoCarrinho produto) {
        if (produtos == null) {
            produtos = CollectionFactory.createArrayList();
        }

        produtos.add(produto);
        valorTotal += produto.getPreco();
    }

    public void removerProduto(ProdutoCarrinho produto) {
        if (produtos != null) {
            produtos.remove(produto);
            valorTotal -= produto.getPreco();
        }
    }

    public float calculaValorTotal() {
        float valorTotal = 0.0f;

        for (ProdutoCarrinho produto : produtos) {
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

    public List<ProdutoCarrinho> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoCarrinho> produtos) {
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

    public UsuarioCartao getCartao() {
        return cartao;
    }

    public void setCartao(UsuarioCartao cartao) {
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return "Pedido [Id= " + id + ", Usuario= " + usuario + ", Produtos= " + produtos + ", MetodoDePagamento= "
                + metodoDePagamento + ", FormaDeEntrega= " + formaDeEntrega + ", EnderecoEntrega= " + enderecoEntrega
                + ", Cartao= " + cartao + ", Data= " + data + ", ValorTotal= " + valorTotal + ", Situacao= " + situacao
                + "]";
    } 
}
