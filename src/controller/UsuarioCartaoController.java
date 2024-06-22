package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.UsuarioCartao;
import model.Usuario;
import util.Util;
import view.MenuPrincipalView;
import view.UsuarioCartaoView;

public class UsuarioCartaoController extends MenuBase {
    public UsuarioCartaoController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
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
        UsuarioCartao cartao = UsuarioCartaoView.cadastrarUsuarioCartao();

        Usuario usuario = ecommerceController.getUsuarioLogado();
        usuario.addCartao(cartao);
    }

    public void visualizarUsuarioCartaos() {
        Usuario usuario = ecommerceController.getUsuarioLogado();
        UsuarioCartaoView.visualizarUsuarioCartaos(usuario.getCartoes());
    }

    public void editarUsuarioCartao() {
        visualizarUsuarioCartaos();
        int id = Integer.parseInt(Util.nextLine("Informe o id do endereço que deseja editar:"));

        Usuario usuario = ecommerceController.getUsuarioLogado();
        UsuarioCartao cartao = usuario.getCartoes().stream().filter(e -> e.getId() == id).findFirst().orElse(null);

        UsuarioCartao cartaoAlterado = UsuarioCartaoView.cadastrarUsuarioCartao();
        cartao.setTitular(cartaoAlterado.getTitular());
        cartao.setNumero(cartaoAlterado.getNumero());
        cartao.setValidade(cartaoAlterado.getValidade());
        cartao.setCvv(cartaoAlterado.getCvv());
        cartao.setCredito(cartaoAlterado.isCredito());
        cartao.setDebito(cartaoAlterado.isDebito());
    }
    
    public void excluirUsuarioCartao() {
        visualizarUsuarioCartaos();
        int id = Integer.parseInt(Util.nextLine("Informe o id do endereço que deseja excluir:"));

        Usuario usuario = ecommerceController.getUsuarioLogado();
        UsuarioCartao cartao = usuario.getCartoes().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        usuario.getCartoes().remove(cartao);
    }
}
