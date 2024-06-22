package view.checkout;

import model.Ecommerce;

public class CheckoutView {
    public static void mostraMenu(Ecommerce ecommerce) {
        System.out.println("Produtos no carrinho:");
        ecommerce.getUsuarioLogado().getCarrinho().getProdutos().forEach(System.out::println);

        System.out.println("--------------------------------------------------");

        System.out.println("Forma de entrega: " + ecommerce.getUsuarioLogado().getCarrinho().getFormaDeEntrega().getNome());

        System.out.println("--------------------------------------------------");

        System.out.println("Endereço de entrega: " + ecommerce.getUsuarioLogado().getCarrinho().getEnderecoEntrega());

        System.out.println("--------------------------------------------------");

        System.out.println("Método de pagamento: " + ecommerce.getUsuarioLogado().getCarrinho().getMetodoDePagamento().getDescricao());

        System.out.println("--------------------------------------------------");

        System.out.println("Valor total: " + ecommerce.getUsuarioLogado().getCarrinho().getValorTotal());

        System.out.println("--------------------------------------------------");

        System.out.println("1. Confirmar compra");
        System.out.println("0. Voltar");
    }
}
