package controller;

import java.util.List;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Carrinho;
import model.Produto;
import model.ProdutoCarrinho;
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

    public void selecionaProduto(int opcao){
        try {
            Produto produto = ecommerceController.getProdutos().get(opcao - 1);
            List<ProdutoCarrinho> produtosCarrinho =  ecommerceController.getUsuarioLogado().getCarrinho().getProdutos();
            Carrinho carrinho = ecommerceController.getUsuarioLogado().getCarrinho();
            carrinho.adicionarProduto(produto, 1);
            produto.removerQuantidadeEstoque(produto, 1);
            ProdutoView.selecionaProduto(produtosCarrinho, produto);
            Util.salvarLogProduto(produto.getNome(), produto.getDescricao(), produto.getPreco());
            
        } catch (Exception e) {
            System.out.println("Erro ao selecionar o produto: " + e.getMessage());
        }
    }
}
