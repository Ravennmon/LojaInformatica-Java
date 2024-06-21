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
<<<<<<< HEAD
        String nome = Util.nextLine("Digite seu nome:");
        String telefone = getTelefoneValido();
        String email = getEmailValido();
        String senha = Util.nextLine("Digite sua senha");
        Usuario usuario = UsuarioFactory.criarUsuario(nome, email, senha, telefone);
=======
        Usuario usuario = UsuarioView.cadastrarUsuario();

>>>>>>> 71db87af833fd8124b4ac0b9d9ed114372408f40
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
        Usuario usuario = UsuarioView.login(ecommerceController);

        if (usuario != null) {
            ecommerceController.setUsuarioLogado(usuario);
            System.out.println("\nLogin efetuado com sucesso.\n");
        } else {
            System.out.println("\nEmail ou senha inválidos.\n");
        }
    }
    
}
