package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import model.FormaDeEntrega;
import util.Util;
import util.enums.MenuType;
import view.ErroView;
import view.FormaDeEntregaView;
import view.MenuPrincipalView;

public class FormaDeEntregaController extends MenuBase {
    private static final int MENU_PRINCIPAL = 0;

    public FormaDeEntregaController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
    }

    @Override
    public void mostraMenu() {
        FormaDeEntregaView.mostraMenu(ecommerce);
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        if (opcao == MENU_PRINCIPAL) {
            menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
        } else if (opcao > 0 && opcao <= ecommerce.getFormasDeEntrega().size()) {
            selecionaFormaDeEntrega(opcao);
        } else {
            MenuPrincipalView.opcaoInvalida();
        }
    }

    public void selecionaFormaDeEntrega(int opcao) {
        try {
            FormaDeEntrega formaDeEntrega = ecommerce.getFormasDeEntrega().get(opcao - 1);
            menuNavegacao(menuController, MenuType.CHECKOUT_CONTROLLER);
            ecommerce.getUsuarioLogado().getCarrinho().setFormaDeEntrega(formaDeEntrega);
            Util.salvarLogFormaDeEntrega(formaDeEntrega.getNome(), formaDeEntrega.getValor());
        } catch (IndexOutOfBoundsException e) {
            ErroView.mostrarErro("Forma de entrega inválida selecionada.");
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao selecionar a forma de entrega: " + e.getMessage());
        }
    }
}
