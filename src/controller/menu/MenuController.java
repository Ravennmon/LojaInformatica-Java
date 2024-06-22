package controller.menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import util.Util;

public class MenuController {
    private IMenu menuAtual;
    private List<IMenu> menus;

    public MenuController() {
    }
    
    private Scanner scanner = new Scanner(System.in);

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
         try {
            int opcao = scanner.nextInt();
            menuAtual.opcao(opcao, this);
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida. Por favor, insira um número.");
            scanner.nextLine(); 
        }
    }
}