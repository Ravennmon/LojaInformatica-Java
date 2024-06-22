package view;

import java.util.List;

import model.Ecommerce;
import model.Produto;
import model.ProdutoCarrinho;
import util.Util;

public class ProdutoView {
    public static void mostraMenu(Ecommerce ecommerce) {
        System.out.println("Produtos:");

        for (int i = 0; i < ecommerce.getProdutos().size(); i++) {
            System.out.println((i + 1) + ". " + ecommerce.getProdutos().get(i).getNome() + " - R$ " + ecommerce.getProdutos().get(i).getPreco() + " - " + ecommerce.getProdutos().get(i).getQuantidadeEstoque() + " unidades");
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
