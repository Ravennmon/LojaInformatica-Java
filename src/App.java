import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.CarrinhoController;
import controller.CheckoutController;
import controller.MetodoDePagamentoController;
import controller.EcommerceController;
import controller.EnderecoController;
import controller.FormaDeEntregaController;
import controller.MenuPrincipal;
import controller.ProdutoController;
import controller.UsuarioController;
import controller.menu.IMenu;
import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Categoria;
import model.FormaDeEntrega;
import model.Produto;
import model.Usuario;
import model.pagamento.Cartao;
import model.pagamento.MetodoDePagamento;

public class App {
    public static void main(String[] args) {
        EcommerceController ecommerceController = new EcommerceController();
        MenuController menuController = new MenuController();

        fakeUser(ecommerceController);
        fakeProdutosInfomatica(ecommerceController);
        fakeMetodosDePagamento(ecommerceController);
        fakeFormasDePagamentos(ecommerceController);
        
        MenuBase menuPrincipal = new MenuPrincipal(menuController, ecommerceController);
        UsuarioController usuarioController = new UsuarioController(menuController, ecommerceController);
        CarrinhoController carrinhoController = new CarrinhoController(menuController, ecommerceController);
        ProdutoController produtoController = new ProdutoController(menuController, ecommerceController);
        MetodoDePagamentoController metodoDePagamentoController = new MetodoDePagamentoController(menuController, ecommerceController);
        EnderecoController enderecoController = new EnderecoController(menuController, ecommerceController);
        FormaDeEntregaController formaDeEntregaController = new FormaDeEntregaController(menuController, ecommerceController);
        CheckoutController checkoutController = new CheckoutController(menuController, ecommerceController);

        List<IMenu> menus = new ArrayList<>();
        menus.addAll(Arrays.asList(menuPrincipal, usuarioController, produtoController, carrinhoController, metodoDePagamentoController, enderecoController, formaDeEntregaController, checkoutController));

        menuController.setMenus(menus);
        menuController.setMenuAtual(menuPrincipal);

        while (true) {
            menuController.mostraMenuAtual();
            menuController.gerenciaOpcao();
        }
    }

    private static void fakeUser(EcommerceController ecommerceController) {
        Usuario usuario = new Usuario("Teste", "teste@teste.com", "123", "123");
        ecommerceController.adicionarUsuario(usuario);
        ecommerceController.setUsuarioLogado(usuario);
    }

    private static void fakeProdutosInfomatica(EcommerceController ecommerceController)
    {
        Categoria categoria = new Categoria("Periféricos", "Periféricos de computador");
        Produto produto1 = new Produto("Mouse Razer", "3200 DPI", 150, 10, categoria);
        Produto produto2 = new Produto("Teclado Mecânico", "Switch Cherry MX", 300, 5, categoria);
        Produto produto3 = new Produto("Monitor 24", "144Hz", 1000, 3, categoria);

        List<Produto> produtos = new ArrayList<>();
        produtos.addAll(Arrays.asList(produto1, produto2, produto3));
        ecommerceController.setProdutos(produtos);

    }

    private static void fakeMetodosDePagamento(EcommerceController ecommerceController){
        MetodoDePagamento cartaoDeCredito = new Cartao("Cartão de Crédito", true, false);
        MetodoDePagamento cartaoDeDebito = new Cartao("Cartão de Débito", true, false);

        List<MetodoDePagamento> metodosDePagamento = new ArrayList<>();
        metodosDePagamento.addAll(Arrays.asList(cartaoDeCredito, cartaoDeDebito));

        ecommerceController.setMetodosDePagamento(metodosDePagamento);
    }

    private static void fakeFormasDePagamentos(EcommerceController ecommerceController){
        FormaDeEntrega retiradaLoja = new FormaDeEntrega("Retirar na loja", 20);
        FormaDeEntrega entregaNormal = new FormaDeEntrega("Entrega Normal", 10);
        FormaDeEntrega entregaExpressa = new FormaDeEntrega("Entrega Expressa", 20);

        List<FormaDeEntrega> formasDeEntrega = new ArrayList<>();
        formasDeEntrega.addAll(Arrays.asList(entregaNormal, entregaExpressa, retiradaLoja));

        ecommerceController.setFormasDeEntrega(formasDeEntrega);
    }
}
