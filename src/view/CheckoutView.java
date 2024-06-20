package view;

import controller.EcommerceController;

public class CheckoutView {
    public static void mostraMenu(EcommerceController ecommerceController) {
        System.out.println("Produtos no carrinho:");
        ecommerceController.getUsuarioLogado().getCarrinho().getProdutos().forEach(System.out::println);

        System.out.println("--------------------------------------------------");

        System.out.println("Forma de entrega: " + ecommerceController.getUsuarioLogado().getCarrinho().getFormaDeEntrega().getNome());

        System.out.println("--------------------------------------------------");

        System.out.println("Endereço de entrega: " + ecommerceController.getUsuarioLogado().getCarrinho().getEnderecoEntrega());

        System.out.println("--------------------------------------------------");

        System.out.println("Método de pagamento: " + ecommerceController.getUsuarioLogado().getCarrinho().getMetodoDePagamento().getDescricao());

        System.out.println("--------------------------------------------------");

        System.out.println("Valor total: " + ecommerceController.getUsuarioLogado().getCarrinho().getValorTotal());

        System.out.println("--------------------------------------------------");

        System.out.println("1. Confirmar compra");
        System.out.println("0. Voltar");
    }
}
