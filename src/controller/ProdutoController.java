package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Produto;

public class ProdutoController extends MenuBase {
    public ProdutoController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        System.out.println("Produtos:");

        for (int i = 0; i < ecommerceController.getProdutos().size(); i++) {
            System.out.println((i + 1) + ". " + ecommerceController.getProdutos().get(i).getNome() + " - R$ " + ecommerceController.getProdutos().get(i).getPreco() + " - " + ecommerceController.getProdutos().get(i).getQuantidadeEstoque() + " unidades");
        }

        System.out.println("0. Voltar");

    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        if(opcao < 1){
            if(opcao == 0){
                menuController.setMenuAtual(menuController.getMenus().get(0));
                return;
            } 

            System.out.println("Opção inválida.");
        }

        selecionaProduto(opcao);


    }

    public void selecionaProduto(int opcao){
        if (ecommerceController.getUsuarioLogado() == null) {
            System.out.println("\nVocê precisa estar logado para adicionar produtos ao carrinho.\n");
            return;
        }
        Produto produto = ecommerceController.getProdutos().get(opcao - 1);
        
        if (produto.getQuantidadeEstoque() > 0) {
            ecommerceController.getUsuarioLogado().getCarrinho().adicionarProduto(produto);
            produto.diminuirQuantidadeEmEstoque(produto, 1);
            System.out.println("\nProduto adicionado ao carrinho.\n");
        } else {
            System.out.println("\nProduto fora de estoque.\n");
        }
    }

    
}
