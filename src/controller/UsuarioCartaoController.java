package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.UsuarioCartao;
import util.Util;
import model.Ecommerce;
import model.Usuario;
import view.ErroView;
import view.MenuPrincipalView;
import view.UsuarioCartaoView;

public class UsuarioCartaoController extends MenuBase {
    public UsuarioCartaoController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
    }

    @Override
    public void mostraMenu() {
        UsuarioCartaoView.mostraMenu();
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case 1:
                cadastrarUsuarioCartao();
                break;
            case 2:
                visualizarUsuarioCartaos();
                break;
            case 3:
                editarUsuarioCartao();
                break;
            case 4:
                excluirUsuarioCartao();
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
        }
    }

    public void cadastrarUsuarioCartao() {
        try {
            UsuarioCartao cartao = UsuarioCartaoView.cadastrarUsuarioCartao();

            Usuario usuario = ecommerce.getUsuarioLogado();
            usuario.addCartao(cartao);
            Util.salvarLogCartaoCadastro(cartao);
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao cadastrar o cartão: " + e.getMessage());

        }
    }

    public void visualizarUsuarioCartaos() {
        try {
            Usuario usuario = ecommerce.getUsuarioLogado();
            UsuarioCartaoView.visualizarUsuarioCartaos(usuario.getCartoes());
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao visualizar os cartões: " + e.getMessage());
        }
    }

    public void editarUsuarioCartao() {
        try {
            int id = informarIdCartao();

            Usuario usuario = ecommerce.getUsuarioLogado();
            UsuarioCartao cartao = usuario.getCartoes().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    
            UsuarioCartao cartaoAlterado = UsuarioCartaoView.cadastrarUsuarioCartao();
            cartao.setTitular(cartaoAlterado.getTitular());
            cartao.setNumero(cartaoAlterado.getNumero());
            cartao.setValidade(cartaoAlterado.getValidade());
            cartao.setCvv(cartaoAlterado.getCvv());
            cartao.setCredito(cartaoAlterado.isCredito());
            cartao.setDebito(cartaoAlterado.isDebito());

            Util.salvarLogCartaoEditado(cartao);

        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao editar o cartão: " + e.getMessage());
        } 
    }
    
    public void excluirUsuarioCartao() {
        try {
            int id = informarIdCartao();
    
            Usuario usuario = ecommerce.getUsuarioLogado();
            UsuarioCartao cartao = usuario.getCartoes().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
            usuario.getCartoes().remove(cartao);
            Util.salvarLogCartaoExcluido(cartao);
        
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao excluir o cartão: " + e.getMessage());
        }
    }

    private int informarIdCartao() {
        visualizarUsuarioCartaos();
        return UsuarioCartaoView.informarIdCartao();
    }
}
