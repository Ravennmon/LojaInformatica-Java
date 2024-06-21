package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Produto;
import view.ProdutoView;

public class ProdutoController extends MenuBase {
    public ProdutoController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        ProdutoView.mostraMenu(ecommerceController);
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
        
<<<<<<< HEAD
        if (produto.getQuantidadeEstoque() > 0) {
            ecommerceController.getUsuarioLogado().getCarrinho().adicionarProduto(produto);
            produto.diminuirQuantidadeEmEstoque(produto, 1);
            System.out.println("\nProduto adicionado ao carrinho.\n");
        } else {
            System.out.println("\nProduto fora de estoque.\n");
        }
=======
        ecommerceController.getUsuarioLogado().getCarrinho().adicionarProduto(produto);
>>>>>>> 71db87af833fd8124b4ac0b9d9ed114372408f40
    }

    
}
