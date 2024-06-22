package controller.checkout;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import model.Usuario;
import model.pagamento.MetodoDePagamento;
import view.ErroView;
import util.Util;
import util.enums.MenuType;
import view.MenuPrincipalView;
import view.checkout.MetodoDePagamentoView;

public class MetodoDePagamentoController extends MenuBase {
    public MetodoDePagamentoController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
    }

    @Override
    public void mostraMenu() {
        try {
            MetodoDePagamentoView.mostraMenu(ecommerce);
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao mostrar menu de métodos de pagamento: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        if (opcao == 0) {
            menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
        } else if (opcao > 0 && opcao <= ecommerce.getMetodosDePagamento().size()) {
            selecionaMetodoDePagamento(opcao);
        } else {
            MenuPrincipalView.opcaoInvalida();
        }
    }

    public void selecionaMetodoDePagamento(int opcao) {
        try {
            Usuario usuario = ecommerce.getUsuarioLogado();
            MetodoDePagamento metodoDePagamento = ecommerce.getMetodosDePagamento().get(opcao - 1);

            usuario.getCarrinho().setMetodoDePagamento(metodoDePagamento);

            if (metodoDePagamento.isCartao()) {
                menuNavegacao(menuController, MenuType.CARTAO_CHECKOUT_CONTROLLER);
            } else {
                Util.salvarLogPagamento(metodoDePagamento.getDescricao());
                menuNavegacao(menuController, MenuType.ENDERECO_CHECKOUT_CONTROLLER);
            }
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao selecionar método de pagamento: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }
}
