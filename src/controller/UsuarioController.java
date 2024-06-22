package controller;

import java.util.List;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import model.Usuario;
import view.ErroView;
import view.MenuPrincipalView;
import util.Log;
import util.Util;
import util.enums.MenuType;
import util.factories.CollectionFactory;
import view.UsuarioView;

public class UsuarioController extends MenuBase {
    public UsuarioController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
    }

    @Override
    public void mostraMenu() {
        UsuarioView.mostraMenu(ecommerce);
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        if(ecommerce.isUsuarioLogado()){
            opcoesLogado(opcao);
            return;
        } 

        opcoesDeslogado(opcao);
    }

    public void opcoesLogado(int opcao){
        switch (opcao) {
            case 1:
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.ENDERECO_CONTROLLER.getIndex()));
                break;
            case 2:
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.USUARIO_CARTAO_CONTROLLER.getIndex()));
                break;
            case 3:
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.PEDIDO_CONTROLLER.getIndex()));
                break;
            case 4:
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.USUARIO_CONTA_CONTROLLER.getIndex()));
                break;
            case 5:
                ecommerce.setUsuarioLogado(null);
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.MENU_PRINCIPAL.getIndex()));
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.MENU_PRINCIPAL.getIndex()));
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
        }
    }

    public void opcoesDeslogado(int opcao){
        switch (opcao) {
            case 1:
                cadastrarUsuario();
                break;
            case 2:
                login();
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.MENU_PRINCIPAL.getIndex()));
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
        }
    }

    public void cadastrarUsuario() {
        try {
            Usuario usuario = UsuarioView.cadastrarUsuario();
            ecommerce.adicionarUsuario(usuario);
            Util.salvarLogUsuario(usuario);
            
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public void login() {
        try {
            Usuario usuario = UsuarioView.login(ecommerce);

            if (usuario != null) {
                ecommerce.setUsuarioLogado(usuario);
                Util.salvarLogLogin(usuario.getEmail());
                UsuarioView.loginSucesso();
            } else {
                UsuarioView.loginFalha();

                List<String> logs = CollectionFactory.createArrayList();
                logs.add("Tentativa de login falhou.");

                Log.salvar(logs, "logLogin");
            }
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao realizar o login: " + e.getMessage());
        }
    }
    
}
