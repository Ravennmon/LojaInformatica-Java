package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import model.Usuario;
import view.ErroView;
import view.MenuPrincipalView;
import view.UsuarioContaView;
import view.UsuarioView;

public class UsuarioContaController extends MenuBase {
    public UsuarioContaController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
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
                MenuPrincipalView.opcaoInvalida();
        }
    }

    public void visualizarConta() {
        try {
            Usuario usuario = ecommerce.getUsuarioLogado();
            UsuarioContaView.visualizarConta(usuario);
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao visualizar a conta: " + e.getMessage());
        }
    }

    public void editarConta() {
        try {
            Usuario usuarioAlterado = UsuarioView.cadastrarUsuario();
            Usuario usuario = ecommerce.getUsuarioLogado();
    
            usuario.setNome(usuarioAlterado.getNome());
            usuario.setEmail(usuarioAlterado.getEmail());
            usuario.setSenha(usuarioAlterado.getSenha());
            usuario.setTelefone(usuarioAlterado.getTelefone());
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao editar a conta: " + e.getMessage());
        }
    }
    
    public void excluirConta() {
        try {
            Usuario usuario = ecommerce.getUsuarioLogado();
            ecommerce.setUsuarioLogado(null);
            ecommerce.getUsuarios().remove(usuario);
    
            menuController.setMenuAtual(menuController.getMenus().get(0));
            UsuarioContaView.excluirConta();
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao excluir a conta: " + e.getMessage());
        }
    }
}
