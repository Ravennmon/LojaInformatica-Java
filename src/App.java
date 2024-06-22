import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.menu.*;
import model.*;
import model.pagamento.MetodoDePagamento;
import util.enums.MenuType;
import util.factories.*;
import util.factories.factoriesController.MenuControllerFactory;
import view.ViewInicial;

public class App {
    public static void main(String[] args) {
        Ecommerce ecommerce = MenuControllerFactory.criarEcommerce();
        MenuController menuController = MenuControllerFactory.criarMenuController();
        
        bootEcommerce(ecommerce, menuController);
        
        new ViewInicial().mostrarMenu(menuController);
    }

    private static void bootEcommerce(Ecommerce ecommerce, MenuController menuController) {
        addProdutosInformatica(ecommerce);
        addMetodosDePagamento(ecommerce);
        addFormasDeEntrega(ecommerce);
                
        List<IMenu> menus = new ArrayList<>(Arrays.asList(
            MenuControllerFactory.criarMenuPrincipal(menuController, ecommerce),
            MenuControllerFactory.criarUsuarioController(menuController, ecommerce),
            MenuControllerFactory.criarUsuarioContaController(menuController, ecommerce),
            MenuControllerFactory.criarEnderecoController(menuController, ecommerce),
            MenuControllerFactory.criarUsuarioCartaoController(menuController, ecommerce),
            MenuControllerFactory.criarPedidoController(menuController, ecommerce),
            MenuControllerFactory.criarProdutoController(menuController, ecommerce),
            MenuControllerFactory.criarCarrinhoController(menuController, ecommerce),
            MenuControllerFactory.criarCheckoutController(menuController, ecommerce),
            MenuControllerFactory.criarMetodoDePagamentoController(menuController, ecommerce),
            MenuControllerFactory.criarCartaoCheckoutController(menuController, ecommerce),
            MenuControllerFactory.criarEnderecoCheckoutController(menuController, ecommerce),
            MenuControllerFactory.criarFormaDeEntregaController(menuController, ecommerce)
        ));

        menuController.setMenus(menus);
        menuController.setMenuAtual(menus.get(MenuType.MENU_PRINCIPAL.getIndex()));
    }

    private static void addProdutosInformatica(Ecommerce ecommerce) {
        Categoria categoria = CategoriaFactory.criarCategoria("Periféricos", "Periféricos de computador");
        
        List<Produto> produtos = new ArrayList<>(Arrays.asList(
            ProdutoFactory.criarProduto("Mouse Razer", "3200 DPI", 150, 10, categoria),
            ProdutoFactory.criarProduto("Teclado Mecânico", "Switch Cherry MX", 300, 5, categoria),
            ProdutoFactory.criarProduto("Monitor 24\"", "144Hz", 1000, 3, categoria)
        ));
        
        ecommerce.setProdutos(produtos);
    }

    private static void addMetodosDePagamento(Ecommerce ecommerce) {
        List<MetodoDePagamento> metodosDePagamento = new ArrayList<>(Arrays.asList(
            CartaoFactory.criarCartao("Cartão de Crédito", true, false),
            CartaoFactory.criarCartao("Cartão de Débito", true, false)
        ));
        
        ecommerce.setMetodosDePagamento(metodosDePagamento);
    }

    private static void addFormasDeEntrega(Ecommerce ecommerce) {
        List<FormaDeEntrega> formasDeEntrega = new ArrayList<>(Arrays.asList(
            FormaDePagamentoFactory.criarFormaDePagamento("Retirar na loja", 0),
            FormaDePagamentoFactory.criarFormaDePagamento("Entrega Normal", 10),
            FormaDePagamentoFactory.criarFormaDePagamento("Entrega Expressa", 20)
        ));
        
        ecommerce.setFormasDeEntrega(formasDeEntrega);
    }
}
