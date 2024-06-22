package view.checkout;

import model.Ecommerce;
import util.Util;

public class MetodoDePagamentoView {
    public static void mostraMenu(Ecommerce ecommerce) {
        Util.limpaConsole();
        
        System.out.println("Informe o método de pagamento");
        
        for(int i = 0; i < ecommerce.getMetodosDePagamento().size(); i++){
            System.out.println((i + 1) + ". " + ecommerce.getMetodosDePagamento().get(i).getDescricao());
        }

        System.out.println("0. Voltar");
    }
}
