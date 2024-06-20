package util.factories.factoriesController;

import controller.EcommerceController;
import controller.UsuarioController;
import controller.menu.MenuController;
import controller.CarrinhoController;
import controller.ProdutoController;
import controller.CheckoutController;

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



}
