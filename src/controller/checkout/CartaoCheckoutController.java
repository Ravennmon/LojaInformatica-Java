package controller.checkout;

import controller.BaseController;
import controller.menu.MenuController;
import model.UsuarioCartao;
import util.Serializador;
import util.Util;
import util.enums.MenuType;
import model.Ecommerce;
import model.Usuario;
import view.CartaoCheckoutView;
import view.ErroView;
import view.MenuPrincipalView;
import view.UsuarioCartaoView;

public class CartaoCheckoutController extends BaseController {
    private static final int OPCAO_CADASTRAR_CARTAO = 1;
    private static final int OPCAO_SELECIONAR_CARTAO = 2;
    private static final int OPCAO_MENU_PRINCIPAL = 0;

    public CartaoCheckoutController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        super(menuController, ecommerce, serializador);
    }

    @Override
    public void mostraMenu() {
        CartaoCheckoutView.mostraMenu();
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case OPCAO_CADASTRAR_CARTAO:
                cadastrarCartao();
                break;
            case OPCAO_SELECIONAR_CARTAO:
                selecionarCartao();
                break;
            case OPCAO_MENU_PRINCIPAL:
                menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
        }
    }

    public void cadastrarCartao() {
        try {
            UsuarioCartao cartao = UsuarioCartaoView.cadastrarUsuarioCartao();



            Usuario usuario = ecommerce.getUsuarioLogado();
            usuario.addCartao(cartao);
            setCarrinhoCartao(usuario, cartao);
            UsuarioCartaoView.cartaoSucesso();
            Util.salvarLogCartaoCadastro(cartao);
            serializarObjeto(cartao, usuario.getNome() + "_Cartao_" + cartao.getId());

        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao cadastrar cartão: " + e.getMessage() + "\n");
        }
    }

    public void visualizarUsuarioCartoes() {
        try {
            Usuario usuario = ecommerce.getUsuarioLogado();
            UsuarioCartaoView.visualizarUsuarioCartoes(usuario.getCartoes());
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao visualizar cartões: " + e.getMessage() + "\n");
        }
    }

    public void selecionarCartao() {
        try {
            visualizarUsuarioCartoes();
            int id = CartaoCheckoutView.informarIdCartao();

            Usuario usuario = ecommerce.getUsuarioLogado();
            UsuarioCartao cartao = usuario.getCartoes().stream().filter(e -> e.getId() == id).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Cartão não encontrado"));

            setCarrinhoCartao(usuario, cartao);
            Util.salvarLogCartaoSelecionado(cartao);

        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao selecionar cartão: " + e.getMessage() + "\n");
        }
    }

    private void setCarrinhoCartao(Usuario usuario, UsuarioCartao cartao) {
        try {
            usuario.getCarrinho().setCartao(cartao);
            menuNavegacao(menuController, MenuType.ENDERECO_CHECKOUT_CONTROLLER);

        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao selecionar cartão: " + e.getMessage() + "\n");

        }
    }
}
