package controller.checkout;

import controller.EcommerceController;
import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.UsuarioCartao;
import model.Usuario;
import util.Util;
import view.CartaoCheckoutView;
import view.UsuarioCartaoView;

public class CartaoCheckoutController extends MenuBase {
    public CartaoCheckoutController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
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
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void cadastrarCartao() {
        UsuarioCartao cartao = UsuarioCartaoView.cadastrarUsuarioCartao();

        Usuario usuario = ecommerceController.getUsuarioLogado();
        usuario.addCartao(cartao);
        setCarrinhoCartao(usuario, cartao);
    }

    public void visualizarUsuarioCartaos() {
        Usuario usuario = ecommerceController.getUsuarioLogado();
        UsuarioCartaoView.visualizarUsuarioCartaos(usuario.getCartoes());
    }

    
    public void selecionarCartao() {
        visualizarUsuarioCartaos();
        int id = Integer.parseInt(Util.nextLine("Informe o id do cartão que deseja utilizar:"));

        Usuario usuario = ecommerceController.getUsuarioLogado();
        UsuarioCartao cartao = usuario.getCartoes().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        
        setCarrinhoCartao(usuario, cartao);
    }

    private void setCarrinhoCartao(Usuario usuario, UsuarioCartao cartao) {
        usuario.getCarrinho().setCartao(cartao);

        menuController.setMenuAtual(menuController.getMenus().get(10));
    }
}
