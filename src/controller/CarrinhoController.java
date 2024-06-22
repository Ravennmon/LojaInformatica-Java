package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Produto;
import model.Usuario;
import util.Util;
import view.CarrinhoView;

public class CarrinhoController extends MenuBase {
    public CarrinhoController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        CarrinhoView.mostraMenu();
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
    try {
        System.out.println("Adicionar Produto:");
        String nome = Util.nextLine("Digite o nome do produto:");
        int quantidade = 0;
        try {
            quantidade = Util.nextInt("Digite a quantidade:");
        } catch (NumberFormatException e) {
            System.out.println("\nPor favor, digite um número válido para a quantidade.\n");
            return;
        }
        Produto produto = ecommerceController.getProdutos().stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
        if (produto == null) {
            System.out.println("\nProduto não encontrado.\n");
            return;
        }
        if(produto.getQuantidadeEstoque() < quantidade){
            System.out.println("\nQuantidade indisponível.\n");
            return;
        }
        Usuario usuarioLogado = ecommerceController.getUsuarioLogado();
        if (usuarioLogado == null) {
            System.out.println("\nNenhum usuário está logado.\n");
            return;
        }
        usuarioLogado.getCarrinho().adicionarProduto(produto, quantidade);

        Util.salvarLogProduto(produto.getNome(), produto.getDescricao(), produto.getPreco(), quantidade);
    } catch (Exception e) {
        System.out.println("\nOcorreu um erro ao adicionar o produto: " + e.getMessage() + "\n");
    }
}

public void removerProduto() {
    try {
        System.out.println("Remover Produto:");
        String nome = Util.nextLine("Digite o nome do produto:");
        Produto produto = ecommerceController.getProdutos().stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
        if (produto == null) {
            System.out.println("\nProduto não encontrado.\n");
            return;
        }

        Usuario usuarioLogado = ecommerceController.getUsuarioLogado();

        Util.salvarLogProdutoRemovido(produto.getNome(), produto.getDescricao(), produto.getPreco());
        if (usuarioLogado == null) {
            System.out.println("\nNenhum usuário está logado.\n");
            return;
        }

        try {
            usuarioLogado.getCarrinho().removerProduto(produto);
            System.out.println("\nProduto removido com sucesso.\n");
        } catch (Exception e) {
            System.out.println("\nO produto não está no carrinho.\n");
        }
    } catch (Exception e) {
        System.out.println("\nOcorreu um erro ao remover o produto: " + e.getMessage() + "\n");
    }
}

    public void listarProdutos() {
        ecommerceController.getProdutos().forEach(System.out::println);
        
    }
}
