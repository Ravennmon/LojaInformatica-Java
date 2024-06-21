package view.checkout;

import controller.EcommerceController;

public class MetodoDePagamentoView {
    public static void mostraMenu(EcommerceController ecommerceController) {
        System.out.println("Informe o método de pagamento");
        
        for(int i = 0; i < ecommerceController.getMetodosDePagamento().size(); i++){
            System.out.println((i + 1) + ". " + ecommerceController.getMetodosDePagamento().get(i).getDescricao());
        }

        System.out.println("0. Voltar");
    }
}
