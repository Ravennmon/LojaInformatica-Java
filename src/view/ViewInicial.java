package view;

import java.util.Arrays;
import java.util.List;

import controller.EnderecoController;
import controller.FormaDeEntregaController;
import controller.MenuPrincipal;
import controller.PedidoController;
import controller.ProdutoController;
import controller.UsuarioCartaoController;
import controller.UsuarioContaController;
import controller.UsuarioController;
import controller.checkout.CarrinhoController;
import controller.checkout.CartaoCheckoutController;
import controller.checkout.CheckoutController;
import controller.checkout.EnderecoCheckoutController;
import controller.checkout.MetodoDePagamentoController;
import controller.menu.IMenu;
import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Categoria;
import model.Ecommerce;
import model.FormaDeEntrega;
import model.Produto;
import model.pagamento.MetodoDePagamento;
import util.factories.CartaoFactory;
import util.factories.CategoriaFactory;
import util.factories.CollectionFactory;
import util.factories.FormaDePagamentoFactory;
import util.factories.ProdutoFactory;
import util.factories.factoriesController.MenuControllerFactory;

public class ViewInicial {
    private Ecommerce ecommerce;
    private MenuController menuController;

    public ViewInicial() {
        ecommerce = MenuControllerFactory.criarecommerce();
        menuController = MenuControllerFactory.criarMenuController();

        addProdutosInfomatica();
        addMetodosDePagamento();
        addFormasDeEntrega();

        MenuBase menuPrincipal = new MenuPrincipal(menuController, ecommerce);
        UsuarioController usuarioController = MenuControllerFactory.criarUsuarioController(menuController, ecommerce);
        CarrinhoController carrinhoController = MenuControllerFactory.criarCarrinhoController(menuController, ecommerce);
        ProdutoController produtoController = MenuControllerFactory.criarProdutoController(menuController, ecommerce);
        MetodoDePagamentoController metodoDePagamentoController = MenuControllerFactory.criarMetodoDePagamentoController(menuController, ecommerce);
        EnderecoController enderecoController = MenuControllerFactory.criarEnderecoController(menuController, ecommerce);
        FormaDeEntregaController formaDeEntregaController = MenuControllerFactory.criarFormaDeEntregaController(menuController, ecommerce);
        CheckoutController checkoutController = MenuControllerFactory.criarCheckoutController(menuController, ecommerce);
        PedidoController pedidoController = new PedidoController(menuController, ecommerce);
        UsuarioCartaoController usuarioCartaoController = MenuControllerFactory.criarUsuarioCartaoController(menuController, ecommerce);
        EnderecoCheckoutController enderecoCheckoutController = MenuControllerFactory.criarEnderecoCheckoutController(menuController, ecommerce);
        CartaoCheckoutController cartaoCheckoutController = MenuControllerFactory.criarCartaoCheckoutController(menuController, ecommerce);
        UsuarioContaController usuarioContaController = MenuControllerFactory.criarUsuarioContaController(menuController, ecommerce);

        List<IMenu> menus = CollectionFactory.createArrayList();
        menus.addAll(Arrays.asList(
            menuPrincipal, 
            usuarioController, 
            produtoController, 
            carrinhoController, 
            metodoDePagamentoController, 
            enderecoController, 
            formaDeEntregaController, 
            checkoutController, 
            pedidoController, 
            usuarioCartaoController,
            enderecoCheckoutController,
            cartaoCheckoutController,
            usuarioContaController
        ));

        menuController.setMenus(menus);
        menuController.setMenuAtual(menuPrincipal);
    }

    public void mostrarMenu() {
        while (true) {
            menuController.mostraMenuAtual();
            menuController.gerenciaOpcao();
        }
    }

    private void addProdutosInfomatica()
    {
        Categoria categoria = CategoriaFactory.criarCategoria("Periféricos", "Periféricos de computador");
        Produto produto1 = ProdutoFactory.criarProduto("Mouse Razer", "3200 DPI", 150, 10, categoria);
        Produto produto2 = ProdutoFactory.criarProduto("Teclado Mecânico", "Switch Cherry MX", 300, 5, categoria);
        Produto produto3 = ProdutoFactory.criarProduto("Monitor 24", "144Hz", 1000, 3, categoria);

        List<Produto> produtos = CollectionFactory.createArrayList();

        produtos.addAll(Arrays.asList(produto1, produto2, produto3));
        ecommerce.setProdutos(produtos);
    }

    private void addMetodosDePagamento(){
        MetodoDePagamento cartaoDeCredito = CartaoFactory.criarCartao("Cartão de Crédito", true, false);
        MetodoDePagamento cartaoDeDebito = CartaoFactory.criarCartao("Cartão de Débito", true, false);

        List<MetodoDePagamento> metodosDePagamento = CollectionFactory.createArrayList();
        metodosDePagamento.addAll(Arrays.asList(cartaoDeCredito, cartaoDeDebito));

        ecommerce.setMetodosDePagamento(metodosDePagamento);
    }

    private void addFormasDeEntrega(){
        FormaDeEntrega retiradaLoja = FormaDePagamentoFactory.criarFormaDePagamento("Retirar na loja", 0);
        FormaDeEntrega entregaNormal = FormaDePagamentoFactory.criarFormaDePagamento("Entrega Normal", 10);
        FormaDeEntrega entregaExpressa = FormaDePagamentoFactory.criarFormaDePagamento("Entrega Expressa", 20);

        List<FormaDeEntrega> formasDeEntrega = CollectionFactory.createArrayList();
        formasDeEntrega.addAll(Arrays.asList(entregaNormal, entregaExpressa, retiradaLoja));

        ecommerce.setFormasDeEntrega(formasDeEntrega);
    }
}
