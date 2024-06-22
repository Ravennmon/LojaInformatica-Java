package controller.menu;

import model.Ecommerce;
import util.enums.MenuType;

public abstract class MenuBase implements IMenu {
    protected MenuController menuController;
    protected Ecommerce ecommerce;

    public MenuBase(MenuController menuController, Ecommerce ecommerce){
        this.menuController = menuController;
        this.ecommerce = ecommerce;
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
    
    public void menuNavegacao(MenuController menuController, MenuType menuType) {
        menuController.setMenuAtual(menuController.getMenus().get(menuType.getIndex()));
    }

    
}