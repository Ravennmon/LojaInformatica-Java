package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Usuario;
import util.Util;

public class UsuarioController extends MenuBase {
    public UsuarioController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        System.out.println("Usuário:");
        System.out.println("1. Cadastrar-se");
        System.out.println("2. Login");
        System.out.println("0. Voltar");
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
        String nome = Util.nextLine("Digite seu nome:");
        String telefone = Util.nextLine("Digite seu telefone:");
        String email = Util.nextLine("Digite seu email:");
        String senha = Util.nextLine("Digite sua senha");

        while (!Util.validaEmail(email)) {
            System.out.println("Email inválido.");
            email = Util.nextLine("Digite seu email novamente:");
        }

        Usuario usuario = new Usuario(nome, email, senha, telefone);

        ecommerceController.adicionarUsuario(usuario);
    }

    public void login() {
        String email = Util.nextLine("Digite seu email:");
        String senha = Util.nextLine("Digite sua senha:");

        Usuario usuario = ecommerceController.getUsuarios().stream()
                .filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha)).findFirst().orElse(null);

        if (usuario != null) {
            ecommerceController.setUsuarioLogado(usuario);
        } else {
            System.out.println("Email ou senha inválidos.");
        }
    }
    
}
