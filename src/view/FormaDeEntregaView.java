package view;

import model.Ecommerce;

public class FormaDeEntregaView {
    public static void mostraMenu(Ecommerce ecommerce) {
        System.out.println("Formas de Entrega:");

        for (int i = 0; i < ecommerce.getFormasDeEntrega().size(); i++) {
            System.out.println((i + 1) + ". " + ecommerce.getFormasDeEntrega().get(i).getNome() + " - R$ " + ecommerce.getFormasDeEntrega().get(i).getValor());
        }

        System.out.println("0. Voltar");

    }
}
