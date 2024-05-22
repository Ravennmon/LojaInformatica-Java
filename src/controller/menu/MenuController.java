package controller.menu;

import java.util.List;
import java.util.Scanner;

import util.Util;

public class MenuController {
    private IMenu menuAtual;
    private List<IMenu> menus;

    public MenuController() {
    }
    
    public void setMenus(List<IMenu> menus) {
        this.menus = menus;
    }

    public List<IMenu> getMenus() {
        return menus;
    }

    public void setMenuAtual(IMenu menu) {
        Util.limpaConsole();
        menuAtual = menu;
    }

    public IMenu getMenuAtual() {
        return menuAtual;
    }

    public void mostraMenuAtual() {
        menuAtual.mostraMenu();
    }

    public void gerenciaOpcao() {
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();
        menuAtual.opcao(opcao, this);
    }
}