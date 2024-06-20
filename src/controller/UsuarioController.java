package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Usuario;
import util.Util;
import util.factories.UsuarioFactory;

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
        String telefone = getTelefoneValido();
        String email = getEmailValido();
        String senha = Util.nextLine("Digite sua senha");
        Usuario usuario = UsuarioFactory.criarUsuario(nome, email, senha, telefone);
        ecommerceController.adicionarUsuario(usuario);
        
        System.out.println("\nUsuário cadastrado com sucesso.\n");
    }

    private String getTelefoneValido() {
        String telefone;
        do {
            telefone = Util.nextLine("Digite seu telefone:");
            if (!Util.validaTelefone(telefone)) {
                System.out.println("Entrada inválida. Por favor, insira apenas números.");
            }
        } while (!Util.validaTelefone(telefone));
        return telefone;
    }
    
    private String getEmailValido() {
        String email;
        do {
            email = Util.nextLine("Digite seu email:");
            if (!Util.validaEmail(email)) {
                System.out.println("Email inválido.");
            }
        } while (!Util.validaEmail(email));
        return email;
    }

    public void login() {
        String email = Util.nextLine("Digite seu email:");
        String senha = Util.nextLine("Digite sua senha:");

        Usuario usuario = ecommerceController.getUsuarios().stream()
                .filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha)).findFirst().orElse(null);

        if (usuario != null) {
            ecommerceController.setUsuarioLogado(usuario);
            System.out.println("\nLogin efetuado com sucesso.\n");
        } else {
            System.out.println("\nEmail ou senha inválidos.\n");
        }
    }
    
}
