package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.CarrinhoController;
import controller.CheckoutController;
import controller.EcommerceController;
import controller.EnderecoController;
import controller.FormaDeEntregaController;
import controller.MenuPrincipal;
import controller.MetodoDePagamentoController;
import controller.PedidoController;
import controller.ProdutoController;
import controller.UsuarioController;
import controller.menu.IMenu;
import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Categoria;
import model.FormaDeEntrega;
import model.Produto;
import model.Usuario;
import model.pagamento.MetodoDePagamento;
import util.factories.CartaoFactory;
import util.factories.CategoriaFactory;
import util.factories.FormaDePagamentoFactory;
import util.factories.ProdutoFactory;
import util.factories.UsuarioFactory;
import util.factories.factoriesController.MenuControllerFactory;

public class ViewInicial {
    private EcommerceController ecommerceController;
    private MenuController menuController;

    public ViewInicial() {
        ecommerceController = MenuControllerFactory.criarEcommerceController();
        menuController = MenuControllerFactory.criarMenuController();

        fakeUser(ecommerceController);
        fakeProdutosInfomatica(ecommerceController);
        fakeMetodosDePagamento(ecommerceController);
        fakeFormasDePagamentos(ecommerceController);

        MenuBase menuPrincipal = new MenuPrincipal(menuController, ecommerceController);
        UsuarioController usuarioController = MenuControllerFactory.criarUsuarioController(menuController, ecommerceController);
        CarrinhoController carrinhoController = MenuControllerFactory.criarCarrinhoController(menuController, ecommerceController);
        ProdutoController produtoController = MenuControllerFactory.criarProdutoController(menuController, ecommerceController);
        MetodoDePagamentoController metodoDePagamentoController = MenuControllerFactory.criarMetodoDePagamentoController(menuController, ecommerceController);
        EnderecoController enderecoController = MenuControllerFactory.criarEnderecoController(menuController, ecommerceController);
        FormaDeEntregaController formaDeEntregaController = MenuControllerFactory.criarFormaDeEntregaController(menuController, ecommerceController);
        CheckoutController checkoutController = MenuControllerFactory.criarCheckoutController(menuController, ecommerceController);
        PedidoController pedidoController = new PedidoController(menuController, ecommerceController);

        List<IMenu> menus = new ArrayList<>();
        menus.addAll(Arrays.asList(menuPrincipal, usuarioController, produtoController, carrinhoController, metodoDePagamentoController, enderecoController, formaDeEntregaController, checkoutController, pedidoController));

        menuController.setMenus(menus);
        menuController.setMenuAtual(menuPrincipal);
    }

    public void mostrarMenu() {
        while (true) {
            menuController.mostraMenuAtual();
            menuController.gerenciaOpcao();
        }
    }

     private static void fakeUser(EcommerceController ecommerceController) {
        Usuario usuario = UsuarioFactory.criarUsuario("Teste", "teste@teste.com", "123", "123");
        ecommerceController.adicionarUsuario(usuario);
        ecommerceController.setUsuarioLogado(usuario);
    }

    private static void fakeProdutosInfomatica(EcommerceController ecommerceController)
    {
        Categoria categoria = CategoriaFactory.criarCategoria("Periféricos", "Periféricos de computador");
        Produto produto1 = ProdutoFactory.criarProduto("Mouse Razer", "3200 DPI", 150, 10, categoria);
        Produto produto2 = ProdutoFactory.criarProduto("Teclado Mecânico", "Switch Cherry MX", 300, 5, categoria);
        Produto produto3 = ProdutoFactory.criarProduto("Monitor 24", "144Hz", 1000, 3, categoria);

        List<Produto> produtos = new ArrayList<>();

        produtos.addAll(Arrays.asList(produto1, produto2, produto3));
        ecommerceController.setProdutos(produtos);
    }

    private static void fakeMetodosDePagamento(EcommerceController ecommerceController){
        MetodoDePagamento cartaoDeCredito = CartaoFactory.criarCartao("Cartão de Crédito", true, false);
        MetodoDePagamento cartaoDeDebito = CartaoFactory.criarCartao("Cartão de Débito", true, false);

        List<MetodoDePagamento> metodosDePagamento = new ArrayList<>();
        metodosDePagamento.addAll(Arrays.asList(cartaoDeCredito, cartaoDeDebito));

        ecommerceController.setMetodosDePagamento(metodosDePagamento);
    }

    private static void fakeFormasDePagamentos(EcommerceController ecommerceController){
        FormaDeEntrega retiradaLoja = FormaDePagamentoFactory.criarFormaDePagamento("Retirar na loja", 20);
        FormaDeEntrega entregaNormal = FormaDePagamentoFactory.criarFormaDePagamento("Entrega Normal", 10);
        FormaDeEntrega entregaExpressa = FormaDePagamentoFactory.criarFormaDePagamento("Entrega Expressa", 20);

        List<FormaDeEntrega> formasDeEntrega = new ArrayList<>();
        formasDeEntrega.addAll(Arrays.asList(entregaNormal, entregaExpressa, retiradaLoja));

        ecommerceController.setFormasDeEntrega(formasDeEntrega);
    }
}
