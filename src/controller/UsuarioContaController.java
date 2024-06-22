package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Usuario;
import view.UsuarioContaView;
import view.UsuarioView;

public class UsuarioContaController extends MenuBase {
    public UsuarioContaController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        UsuarioContaView.mostraMenu();
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case 1:
                visualizarConta();
                break;
            case 2:
                editarConta();
                break;
            case 3:
                excluirConta();
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void visualizarConta() {
        Usuario usuario = ecommerceController.getUsuarioLogado();
        UsuarioContaView.visualizarConta(usuario);
    }

    public void editarConta() {
        Usuario usuarioAlterado = UsuarioView.cadastrarUsuario();
        Usuario usuario = ecommerceController.getUsuarioLogado();

        usuario.setNome(usuarioAlterado.getNome());
        usuario.setEmail(usuarioAlterado.getEmail());
        usuario.setSenha(usuarioAlterado.getSenha());
        usuario.setTelefone(usuarioAlterado.getTelefone());
    }
    
    public void excluirConta() {
        Usuario usuario = ecommerceController.getUsuarioLogado();
        ecommerceController.setUsuarioLogado(null);
        ecommerceController.getUsuarios().remove(usuario);

        menuController.setMenuAtual(menuController.getMenus().get(0));
        UsuarioContaView.excluirConta();
    }
}
