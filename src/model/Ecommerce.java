package model;

import java.util.List;

import model.pagamento.MetodoDePagamento;
import util.factories.CollectionFactory;

public class Ecommerce {
    private List<Produto> produtos;
    private List<Usuario> usuarios;
    private List<Pedido> pedidos;
    private List<MetodoDePagamento> metodosDePagamento;
    private List<FormaDeEntrega> formasDeEntrega;
    private Usuario usuarioLogado;

    public Ecommerce() {
        this.produtos = CollectionFactory.createArrayList();
        this.usuarios = CollectionFactory.createArrayList();
        this.pedidos = CollectionFactory.createArrayList();
        this.metodosDePagamento = CollectionFactory.createArrayList();
        this.formasDeEntrega = CollectionFactory.createArrayList();

    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<MetodoDePagamento> getMetodosDePagamento() {
        return metodosDePagamento;
    }

    public void setMetodosDePagamento(List<MetodoDePagamento> metodosDePagamento) {
        this.metodosDePagamento = metodosDePagamento;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void adicionarMetodoDePagamento(MetodoDePagamento metodoDePagamento) {
        this.metodosDePagamento.add(metodoDePagamento);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public void removerUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    public void removerPedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }

    public void removerMetodoDePagamento(MetodoDePagamento metodoDePagamento) {
        this.metodosDePagamento.remove(metodoDePagamento);
    }

    public List<ProdutoCarrinho> getCarrinho(Usuario usuario) {
        return usuario.getCarrinho().getProdutos();

    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
    }

    public boolean isUsuarioLogado() {
        return usuarioLogado != null;
    }

    public List<FormaDeEntrega> getFormasDeEntrega() {
        return formasDeEntrega;
    }

    public void setFormasDeEntrega(List<FormaDeEntrega> formasDeEntrega) {
        this.formasDeEntrega = formasDeEntrega;
    }

    @Override
    public String toString() {
        return "ecommerce [produtos= " + produtos + ", Usuarios= " + usuarios + ", Pedidos= " + pedidos
                + ", Metodos de pagamento= " + metodosDePagamento + ", Forma de entrega= " + formasDeEntrega
                + ", Usuario logado= " + usuarioLogado + "]";
    }
    
}
