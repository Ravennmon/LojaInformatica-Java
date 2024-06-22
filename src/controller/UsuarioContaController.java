package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import model.Usuario;
import view.ErroView;
import view.MenuPrincipalView;
import util.Util;
import util.enums.MenuType;
import view.UsuarioContaView;
import view.UsuarioView;

public class UsuarioContaController extends MenuBase {
    private static final int OPCAO_VISUALIZAR_CONTA = 1;
    private static final int OPCAO_EDITAR_CONTA = 2;
    private static final int OPCAO_EXCLUIR_CONTA = 3;
    private static final int OPCAO_MENU_PRINCIPAL = 0;

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
            case OPCAO_VISUALIZAR_CONTA:
                visualizarConta();
                break;
            case OPCAO_EDITAR_CONTA:
                editarConta();
                break;
            case OPCAO_EXCLUIR_CONTA:
                excluirConta();
                break;
            case OPCAO_MENU_PRINCIPAL:
                menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
                break;
        }
    }

    private void visualizarConta() {
        try {
            Usuario usuario = getUsuarioLogado();
            UsuarioContaView.visualizarConta(usuario);
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao visualizar a conta: " + e.getMessage());
        }
    }

    private void editarConta() {
        try {
            Usuario usuarioAlterado = UsuarioView.cadastrarUsuario();
            Usuario usuario = getUsuarioLogado();
    
            atualizarDadosUsuario(usuario, usuarioAlterado);
            Util.salvarLogEditarConta(usuario);
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao editar a conta: " + e.getMessage());
        }
    }

    private void excluirConta() {
        try {
            Usuario usuario = getUsuarioLogado();
            ecommerce.setUsuarioLogado(null);
            ecommerce.getUsuarios().remove(usuario);
    
            UsuarioContaView.excluirConta();
            Util.salvarLogExcluirConta(usuario);

            menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao excluir a conta: " + e.getMessage());
        }
    }

    private Usuario getUsuarioLogado() {
        return ecommerce.getUsuarioLogado();
    }

    private void atualizarDadosUsuario(Usuario usuario, Usuario usuarioAlterado) {
        usuario.setNome(usuarioAlterado.getNome());
        usuario.setEmail(usuarioAlterado.getEmail());
        usuario.setSenha(usuarioAlterado.getSenha());
        usuario.setTelefone(usuarioAlterado.getTelefone());
    }
}
