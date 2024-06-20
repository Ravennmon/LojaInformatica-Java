package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Produto;
import util.Util;

public class CarrinhoController extends MenuBase {
    public CarrinhoController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        System.out.println("Carrinho:");
        System.out.println("1. Visualizar Produtos");
        System.out.println("2. Adicionar Produto");
        System.out.println("3. Remover Produto");
        System.out.println("4. Finalizar Compra");
        System.out.println("0. Voltar");
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case 1:
                visualizarProdutos();
                break;
            case 2:
                adicionarProduto();
                break;
            case 3:
                removerProduto();
                break;
            case 4:
                menuController.setMenuAtual(menuController.getMenus().get(4));
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void visualizarProdutos() {
        try {
            System.out.println("Produtos no carrinho:");
            ecommerceController
            .getUsuarioLogado()
            .getCarrinho()
            .getProdutos()
            .forEach((produto, quantidade) -> System.out.println(produto + ", quantidade no carrinho: " + quantidade));
        } catch (NullPointerException e) {
            System.out.println("\nNenhum usuário está logado ou o carrinho está vazio.\n");
        }
    }

    public void adicionarProduto() {
        System.out.println("Adicionar Produto:");
        String nome = Util.nextLine("Digite o nome do produto:");
        int quantidade = Util.nextInt("Digite a quantidade:");
    
        Produto produto = ecommerceController.getProdutos().stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
    
        if (produto == null) {
            System.out.println("\nProduto não encontrado.\n");
            return;
        }
    
        if(produto.getQuantidadeEstoque() < quantidade){
            System.out.println("\nQuantidade indisponível.\n");
            return;
        }
    
        ecommerceController.getUsuarioLogado().getCarrinho().adicionarProduto(produto, quantidade);
    }

    public void removerProduto() {
        System.out.println("Remover Produto:");
        String nome = Util.nextLine("Digite o nome do produto:");
        Produto produto = ecommerceController.getProdutos().stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
        if (produto == null) {
            System.out.println("\nProduto não encontrado.\n");
            return;
        }
        ecommerceController.getUsuarioLogado().getCarrinho().removerProduto(produto);
        System.out.println("\nProduto removido com sucesso.\n");
    }

    public void listarProdutos() {
        ecommerceController.getProdutos().forEach(System.out::println);
    }
}
