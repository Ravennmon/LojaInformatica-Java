package controller;

import java.util.Map;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Carrinho;
import model.Endereco;
import model.FormaDeEntrega;
import model.Pedido;
import model.Produto;
import model.Usuario;
import model.pagamento.MetodoDePagamento;
import view.CheckoutView;

public class CheckoutController extends MenuBase {
    public CheckoutController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        CheckoutView.mostraMenu(ecommerceController);
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case 1:
                confirmarCompra();
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void confirmarCompra() {
        Carrinho carrinho = ecommerceController.getUsuarioLogado().getCarrinho();
        Usuario usuario = carrinho.getUsuario();
        Map<Produto, Integer> produtos = carrinho.getProdutos();
        Endereco enderecoEntrega = carrinho.getEnderecoEntrega();
        FormaDeEntrega formaDeEntrega = carrinho.getFormaDeEntrega();
        MetodoDePagamento metodoDePagamento = carrinho.getMetodoDePagamento();
        Pedido pedido = new Pedido(usuario, produtos, metodoDePagamento, formaDeEntrega, enderecoEntrega);
        ecommerceController.getPedidos().add(pedido);
        usuario.getPedidos().add(pedido);

        menuController.setMenuAtual(menuController.getMenus().get(8));
    }


}
