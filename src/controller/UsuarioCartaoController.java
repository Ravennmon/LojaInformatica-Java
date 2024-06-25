package controller;

import controller.menu.MenuController;
import model.UsuarioCartao;
import util.Serializador;
import util.Util;
import util.enums.MenuType;
import model.Ecommerce;
import model.Usuario;
import view.ErroView;
import view.MenuPrincipalView;
import view.UsuarioCartaoView;

import java.util.NoSuchElementException;

public class UsuarioCartaoController extends BaseController {
    private static final int OPCAO_CADASTRAR_USUARIO_CARTAO = 1;
    private static final int OPCAO_VISUALIZAR_USUARIO_CARTAO = 2;
    private static final int OPCAO_EDITAR_USUARIO_CARTAO = 3;
    private static final int OPCAO_EXCLUIR_USUARIO_CARTAO = 4;
    private static final int OPCAO_MENU_PRINCIPAL = 0;

    public UsuarioCartaoController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        super(menuController, ecommerce, serializador);
    }

    @Override
    public void mostraMenu() {
        UsuarioCartaoView.mostraMenu();
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case OPCAO_CADASTRAR_USUARIO_CARTAO:
                cadastrarUsuarioCartao();
                break;
            case OPCAO_VISUALIZAR_USUARIO_CARTAO:
                visualizarUsuarioCartaos();
                break;
            case OPCAO_EDITAR_USUARIO_CARTAO:
                editarUsuarioCartao();
                break;
            case OPCAO_EXCLUIR_USUARIO_CARTAO:
                excluirUsuarioCartao();
                break;
            case 0:
                menuNavegacao(menuController, 0);
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
                break;
        }
    }

    public void cadastrarUsuarioCartao() {
        try {
            UsuarioCartao cartao = UsuarioCartaoView.cadastrarUsuarioCartao();
            Usuario usuario = ecommerce.getUsuarioLogado();
            usuario.addCartao(cartao);
            Util.salvarLogCartaoCadastro(cartao);
            serializarObjeto(cartao, "Cartao_" + cartao.getId());
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao cadastrar o cartão: " + e.getMessage());
        }
    }

    public void visualizarUsuarioCartaos() {
        try {
            Usuario usuario = ecommerce.getUsuarioLogado();
            UsuarioCartaoView.visualizarUsuarioCartoes(usuario.getCartoes());
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao visualizar os cartões: " + e.getMessage());
        }
    }

    public void editarUsuarioCartao() {
        try {
            int id = informarIdCartao();
            Usuario usuario = ecommerce.getUsuarioLogado();
            UsuarioCartao cartao = usuario.getCartoes().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Cartão não encontrado"));

            UsuarioCartao cartaoAlterado = UsuarioCartaoView.cadastrarUsuarioCartao();
            atualizarCartao(cartao, cartaoAlterado);

            Util.salvarLogCartaoEditado(cartao);
            serializarObjeto(cartaoAlterado, "Cartao_" + cartaoAlterado.getId());
        } catch (NoSuchElementException e) {
            ErroView.mostrarErro(e.getMessage());
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao editar o cartão: " + e.getMessage());
        }
    }

    public void excluirUsuarioCartao() {
        try {
            int id = informarIdCartao();
            Usuario usuario = ecommerce.getUsuarioLogado();
            UsuarioCartao cartao = usuario.getCartoes().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Cartão não encontrado"));

            usuario.getCartoes().remove(cartao);
            Util.salvarLogCartaoExcluido(cartao);
            serializarObjeto(cartao, "Cartao_" + cartao.getId());
        } catch (NoSuchElementException e) {
            ErroView.mostrarErro(e.getMessage());
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao excluir o cartão: " + e.getMessage());
        }
    }

    private int informarIdCartao() {
        visualizarUsuarioCartaos();
        return UsuarioCartaoView.informarIdCartao();
    }

    private void atualizarCartao(UsuarioCartao cartao, UsuarioCartao cartaoAlterado) {
        cartao.setTitular(cartaoAlterado.getTitular());
        cartao.setNumero(cartaoAlterado.getNumero());
        cartao.setValidade(cartaoAlterado.getValidade());
        cartao.setCvv(cartaoAlterado.getCvv());
        cartao.setCredito(cartaoAlterado.isCredito());
        cartao.setDebito(cartaoAlterado.isDebito());
    }
}
