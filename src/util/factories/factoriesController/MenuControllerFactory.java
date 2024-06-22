package util.factories.factoriesController;

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
import model.Ecommerce;
import controller.ProdutoController;
import controller.UsuarioCartaoController;
import controller.UsuarioContaController;

public class MenuControllerFactory {

    public static UsuarioController criarUsuarioController(MenuController menuController, Ecommerce ecommerce) {
        return new UsuarioController(menuController, ecommerce);
    }

    public static CarrinhoController criarCarrinhoController(MenuController menuController, Ecommerce ecommerce) {
        return new CarrinhoController(menuController, ecommerce);
    }

    public static ProdutoController criarProdutoController(MenuController menuController, Ecommerce ecommerce) {
        return new ProdutoController(menuController, ecommerce);
    }

    public static CheckoutController criarCheckoutController(MenuController menuController, Ecommerce ecommerce) {
        return new CheckoutController(menuController, ecommerce);
    }

    public static MenuController criarMenuController() {
        return new MenuController();
    }

    public static Ecommerce criarecommerce() {
        return new Ecommerce();
    }

    public static MetodoDePagamentoController criarMetodoDePagamentoController(MenuController menuController, Ecommerce ecommerce){
        return new MetodoDePagamentoController(menuController, ecommerce);
    }

    public static FormaDeEntregaController criarFormaDeEntregaController(MenuController menuController, Ecommerce ecommerce){
        return new FormaDeEntregaController(menuController, ecommerce);
    }

    public static EnderecoController criarEnderecoController(MenuController menuController, Ecommerce ecommerce){
        return new EnderecoController(menuController, ecommerce);
    }

    public static PedidoController criarPedidoController(MenuController menuController, Ecommerce ecommerce){
        return new PedidoController(menuController, ecommerce);
    }

    public static UsuarioCartaoController criarUsuarioCartaoController(MenuController menuController, Ecommerce ecommerce){
        return new UsuarioCartaoController(menuController, ecommerce);
    }

    public static EnderecoCheckoutController criarEnderecoCheckoutController(MenuController menuController, Ecommerce ecommerce){
        return new EnderecoCheckoutController(menuController, ecommerce);
    }

    public static CartaoCheckoutController criarCartaoCheckoutController(MenuController menuController, Ecommerce ecommerce){
        return new CartaoCheckoutController(menuController, ecommerce);
    }

    public static UsuarioContaController criarUsuarioContaController(MenuController menuController, Ecommerce ecommerce) {
        return new UsuarioContaController(menuController, ecommerce);
    }

}
