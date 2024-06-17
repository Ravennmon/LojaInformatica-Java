package controller.menu;

import controller.EcommerceController;

public abstract class MenuBase implements IMenu {
    protected MenuController menuController;
    protected EcommerceController ecommerceController;

    public MenuBase(MenuController menuController, EcommerceController ecommerceController){
        this.menuController = menuController;
        this.ecommerceController = ecommerceController;
    }

    @Override
    public abstract void mostraMenu();

    @Override
    public abstract void opcao(int opcao, MenuController menuController);

    public MenuController getMenuController() {
        return menuController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    
}