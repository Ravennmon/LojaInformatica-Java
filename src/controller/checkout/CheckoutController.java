package controller.checkout;

import java.util.List;

import controller.BaseController;
import controller.menu.MenuController;
import model.Carrinho;
import model.Ecommerce;
import model.Endereco;
import model.FormaDeEntrega;
import model.Pedido;
import model.ProdutoCarrinho;
import model.Usuario;
import model.pagamento.MetodoDePagamento;
import view.ErroView;
import view.MenuPrincipalView;
import util.Serializador;
import util.Util;
import util.enums.MenuType;
import view.checkout.CheckoutView;

public class CheckoutController extends BaseController {
    private static final int OPCAO_CONFIRMAR_COMPRA = 1;
    private static final int OPCAO_MENU_PRINCIPAL = 0;


    public CheckoutController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        super(menuController, ecommerce, serializador);
    }

    @Override
    public void mostraMenu() {
        CheckoutView.mostraMenu(ecommerce);
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case OPCAO_CONFIRMAR_COMPRA:
                confirmarCompra();
                break;
            case OPCAO_MENU_PRINCIPAL:
                menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
                break;
        }
    }

    public void confirmarCompra() {
        try {
            Carrinho carrinho = ecommerce.getUsuarioLogado().getCarrinho();
            Usuario usuario = carrinho.getUsuario();
            List<ProdutoCarrinho> produtos = carrinho.getProdutos();
            Endereco enderecoEntrega = carrinho.getEnderecoEntrega();
            FormaDeEntrega formaDeEntrega = carrinho.getFormaDeEntrega();
            MetodoDePagamento metodoDePagamento = carrinho.getMetodoDePagamento();

            Pedido pedido = new Pedido(usuario, produtos, metodoDePagamento, formaDeEntrega, enderecoEntrega);

            ecommerce.getPedidos().add(pedido);
            usuario.getPedidos().add(pedido);

            menuNavegacao(menuController, MenuType.PEDIDO_CONTROLLER);
            
            serializarObjeto(pedido, "Pedido_" + pedido.getId());
            Util.salvarLogConfirmarCompra(carrinho, usuario, pedido, enderecoEntrega, formaDeEntrega);

        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao confirmar compra: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }
}
