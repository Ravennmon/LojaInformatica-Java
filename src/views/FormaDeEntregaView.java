package views;

import controller.EcommerceController;

public class FormaDeEntregaView {
    public static void mostraMenu(EcommerceController ecommerceController) {
        System.out.println("Formas de Entrega:");

        for (int i = 0; i < ecommerceController.getFormasDeEntrega().size(); i++) {
            System.out.println((i + 1) + ". " + ecommerceController.getFormasDeEntrega().get(i).getNome() + " - R$ " + ecommerceController.getFormasDeEntrega().get(i).getValor());
        }

        System.out.println("0. Voltar");

    }
}
