package view;

import model.Ecommerce;
import util.Util;

public class MenuPrincipalView {
    public static void mostraMenu(Ecommerce ecommerce) {
        System.out.println("Menu Principal:");
        System.out.println("1. Usuário");
        System.out.println("2. Produtos");
        if(ecommerce.isUsuarioLogado()) {
            System.out.println("3. Carrinho");
        }
        System.out.println("0. Sair");
    }

    public static void opcaoInvalida() {
        Util.limpaConsole();
        System.out.println("Opção inválida.");
        System.out.println();
    }

    public static void saindoMenu() {
        System.out.println("Saindo...");
    }
}
