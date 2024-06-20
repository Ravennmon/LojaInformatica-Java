package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Usuario;
import views.UsuarioView;

public class UsuarioController extends MenuBase {
    public UsuarioController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        UsuarioView.mostraMenu();
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
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
