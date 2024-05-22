import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.menu.IMenu;
import controller.menu.MenuBase;
import controller.menu.MenuController;
import controller.menu.MenuPrincipal;

public class App {
public static void main(String[] args) {
        MenuController menuController = new MenuController();

        MenuBase menuPrincipal = new MenuPrincipal(menuController);

        List<IMenu> menus = new ArrayList<>();
        menus.addAll(Arrays.asList(menuPrincipal));

        menuController.setMenus(menus);
        menuController.setMenuAtual(menuPrincipal);

        while (true) {
            menuController.mostraMenuAtual();
            menuController.gerenciaOpcao();
        }
    }
}
