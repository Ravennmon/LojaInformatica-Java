package util.factories.factoriesController;

import controller.EcommerceController;
import controller.EnderecoController;
import controller.FormaDeEntregaController;
import controller.PedidoController;
import controller.UsuarioController;
import controller.checkout.CarrinhoController;
import controller.checkout.CartaoCheckoutController;
import controller.checkout.CheckoutController;
import controller.checkout.EnderecoCheckoutController;
import controller.checkout.MetodoDePagamentoController;
import controller.menu.MenuController;
import controller.ProdutoController;
import controller.UsuarioCartaoController;

public class MenuControllerFactory {

    public static UsuarioController criarUsuarioController(MenuController menuController, EcommerceController ecommerceController) {
        return new UsuarioController(menuController, ecommerceController);
    }

    public static CarrinhoController criarCarrinhoController(MenuController menuController, EcommerceController ecommerceController) {
        return new CarrinhoController(menuController, ecommerceController);
    }

    public static ProdutoController criarProdutoController(MenuController menuController, EcommerceController ecommerceController) {
        return new ProdutoController(menuController, ecommerceController);
    }

    public static CheckoutController criarCheckoutController(MenuController menuController, EcommerceController ecommerceController) {
        return new CheckoutController(menuController, ecommerceController);
    }

    public static MenuController criarMenuController() {
        return new MenuController();
    }

    public static EcommerceController criarEcommerceController() {
        return new EcommerceController();
    }

    public static MetodoDePagamentoController criarMetodoDePagamentoController(MenuController menuController, EcommerceController ecommerceController){
        return new MetodoDePagamentoController(menuController, ecommerceController);
    }

    public static FormaDeEntregaController criarFormaDeEntregaController(MenuController menuController, EcommerceController ecommerceController){
        return new FormaDeEntregaController(menuController, ecommerceController);
    }

    public static EnderecoController criarEnderecoController(MenuController menuController, EcommerceController ecommerceController){
        return new EnderecoController(menuController, ecommerceController);
    }

    public static PedidoController criarPedidoController(MenuController menuController, EcommerceController ecommerceController){
        return new PedidoController(menuController, ecommerceController);
    }

    public static UsuarioCartaoController criarUsuarioCartaoController(MenuController menuController, EcommerceController ecommerceController){
        return new UsuarioCartaoController(menuController, ecommerceController);
    }

    public static EnderecoCheckoutController criarEnderecoCheckoutController(MenuController menuController, EcommerceController ecommerceController){
        return new EnderecoCheckoutController(menuController, ecommerceController);
    }

    public static CartaoCheckoutController criarCartaoCheckoutController(MenuController menuController, EcommerceController ecommerceController){
        return new CartaoCheckoutController(menuController, ecommerceController);
    }

}
