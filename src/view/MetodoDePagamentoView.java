package view;

import controller.EcommerceController;
import model.UsuarioCartao;
import model.pagamento.Cartao;
import model.pagamento.MetodoDePagamento;
import util.Util;

public class MetodoDePagamentoView {
    public static void mostraMenu(EcommerceController ecommerceController) {
        System.out.println("Informe o método de pagamento");
        
        for(int i = 0; i < ecommerceController.getMetodosDePagamento().size(); i++){
            System.out.println((i + 1) + ". " + ecommerceController.getMetodosDePagamento().get(i).getDescricao());
        }

        System.out.println("0. Voltar");
    }

    public static UsuarioCartao cadastrarCartao(){
        System.out.println("Informe o número do cartão:");
        String numeroCartao = Util.nextLine("Informe o número do cartão:");
        System.out.println("Informe o nome do titular:");
        String nomeTitular = Util.nextLine("Informe o nome do titular:");
        System.out.println("Informe a validade:");
        String validade = Util.nextLine("Informe a validade:");
        System.out.println("Informe o CVV:");
        String cvv = Util.nextLine("Informe o CVV:");
        String debito = Util.nextLine("O cartão é de débito? (S/N)");
        String credito = Util.nextLine("O cartão é de crédito? (S/N)");

        boolean isDebito = debito.equalsIgnoreCase("S");
        boolean isCredito = credito.equalsIgnoreCase("S");

        return new UsuarioCartao(nomeTitular, numeroCartao, validade, cvv, isCredito, isDebito);
    }
}
