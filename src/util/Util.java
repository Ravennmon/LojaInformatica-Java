package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Carrinho;
import model.Endereco;
import model.FormaDeEntrega;
import model.Pedido;
import model.Usuario;
import model.UsuarioCartao;

public class Util {
    public static void limpaConsole() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public static String nextLine(String mensagem){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n" + mensagem);
        return sc.nextLine();
    }

    public static int nextInt(String mensagem){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensagem);
        return sc.nextInt();
    }

    public static boolean validaEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public static boolean validaTelefone(String telefone) {
        return telefone.matches("[0-9]+");
    }

    public static void salvarLogUsuario(Usuario usuario) {
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Usuario cadastrado:");
            logs.add("\nNome: " + usuario.getNome());
            logs.add("Telefone: " + usuario.getTelefone());
            logs.add("Email: " + usuario.getEmail());
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logUsuario");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do usuário: " + e.getMessage());
        }
    }

    public static void salvarLogLogin(String email){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Login efetuado com sucesso:");
            logs.add("\nEmail: " + email);
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logLogin");

        } catch (Exception e) {
            System.out.println("Erro ao realizar o login: " + e.getMessage());
        }
    }
    public static void salvarLogProduto(String nome, String descricao, double preco) {
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Produto adiocionado ao carrinho:");
            logs.add("\nNome: " + nome);
            logs.add("Descricao: " + descricao);
            logs.add("Preco: " + preco);
            logs.add("Quantidade: 1");
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logProduto");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do produto: " + e.getMessage());
        }
    }

    public static void salvarLogProduto(String nome, String descricao, double preco, int quantidade) {
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Produto adiocionado ao carrinho:");
            logs.add("\nNome: " + nome);
            logs.add("Descricao: " + descricao);
            logs.add("Preco: " + preco);
            logs.add("Quantidade: " + quantidade);
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logProduto");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do produto: " + e.getMessage());
        }
    }

    public static void salvarLogProdutoRemovido(String nome, String descricao, double preco) {
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Produto removido do carrinho:");
            logs.add("\nNome: " + nome);
            logs.add("Descricao: " + descricao);
            logs.add("Preco: " + preco);
            logs.add("Quantidade: 1");
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logProduto");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do produto: " + e.getMessage());
        }
    }

    public static void salvarLogPagamento(String metodo){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Metodo de pagamento selecionado:");
            logs.add("\nMetodo: " + metodo);
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logPagamento");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do pagamento: " + e.getMessage());
        }
    }

    public static void salvarLogEndereco(Endereco endereco){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Endereco selecionado:");
            logs.add("\nEndereco: " + endereco.getRua());
            logs.add("Numero: " + endereco.getNumero());
            logs.add("Complemento: " + endereco.getComplemento());
            logs.add("Bairro: " + endereco.getBairro());
            logs.add("Cidade: " + endereco.getCidade());
            logs.add("Estado: " + endereco.getEstado());
            logs.add("CEP: " + endereco.getCep());
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logEndereco");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do endereco: " + e.getMessage());
        }
    }

    public static void salvarLogEnderecoEditado(Endereco endereco){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Endereco Editado:");
            logs.add("\nEndereco: " + endereco.getRua());
            logs.add("Numero: " + endereco.getNumero());
            logs.add("Complemento: " + endereco.getComplemento());
            logs.add("Bairro: " + endereco.getBairro());
            logs.add("Cidade: " + endereco.getCidade());
            logs.add("Estado: " + endereco.getEstado());
            logs.add("CEP: " + endereco.getCep());
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logEndereco");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do endereco: " + e.getMessage());
        }
    }
    public static void salvarLogEnderecoExcluido(Endereco endereco){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Endereco Excluido:");
            logs.add("\nEndereco: " + endereco.getRua());
            logs.add("Numero: " + endereco.getNumero());
            logs.add("Complemento: " + endereco.getComplemento());
            logs.add("Bairro: " + endereco.getBairro());
            logs.add("Cidade: " + endereco.getCidade());
            logs.add("Estado: " + endereco.getEstado());
            logs.add("CEP: " + endereco.getCep());
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logEndereco");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do endereco: " + e.getMessage());
        }
    }

    public static void salvarLogFormaDeEntrega(String forma, float valor){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Forma de entrega selecionada:");
            logs.add("\nForma: " + forma);
            logs.add("Valor: " + valor);
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logFormaEntrega");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log da forma de entrega: " + e.getMessage());
        }
    }

    public static void salvarLogCartaoCadastro(UsuarioCartao cartao){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Cartao cadastrado:");
            logs.add("\nNumero: " + cartao.getNumero());
            logs.add("Nome: " + cartao.getTitular());
            logs.add("Data de Validade: " + cartao.getValidade());
            logs.add("CVV: " + cartao.getCvv());
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logCartao");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do cartao: " + e.getMessage());
        }
    }

    public static void salvarLogCartaoEditado(UsuarioCartao cartao){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Cartao editado:");
            logs.add("\nNumero: " + cartao.getNumero());
            logs.add("Nome: " + cartao.getTitular());
            logs.add("Data de Validade: " + cartao.getValidade());
            logs.add("CVV: " + cartao.getCvv());
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logCartao");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do cartao: " + e.getMessage());
        }
    }

    public static void salvarLogCartaoExcluido(UsuarioCartao cartao){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Cartao editado:");
            logs.add("\nNumero: " + cartao.getNumero());
            logs.add("Nome: " + cartao.getTitular());
            logs.add("Data de Validade: " + cartao.getValidade());
            logs.add("CVV: " + cartao.getCvv());
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logCartao");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do cartao: " + e.getMessage());
        }
    }

    public static void salvarLogCartaoSelecionado(UsuarioCartao cartao){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Cartao cadastrado:");
            logs.add("\nNumero: " + cartao.getNumero());
            logs.add("Nome: " + cartao.getTitular());
            logs.add("Data de Validade: " + cartao.getValidade());
            logs.add("CVV: " + cartao.getCvv());
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logCartao");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do cartao: " + e.getMessage());
        }
    }

    public static void salvarLogPedido(Pedido pedido){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Pedido realizado:");
            logs.add("\nUsuario: " + pedido.getUsuario().getNome());
            logs.add("Produtos: ");
            for (int i = 0; i < pedido.getProdutos().size(); i++) {
                logs.add("Nome: " + pedido.getProdutos().get(i).getProduto().getNome());
                logs.add("Descricao: " + pedido.getProdutos().get(i).getProduto().getDescricao());
                logs.add("Preco: " + pedido.getProdutos().get(i).getProduto().getPreco());
                logs.add("Quantidade: " + pedido.getProdutos().get(i).getQuantidade());
            }
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logPedido");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do pedido: " + e.getMessage());
        }
    }
    public static void salvarLogPedidoCancelado(Pedido pedido){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Pedido Cancelado:");
            logs.add("\nUsuario: " + pedido.getUsuario().getNome());
            logs.add("Produtos: ");
            for (int i = 0; i < pedido.getProdutos().size(); i++) {
                logs.add("Nome: " + pedido.getProdutos().get(i).getProduto().getNome());
                logs.add("Descricao: " + pedido.getProdutos().get(i).getProduto().getDescricao());
                logs.add("Preco: " + pedido.getProdutos().get(i).getProduto().getPreco());
                logs.add("Quantidade: " + pedido.getProdutos().get(i).getQuantidade());
            }
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logPedido");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do pedido: " + e.getMessage());
        }
    }

    public static void salvarLogEditarConta(Usuario usuario){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Conta editada:");
            logs.add("\nNome: " + usuario.getNome());
            logs.add("Telefone: " + usuario.getTelefone());
            logs.add("Email: " + usuario.getEmail());
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logUsuario");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do usuário: " + e.getMessage());
        }
    }
    public static void salvarLogExcluirConta(Usuario usuario){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Conta Excluida:");
            logs.add("\nNome: " + usuario.getNome());
            logs.add("Telefone: " + usuario.getTelefone());
            logs.add("Email: " + usuario.getEmail());
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logUsuario");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log do usuário: " + e.getMessage());
        }
    }

    public static void salvarLogConfirmarCompra(Carrinho carrinho, Usuario usuario, Pedido pedido, Endereco endereco, FormaDeEntrega formaEntrega){
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Compra confirmada:");
            logs.add("\nUsuario: " + usuario.getNome());
            logs.add("Produtos: ");
            for (int i = 0; i < carrinho.getProdutos().size(); i++) {
                logs.add("Nome: " + carrinho.getProdutos().get(i).getProduto().getNome());
                logs.add("Descricao: " + carrinho.getProdutos().get(i).getProduto().getDescricao());
                logs.add("Preco: " + carrinho.getProdutos().get(i).getProduto().getPreco());
                logs.add("Quantidade: " + carrinho.getProdutos().get(i).getQuantidade());
            }
            logs.add("Endereco: ");
            logs.add("Rua: " + endereco.getRua());
            logs.add("Numero: " + endereco.getNumero());
            logs.add("Complemento: " + endereco.getComplemento());
            logs.add("Bairro: " + endereco.getBairro());
            logs.add("Cidade: " + endereco.getCidade());
            logs.add("Estado: " + endereco.getEstado());
            logs.add("CEP: " + endereco.getCep());
            logs.add("Forma de entrega: " + formaEntrega.getNome());
            logs.add("data/hora: " + java.time.LocalDateTime.now() + "\n");
            Log.salvar(logs, "logCompra");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o log da compra: " + e.getMessage());
        }
    }
}
