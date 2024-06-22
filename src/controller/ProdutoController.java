package controller;

import java.util.List;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Carrinho;
import model.Produto;
import model.ProdutoCarrinho;
import view.MenuPrincipalView;
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

            MenuPrincipalView.opcaoInvalida();
        }

        selecionaProduto(opcao);
    }

    public void selecionaProduto(int opcao){
        Produto produto = ecommerceController.getProdutos().get(opcao - 1);

        List<ProdutoCarrinho> produtosCarrinho =  ecommerceController.getUsuarioLogado().getCarrinho().getProdutos();

        Carrinho carrinho = ecommerceController.getUsuarioLogado().getCarrinho();

        carrinho.adicionarProduto(produto, 1);

        ProdutoView.selecionaProduto(produtosCarrinho, produto);
    }
}
