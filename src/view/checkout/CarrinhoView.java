package view.checkout;

import model.Ecommerce;
import util.Util;

public class CarrinhoView {
    public static void mostraMenu() {
        System.out.println("Carrinho:");
        System.out.println("1. Visualizar Produtos");
        System.out.println("2. Adicionar Produto");
        System.out.println("3. Remover Produto");
        System.out.println("4. Finalizar Compra");
        System.out.println("0. Voltar");
    }

    public static void visualizarProdutos(Ecommerce ecommerce) {
        try {
            System.out.println("Produtos no carrinho:");
            ecommerce
                .getUsuarioLogado()
                .getCarrinho()
                .getProdutos()
                .forEach(produtoCarrinho -> System.out.println(produtoCarrinho.getProduto() + ", quantidade no carrinho: " + produtoCarrinho.getQuantidade()));
        } catch (NullPointerException e) {
            System.out.println("\nNenhum usuário está logado ou o carrinho está vazio.\n");
        }
    }

    public static void adicionarProduto(){
        System.out.println("Adicionar Produto:");
    }

    public static void removerProduto(){
        System.out.println("Remover Produto:");
    }

    public static String nomeProduto(Ecommerce ecommerce){
        return Util.nextLine("Digite o nome do produto:");
    }

    public static int quantidadeProduto(){
        int quantidade = 0;

        try {
            quantidade = Util.nextInt("Digite a quantidade:");
        } catch (NumberFormatException e) {
            System.out.println("\nPor favor, digite um número válido para a quantidade.\n");
        }

        return quantidade;
    }

    public static void produtoNaoEcontrado(){
        System.out.println("\nProduto não encontrado.\n");
    }

    public static void quantidadeIndisponivel(){
        System.out.println("\nQuantidade indisponível.\n");
    }

    public static void usuarioDeslogado(){
        System.out.println("\nNenhum usuário está logado.\n");
    }

    public static void produtoAdicionado(){
        System.out.println("\nProduto adicionado com sucesso.\n");
    }

    public static void produtoRemovido(){
        System.out.println("\nProduto removido com sucesso.\n");
    }
    
    public static void erro(String erro){
        System.out.println(erro);
    }
}
