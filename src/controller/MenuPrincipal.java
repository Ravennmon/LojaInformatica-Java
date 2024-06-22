package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import view.MenuPrincipalView;

public class MenuPrincipal extends MenuBase{
    public MenuPrincipal(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
    }

    @Override
    public void mostraMenu() {
        MenuPrincipalView.mostraMenu();
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
                menuController.setMenuAtual(menuController.getMenus().get(3));
                break;
            case 0:
                MenuPrincipalView.saindoMenu();
                System.exit(0);
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
        }
    }
}
