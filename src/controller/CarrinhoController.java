package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Produto;
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
        System.out.println("Produtos no carrinho:");
        ecommerceController.getUsuarioLogado().getCarrinho().getProdutos().forEach(System.out::println);
    }

    public void adicionarProduto() {
        System.out.println("Adicionar Produto:");
        String nome = Util.nextLine("Digite o nome do produto:");
        int quantidade = Util.nextInt("Digite a quantidade:");

        Produto produto = ecommerceController.getProdutos().stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        if(produto.getQuantidadeEstoque() < quantidade){
            System.out.println("Quantidade indisponível.");
            return;
        }
        

        ecommerceController.getUsuarioLogado().getCarrinho().adicionarProduto(produto);
    }

    public void removerProduto() {
        System.out.println("Remover Produto:");
        System.out.println("Digite o nome do produto:");
        String nome = Util.nextLine("Digite o nome do produto:");

        Produto produto = ecommerceController.getProdutos().stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        ecommerceController.getUsuarioLogado().getCarrinho().removerProduto(produto);
    }

    public void listarProdutos() {
        ecommerceController.getProdutos().forEach(System.out::println);
    }
}
