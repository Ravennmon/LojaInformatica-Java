package controller.checkout;

import java.util.List;

import controller.EcommerceController;
import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Carrinho;
import model.Endereco;
import model.FormaDeEntrega;
import model.Pedido;
import model.ProdutoCarrinho;
import model.Usuario;
import model.pagamento.MetodoDePagamento;
import view.MenuPrincipalView;
import util.Util;
import view.checkout.CheckoutView;

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
                MenuPrincipalView.opcaoInvalida();
        }
    }

    public void confirmarCompra() {
        try {
            Carrinho carrinho = ecommerceController.getUsuarioLogado().getCarrinho();
            Usuario usuario = carrinho.getUsuario();
            List<ProdutoCarrinho> produtos = carrinho.getProdutos();
            Endereco enderecoEntrega = carrinho.getEnderecoEntrega();
            FormaDeEntrega formaDeEntrega = carrinho.getFormaDeEntrega();
            MetodoDePagamento metodoDePagamento = carrinho.getMetodoDePagamento();
            Pedido pedido = new Pedido(usuario, produtos, metodoDePagamento, formaDeEntrega, enderecoEntrega);
            ecommerceController.getPedidos().add(pedido);
            usuario.getPedidos().add(pedido);
            menuController.setMenuAtual(menuController.getMenus().get(8));
            Util.salvarLogConfirmarCompra(carrinho, usuario, pedido, enderecoEntrega, formaDeEntrega);
            
        } catch (Exception e) {
            System.out.println("Erro ao confirmar a compra: " + e.getMessage());
        }
    }


}
