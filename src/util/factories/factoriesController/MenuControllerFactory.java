package util.factories.factoriesController;

import controller.*;
import controller.checkout.*;
import controller.menu.MenuController;
import model.Ecommerce;
import util.Serializador;

public class MenuControllerFactory {

    public static Ecommerce criarEcommerce() {
        return new Ecommerce();
    }

    public static MenuController criarMenuController() {
        return new MenuController();
    }

    public static MenuPrincipalController criarMenuPrincipal(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new MenuPrincipalController(menuController, ecommerce, serializador);
    }

    public static UsuarioController criarUsuarioController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new UsuarioController(menuController, ecommerce, serializador);
    }

    public static CarrinhoController criarCarrinhoController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new CarrinhoController(menuController, ecommerce, serializador);
    }

    public static ProdutoController criarProdutoController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new ProdutoController(menuController, ecommerce, serializador);
    }

    public static CheckoutController criarCheckoutController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new CheckoutController(menuController, ecommerce, serializador);
    }

    public static MetodoDePagamentoController criarMetodoDePagamentoController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new MetodoDePagamentoController(menuController, ecommerce, serializador);
    }

    public static FormaDeEntregaController criarFormaDeEntregaController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new FormaDeEntregaController(menuController, ecommerce, serializador);
    }

    public static EnderecoController criarEnderecoController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new EnderecoController(menuController, ecommerce, serializador);
    }

    public static PedidoController criarPedidoController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new PedidoController(menuController, ecommerce, serializador);
    }

    public static UsuarioCartaoController criarUsuarioCartaoController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new UsuarioCartaoController(menuController, ecommerce, serializador);
    }

    public static EnderecoCheckoutController criarEnderecoCheckoutController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new EnderecoCheckoutController(menuController, ecommerce, serializador);
    }

    public static CartaoCheckoutController criarCartaoCheckoutController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new CartaoCheckoutController(menuController, ecommerce, serializador);
    }

    public static UsuarioContaController criarUsuarioContaController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        return new UsuarioContaController(menuController, ecommerce, serializador);
    }
}
