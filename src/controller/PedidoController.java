package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Pedido;
import view.PedidoView;

public class PedidoController extends MenuBase {
    public PedidoController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        Pedido ultimoPedido = ecommerceController.getUsuarioLogado().getPedidos().get(ecommerceController.getUsuarioLogado().getPedidos().size() - 1);
        PedidoView.mostrarPedido(ultimoPedido);
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
    
}
