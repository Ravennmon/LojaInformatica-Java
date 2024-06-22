package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import model.Pedido;
import model.Usuario;
import util.Util;
import view.MenuPrincipalView;
import view.PedidoView;

public class PedidoController extends MenuBase {
    public PedidoController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
    }

    @Override
    public void mostraMenu() {
        PedidoView.mostraMenu();
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case 1:
                PedidoView.visualizarPedidos(ecommerce.getPedidos());
                break;
            case 2:
                cancelarPedido();
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
        }
    }

    public void visualizarPedidos() {
        Usuario usuario = ecommerce.getUsuarioLogado();
        PedidoView.visualizarPedidos(usuario.getPedidos());
    }
    
    public void cancelarPedido() {
        visualizarPedidos();

        Usuario usuario = ecommerce.getUsuarioLogado();

        if(usuario.getPedidos().isEmpty()){
            return;
        }

        int id = Integer.parseInt(Util.nextLine("Informe o id do pedido que deseja cancelar:"));
        
        Pedido pedido = usuario.getPedidos().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        
        if(pedido.getSituacao().equals("Cancelado")){
            System.out.println("Pedido já está cancelado");
            return;
        }

        pedido.setSituacao("Cancelado");
    }
    
}
