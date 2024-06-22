package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import util.enums.MenuType;
import view.MenuPrincipalView;

public class MenuPrincipal extends MenuBase {
    private static final int OPCAO_USUARIO = 1;
    private static final int OPCAO_PRODUTO = 2;
    private static final int OPCAO_CARRINHO = 3;
    private static final int OPCAO_SAIR = 0;

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
            case OPCAO_USUARIO:
                menuNavegacao(menuController, MenuType.USUARIO_CONTROLLER);
                break;
            case OPCAO_PRODUTO:
                menuNavegacao(menuController, MenuType.PRODUTO_CONTROLLER);
                break;
            case OPCAO_CARRINHO:
                menuNavegacao(menuController, MenuType.CARRINHO_CONTROLLER);
                break;
            case OPCAO_SAIR:
                MenuPrincipalView.saindoMenu();
                System.exit(0);
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
                break;
        }
    }
}
