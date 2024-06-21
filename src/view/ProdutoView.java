package view;

import java.util.List;

import controller.EcommerceController;
import model.Produto;
import model.ProdutoCarrinho;
import util.Util;

public class ProdutoView {
    public static void mostraMenu(EcommerceController ecommerceController) {
        System.out.println("Produtos:");

        for (int i = 0; i < ecommerceController.getProdutos().size(); i++) {
            System.out.println((i + 1) + ". " + ecommerceController.getProdutos().get(i).getNome() + " - R$ " + ecommerceController.getProdutos().get(i).getPreco() + " - " + ecommerceController.getProdutos().get(i).getQuantidadeEstoque() + " unidades");
        }

        System.out.println("0. Voltar");
    }

    public static void selecionaProduto(List<ProdutoCarrinho> produtosCarrinho, Produto produto){
        ProdutoCarrinho produtoCarrinho = produtosCarrinho.stream().filter(p -> p.getProduto().getId() == produto.getId()).findFirst().orElse(null);

        Util.limpaConsole();
        System.out.println();
        System.out.println("Produto selecionado: " + produto.getNome() + " - R$ " + produto.getPreco() + " - " + produtoCarrinho.getQuantidade() + " unidades");
        System.out.println();
    }
}
