package controller.checkout;

import java.util.List;

import controller.menu.MenuBase;
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
import view.checkout.CheckoutView;

public class CheckoutController extends MenuBase {
    public CheckoutController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
    }

    @Override
    public void mostraMenu() {
        CheckoutView.mostraMenu(ecommerce);
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
            Carrinho carrinho = ecommerce.getUsuarioLogado().getCarrinho();

            Usuario usuario = carrinho.getUsuario();
            List<ProdutoCarrinho> produtos = carrinho.getProdutos();
            Endereco enderecoEntrega = carrinho.getEnderecoEntrega();
            FormaDeEntrega formaDeEntrega = carrinho.getFormaDeEntrega();
            MetodoDePagamento metodoDePagamento = carrinho.getMetodoDePagamento();
            
            Pedido pedido = new Pedido(usuario, produtos, metodoDePagamento, formaDeEntrega, enderecoEntrega);
    
            ecommerce.getPedidos().add(pedido);
            usuario.getPedidos().add(pedido);
    
            menuController.setMenuAtual(menuController.getMenus().get(8));
    
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao confirmar compra" + e.getMessage() + "\n");
        }
    }


}
