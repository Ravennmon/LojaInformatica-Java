package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Produto;
import util.Util;

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
        Produto produto = ecommerceController.getProdutos().get(opcao - 1);
        
        ecommerceController.getUsuarioLogado().getCarrinho().adicionarProduto(produto);
        System.out.println("Produto adicionado ao carrinho.");
    }
}
