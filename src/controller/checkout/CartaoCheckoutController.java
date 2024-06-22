package controller.checkout;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.UsuarioCartao;
import util.Util;
import util.enums.MenuType;
import model.Ecommerce;
import model.Usuario;
import view.CartaoCheckoutView;
import view.ErroView;
import view.MenuPrincipalView;
import view.UsuarioCartaoView;

public class CartaoCheckoutController extends MenuBase {
    public CartaoCheckoutController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
    }

    @Override
    public void mostraMenu() {
        CartaoCheckoutView.mostraMenu();
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case 1:
                cadastrarCartao();
                break;
            case 2:
                selecionarCartao();
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.MENU_PRINCIPAL.getIndex()));
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

        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao cadastrar cartão.\n");
        }
    }

    public void visualizarUsuarioCartaos() {
        try {
            Usuario usuario = ecommerce.getUsuarioLogado();
            UsuarioCartaoView.visualizarUsuarioCartaos(usuario.getCartoes());
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao visualizar cartões" + e.getMessage() + "\n");
        }
    }

    
    public void selecionarCartao() {
        try {
            visualizarUsuarioCartaos();
            int id = CartaoCheckoutView.informarIdCartao();
    
            Usuario usuario = ecommerce.getUsuarioLogado();
            UsuarioCartao cartao = usuario.getCartoes().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
            
            setCarrinhoCartao(usuario, cartao);
            Util.salvarLogCartaoSelecionado(cartao);
    
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao selecionar cartão:" + e.getMessage() + "\n");;
            
        }
    }

    private void setCarrinhoCartao(Usuario usuario, UsuarioCartao cartao) {
        try {
            usuario.getCarrinho().setCartao(cartao);

            menuController.setMenuAtual(menuController.getMenus().get(MenuType.ENDERECO_CHECKOUT_CONTROLLER.getIndex()));
    
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao selecionar cartão:" + e.getMessage() + "\n");
        
        }
    }
}
