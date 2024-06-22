package view.checkout;

import model.Ecommerce;

public class MetodoDePagamentoView {
    public static void mostraMenu(Ecommerce ecommerce) {
        System.out.println("Informe o método de pagamento");
        
        for(int i = 0; i < ecommerce.getMetodosDePagamento().size(); i++){
            System.out.println((i + 1) + ". " + ecommerce.getMetodosDePagamento().get(i).getDescricao());
        }

        System.out.println("0. Voltar");
    }
}
