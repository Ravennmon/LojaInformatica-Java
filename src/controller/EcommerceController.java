package controller;

import java.util.ArrayList;
import java.util.List;

import model.FormaDeEntrega;
import model.Pedido;
import model.Produto;
import model.ProdutoCarrinho;
import model.Usuario;
import model.pagamento.MetodoDePagamento;

public class EcommerceController {
    private List<Produto> produtos = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();
    private List<MetodoDePagamento> metodosDePagamento = new ArrayList<>();
    private List<FormaDeEntrega> formasDeEntrega = new ArrayList<>();
    private Usuario usuarioLogado;

    public EcommerceController() {

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
        return "EcommerceController [produtos=" + produtos + ", usuarios=" + usuarios + ", pedidos=" + pedidos
                + ", metodosDePagamento=" + metodosDePagamento + ", formasDeEntrega=" + formasDeEntrega
                + ", usuarioLogado=" + usuarioLogado + "]";
    }
    
}
