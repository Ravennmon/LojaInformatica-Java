package view;

import controller.EcommerceController;

public class ProdutoView {
    public static void mostraMenu(EcommerceController ecommerceController) {
        System.out.println("Produtos:");

        for (int i = 0; i < ecommerceController.getProdutos().size(); i++) {
            System.out.println((i + 1) + ". " + ecommerceController.getProdutos().get(i).getNome() + " - R$ " + ecommerceController.getProdutos().get(i).getPreco() + " - " + ecommerceController.getProdutos().get(i).getQuantidadeEstoque() + " unidades");
        }

        System.out.println("0. Voltar");
    }
}
