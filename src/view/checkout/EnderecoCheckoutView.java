package view.checkout;

import util.Util;

public class EnderecoCheckoutView {
    public static void mostraMenu() {
        System.out.println("Endereco:");
        System.out.println("1. Adicionar endereco");
        System.out.println("2. Selecionar endereco");
        System.out.println("0. Voltar");
    }

    public static int informarIdEndereco() {
       return Util.nextInt("Informe o id do endereço que deseja utilizar:");
    }
}
