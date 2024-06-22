package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Produto;
import util.Util;
import view.ProdutoView;

public class ProdutoController extends MenuBase {
    public ProdutoController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        ProdutoView.mostraMenu(ecommerceController);
    }

    public void selecionaProduto(int opcao) throws IndexOutOfBoundsException {
        try {
            if (ecommerceController.getUsuarioLogado() == null) {
                System.out.println("\nVocê precisa estar logado para adicionar produtos ao carrinho.\n");
                return;
            }
            Produto produto = ecommerceController.getProdutos().get(opcao - 1);
            
            ecommerceController.getUsuarioLogado().getCarrinho().adicionarProduto(produto, 1);

            Util.salvarLogProduto(produto.getNome(), produto.getDescricao(), produto.getPreco());
            
        } catch (Exception e) {
            System.out.println("Erro ao adicionar o produto ao carrinho: " + e.getMessage());
        }
    }
    
    @Override
    public void opcao(int opcao, MenuController menuController) {
        if(opcao < 1 || opcao > ecommerceController.getProdutos().size()){
            if(opcao == 0){
                menuController.setMenuAtual(menuController.getMenus().get(0));
                return;
            } 
    
            System.out.println("Opção inválida.");
            return;
        }
    
        try {
            selecionaProduto(opcao);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Opção inválida. Por favor, selecione um produto existente.");
        }
    }

    
}
