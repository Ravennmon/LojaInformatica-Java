import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.menu.*;
import model.*;
import model.pagamento.MetodoDePagamento;
import util.Serializador;
import util.enums.MenuType;
import util.factories.*;
import util.factories.factoriesController.MenuControllerFactory;
import view.ViewInicial;

public class App {
    public static void main(String[] args) {
        Ecommerce ecommerce = MenuControllerFactory.criarEcommerce();
        MenuController menuController = MenuControllerFactory.criarMenuController();
        Serializador serializador = new Serializador();
        
        bootEcommerce(ecommerce, menuController, serializador);
        
        new ViewInicial().mostrarMenu(menuController);
    }

    private static void bootEcommerce(Ecommerce ecommerce, MenuController menuController, Serializador serializador) {
        addProdutosInformatica(ecommerce);
        addMetodosDePagamento(ecommerce);
        addFormasDeEntrega(ecommerce);
                
        List<IMenu> menus = new ArrayList<>(Arrays.asList(
            MenuControllerFactory.criarMenuPrincipal(menuController, ecommerce, serializador),
            MenuControllerFactory.criarUsuarioController(menuController, ecommerce, serializador),
            MenuControllerFactory.criarUsuarioContaController(menuController, ecommerce, serializador),
            MenuControllerFactory.criarEnderecoController(menuController, ecommerce, serializador),
            MenuControllerFactory.criarUsuarioCartaoController(menuController, ecommerce, serializador),
            MenuControllerFactory.criarPedidoController(menuController, ecommerce, serializador),
            MenuControllerFactory.criarProdutoController(menuController, ecommerce, serializador),
            MenuControllerFactory.criarCarrinhoController(menuController, ecommerce, serializador),
            MenuControllerFactory.criarCheckoutController(menuController, ecommerce, serializador),
            MenuControllerFactory.criarMetodoDePagamentoController(menuController, ecommerce, serializador),
            MenuControllerFactory.criarCartaoCheckoutController(menuController, ecommerce, serializador),
            MenuControllerFactory.criarEnderecoCheckoutController(menuController, ecommerce, serializador),
            MenuControllerFactory.criarFormaDeEntregaController(menuController, ecommerce, serializador)
        ));

        menuController.setMenus(menus);
        menuController.setMenuAtual(menus.get(MenuType.MENU_PRINCIPAL.getIndex()));
    }

    private static void addProdutosInformatica(Ecommerce ecommerce) {
        Categoria perifericos = CategoriaFactory.criarCategoria("Periféricos", "Periféricos de computador");
        Categoria hardware = CategoriaFactory.criarCategoria("Hardware", "Hardware de computador");
        Categoria cadeira = CategoriaFactory.criarCategoria("Cadeira", "Cadeiras gamer");
        
        List<Produto> produtos = new ArrayList<>(Arrays.asList(
            ProdutoFactory.criarProduto("Mouse Razer", "3200 DPI", 150, 10, perifericos),
            ProdutoFactory.criarProduto("Teclado Mecânico", "Switch Cherry MX", 300, 5, perifericos),
            ProdutoFactory.criarProduto("Monitor 24\"", "144Hz", 1000, 3, perifericos),
            ProdutoFactory.criarProduto("Placa de Vídeo", "RTX 3080", 5000, 2, hardware),
            ProdutoFactory.criarProduto("Processador", "i9 10900k", 3000, 5, hardware),
            ProdutoFactory.criarProduto("Memória RAM", "32GB DDR4", 1000, 10, hardware),
            ProdutoFactory.criarProduto("Cadeira Gamer", "DXRacer", 1500, 5, cadeira),
            ProdutoFactory.criarProduto("Cadeira Gamer", "Racer", 1000, 10, cadeira),
            ProdutoFactory.criarProduto("Cadeira Gamer", "Gamer", 800, 15, cadeira)
        
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
