package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Produto;
import views.ProdutoView;

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
        Produto produto = ecommerceController.getProdutos().get(opcao - 1);
        
        ecommerceController.getUsuarioLogado().getCarrinho().adicionarProduto(produto);
    }
}
