package view;

import controller.menu.MenuController;

public class ViewInicial {
    public void mostrarMenu(MenuController menuController) {
        while (true) {
            menuController.mostraMenuAtual();
            menuController.gerenciaOpcao();
        }
    }
}
