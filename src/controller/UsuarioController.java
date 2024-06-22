package controller;

import java.util.ArrayList;
import java.util.List;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Usuario;
import util.Log;
import util.Util;
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
        if(ecommerceController.isUsuarioLogado()){
            opcoesLogado(opcao);
            return;
        } 

        opcoesDeslogado(opcao);
    }

    public void opcoesLogado(int opcao){
        switch (opcao) {
            case 1:
                menuController.setMenuAtual(menuController.getMenus().get(5));
                break;
            case 2:
                menuController.setMenuAtual(menuController.getMenus().get(9));
                break;
            case 3:
                menuController.setMenuAtual(menuController.getMenus().get(8));
                break;
            case 4:
                menuController.setMenuAtual(menuController.getMenus().get(12));
                break;
            case 5:
                ecommerceController.setUsuarioLogado(null);
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                System.out.println("Opção inválida.");
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
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void cadastrarUsuario() {
        try {
            Usuario usuario = UsuarioView.cadastrarUsuario();
            ecommerceController.adicionarUsuario(usuario);
            Util.salvarLogUsuario(usuario);
            
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public void login() {
        try {
            Usuario usuario = UsuarioView.login(ecommerceController);

            if (usuario != null) {
                ecommerceController.setUsuarioLogado(usuario);
                Util.salvarLogLogin(usuario.getEmail());
                System.out.println("\nLogin efetuado com sucesso.\n");
            } else {
                System.out.println("\nEmail ou senha inválidos.\n");

                List<String> logs = new ArrayList<>();
                logs.add("Tentativa de login falhou.");

                Log.salvar(logs, "logLogin");
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar o login: " + e.getMessage());
        }
    }
    
}
