package controller;

import controller.menu.IMenu;
import controller.menu.MenuController;
import model.Ecommerce;
import util.Serializador;
import util.enums.MenuType;

public abstract class BaseController implements IMenu {
    protected MenuController menuController;
    protected Ecommerce ecommerce;
    protected Serializador serializador;

    public BaseController(MenuController menuController, Ecommerce ecommerce, Serializador serializador){
        this.menuController = menuController;
        this.ecommerce = ecommerce;
        this.serializador = serializador;
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

    public void menuNavegacao(MenuController menuController, int index) {
        menuController.setMenuAtual(menuController.getMenus().get(index));
    }

    public void serializarObjeto(Object objeto, String nomeArquivo) {
        serializador.serializar(objeto, nomeArquivo);
    }

    public void deserializarObjeto(String nomeArquivo) {
        serializador.desserializar(nomeArquivo);
    }

    
}