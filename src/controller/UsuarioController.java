package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Usuario;
import view.UsuarioView;

public class UsuarioController extends MenuBase {
    public UsuarioController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        UsuarioView.mostraMenu(ecommerceController);
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        if(ecommerceController.getUsuarioLogado() != null){
            switch (opcao) {
                case 1:
                    break;
                case 2:
                    menuController.setMenuAtual(menuController.getMenus().get(5));
                    break;
                case 3:
                    menuController.setMenuAtual(menuController.getMenus().get(9));
                    break;
                case 4:
                    menuController.setMenuAtual(menuController.getMenus().get(8));
                    break;
                case 0:
                    ecommerceController.setUsuarioLogado(null);
                    menuController.setMenuAtual(menuController.getMenus().get(0));
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            return;
        } 

        switch (opcao) {
            case 1:
                cadastrarUsuario();
                break;
            case 2:
                login();
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void cadastrarUsuario() {
        Usuario usuario = UsuarioView.cadastrarUsuario();

        ecommerceController.adicionarUsuario(usuario);
    }

    public void login() {
        Usuario usuario = UsuarioView.login(ecommerceController);

        if (usuario != null) {
            ecommerceController.setUsuarioLogado(usuario);
        } else {
            System.out.println("Email ou senha inválidos.");
        }
    }
    
}
