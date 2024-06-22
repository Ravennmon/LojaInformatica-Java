package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Endereco;

public class Util {
    private static int idAtual = 0;

    public static synchronized int gerarId() {
        return ++idAtual;
    }

    public static void limpaConsole() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public static String nextLine(String mensagem){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensagem);
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

    public static void salvarLogUsuario(String nome, String telefone, String email) {
        try {
            List<String> logs = new ArrayList<>();
            logs.add("Usuario cadastrado:");
            logs.add("\nNome: " + nome);
            logs.add("Telefone: " + telefone);
            logs.add("Email: " + email);
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

}
