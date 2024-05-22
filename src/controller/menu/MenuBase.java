package controller.menu;

public abstract class MenuBase implements IMenu {
    protected MenuController menuController;

    public MenuBase(MenuController menuController) {
        this.menuController = menuController;
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