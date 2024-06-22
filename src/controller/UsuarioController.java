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
    private static final int OPCAO_LOGADO_ENDERECO = 1;
    private static final int OPCAO_LOGADO_USUARIO_CARTAO = 2;
    private static final int OPCAO_LOGADO_PEDIDO = 3;
    private static final int OPCAO_LOGADO_USUARIO_CONTA = 4;
    private static final int OPCAO_LOGADO_LOGOUT = 5;
    private static final int OPCAO_DESLOGADO_CADASTRAR = 1;
    private static final int OPCAO_DESLOGADO_LOGIN = 2;
    private static final int OPCAO_MENU_PRINCIPAL = 0;

    
    public UsuarioController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
    }

    @Override
    public void mostraMenu() {
        UsuarioView.mostraMenu(ecommerce);
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        if (ecommerce.isUsuarioLogado()) {
            opcoesLogado(opcao);
        } else {
            opcoesDeslogado(opcao);
        }
    }

    private void opcoesLogado(int opcao) {
        switch (opcao) {
            case OPCAO_LOGADO_ENDERECO:
                menuNavegacao(menuController, MenuType.ENDERECO_CONTROLLER);
                break;
            case OPCAO_LOGADO_USUARIO_CARTAO:
                menuNavegacao(menuController, MenuType.USUARIO_CARTAO_CONTROLLER);
                break;
            case OPCAO_LOGADO_PEDIDO:
                menuNavegacao(menuController, MenuType.PEDIDO_CONTROLLER);
                break;
            case OPCAO_LOGADO_USUARIO_CONTA:
                menuNavegacao(menuController, MenuType.USUARIO_CONTA_CONTROLLER);
                break;
            case OPCAO_LOGADO_LOGOUT:
                logout();
                break;
            case OPCAO_MENU_PRINCIPAL:
                menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
                break;
        }
    }

    private void opcoesDeslogado(int opcao) {
        switch (opcao) {
            case OPCAO_DESLOGADO_CADASTRAR:
                cadastrarUsuario();
                break;
            case OPCAO_DESLOGADO_LOGIN:
                realizarLogin();
                break;
            case OPCAO_MENU_PRINCIPAL:
                menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
                break;
        }
    }

    private void cadastrarUsuario() {
        try {
            Usuario usuario = UsuarioView.cadastrarUsuario();
            ecommerce.adicionarUsuario(usuario);
            Util.salvarLogUsuario(usuario);
            
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    private void realizarLogin() {
        try {
            Usuario usuario = UsuarioView.login(ecommerce);

            if (usuario != null) {
                ecommerce.setUsuarioLogado(usuario);
                Util.salvarLogLogin(usuario.getEmail());
                UsuarioView.loginSucesso();
            } else {
                UsuarioView.loginFalha();
                registrarTentativaLoginFalha();
            }
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao realizar o login: " + e.getMessage());
        }
    }
    
    private void logout() {
        ecommerce.setUsuarioLogado(null);
        menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
    }

    private void registrarTentativaLoginFalha() {
        List<String> logs = CollectionFactory.createArrayList();
        logs.add("Tentativa de login falhou.");

        try {
            Log.salvar(logs, "logLogin");
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao salvar log de tentativa de login falha: " + e.getMessage());
        }
    }
}
