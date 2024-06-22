package view;

import java.util.List;

import model.UsuarioCartao;
import util.Util;

public class CartaoCheckoutView {
    public static void mostraMenu() {
        System.out.println("Cartoes:");
        System.out.println("1. Adicionar cartao");
        System.out.println("2. Selecionar cartao");
        System.out.println("0. Voltar");
    }

    public static UsuarioCartao cadastrarUsuarioCartao(){
        Util.limpaConsole();
        
        String numeroCartao = Util.nextLine("Informe o número do cartao:");
        String nomeTitular = Util.nextLine("Informe o nome do titular:");
        String validade = Util.nextLine("Informe a validade:");
        String cvv = Util.nextLine("Informe o CVV:");
        String debito = Util.nextLine("O cartao é de débito? (S/N)");
        String credito = Util.nextLine("O cartao é de crédito? (S/N)");

        boolean isDebito = debito.equalsIgnoreCase("S");
        boolean isCredito = credito.equalsIgnoreCase("S");

        return new UsuarioCartao(nomeTitular, numeroCartao, validade, cvv, isCredito, isDebito);
    }

    public static void visualizarUsuarioCartaos(List<UsuarioCartao> cartoes) {
        Util.limpaConsole();
        
        if(cartoes.isEmpty()){
            System.out.println("Nenhum cartao cadastrado.");
            return;
        }
        
        for (UsuarioCartao cartao : cartoes) {
            System.out.println(cartao);
        }
    }

    public static int informarIdCartao() {
       return Util.nextInt("Informe o id do cartão que deseja utilizar:");
    }
}
