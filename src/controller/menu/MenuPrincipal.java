package controller.menu;

import controller.EcommerceController;

public class MenuPrincipal extends MenuBase{
    public MenuPrincipal(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        System.out.println("Menu Principal:");
        System.out.println("1. Usuário");
        System.out.println("2. Produtos");
        System.out.println("3. Carrinho");
        System.out.println("0. Sair");
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case 1:
                menuController.setMenuAtual(menuController.getMenus().get(1));
                break;
            case 2:
                menuController.setMenuAtual(menuController.getMenus().get(2));
                break;
            case 3:
                menuController.setMenuAtual(menuController.getMenus().get(2));
                break;
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
