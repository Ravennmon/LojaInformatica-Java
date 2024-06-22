package model;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private List<Endereco> enderecos;
    private List<Pedido> pedidos;
    private List<UsuarioCartao> cartoes;
    private Carrinho carrinho;

    public Usuario(String nome, String email, String senha, String telefone) {
        this.id = Util.gerarId();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.carrinho = new Carrinho(this);
        this.enderecos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.cartoes = new ArrayList<>();
    }

    public void addEndereco(Endereco endereco){
        this.enderecos.add(endereco);
    }

    public void addCartao(UsuarioCartao cartao){
        this.cartoes.add(cartao);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<UsuarioCartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<UsuarioCartao> cartoes) {
        this.cartoes = cartoes;
    }

    @Override
    public String toString() {
        return "Usuario [Id= " + id + ", Nome= " + nome + ", Email= " + email + ", Senha= " + senha + ", Telefone= "
                + telefone + ", Enderecos= " + enderecos + ", Pedidos= " + pedidos + ", Cartoes= " + cartoes
                + ", Carrinho= " + carrinho + "]";
    }

    


    
}
