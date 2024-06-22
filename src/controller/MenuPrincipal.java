package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import util.enums.MenuType;
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
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.USUARIO_CONTROLLER.getIndex()));
                break;
            case 2:
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.PRODUTO_CONTROLLER.getIndex()));
                break;
            case 3:
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.CARRINHO_CONTROLLER.getIndex()));
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
