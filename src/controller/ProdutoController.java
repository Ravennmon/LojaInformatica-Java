package controller;

import java.util.List;

import controller.menu.MenuController;
import model.Carrinho;
import model.Ecommerce;
import model.Produto;
import model.ProdutoCarrinho;
import view.ErroView;
import view.MenuPrincipalView;
import util.Serializador;
import util.Util;
import util.enums.MenuType;
import view.ProdutoView;

public class ProdutoController extends BaseController {
    public ProdutoController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        super(menuController, ecommerce, serializador);
    }

    @Override
    public void mostraMenu() {
        ProdutoView.mostraMenu(ecommerce);
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        if (opcao == 0) {
            menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
        } else if (opcao > 0 && opcao <= ecommerce.getProdutos().size()) {
            try {
                selecionaProduto(opcao);
            } catch (IndexOutOfBoundsException e) {
                MenuPrincipalView.opcaoInvalida();
            }
        } else {
            MenuPrincipalView.opcaoInvalida();
        }
    }

    private void selecionaProduto(int opcao) {
        try {
            Produto produto = ecommerce.getProdutos().get(opcao - 1);
            List<ProdutoCarrinho> produtosCarrinho =  ecommerce.getUsuarioLogado().getCarrinho().getProdutos();
            Carrinho carrinho = ecommerce.getUsuarioLogado().getCarrinho();
            carrinho.adicionarProduto(produto, 1);
            produto.removerQuantidadeEstoque(produto, 1);
            ProdutoView.selecionaProduto(produtosCarrinho, produto);
            Util.salvarLogProduto(produto.getNome(), produto.getDescricao(), produto.getPreco());
            serializarObjeto(carrinho, "Carrinho_" + carrinho.getId());
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao selecionar o produto: " + e.getMessage());
        }
    }
}
