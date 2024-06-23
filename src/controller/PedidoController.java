package controller;

import controller.menu.MenuController;
import model.Ecommerce;
import model.Pedido;
import model.Usuario;
import util.Serializador;
import util.Util;
import util.enums.MenuType;
import view.ErroView;
import view.MenuPrincipalView;
import view.PedidoView;

import java.util.NoSuchElementException;

public class PedidoController extends BaseController {

    public PedidoController(MenuController menuController, Ecommerce ecommerce, Serializador serializador) {
        super(menuController, ecommerce, serializador);
    }

    @Override
    public void mostraMenu() {
        PedidoView.mostraMenu();
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case 1:
                visualizarTodosPedidos();
                break;
            case 2:
                cancelarPedido();
                break;
            case 0:
                menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
                break;
        }
    }

    private void visualizarTodosPedidos() {
        PedidoView.visualizarPedidos(ecommerce.getPedidos());
    }

    public void visualizarPedidosUsuario() {
        Usuario usuario = ecommerce.getUsuarioLogado();
        PedidoView.visualizarPedidos(usuario.getPedidos());
    }

    private void cancelarPedido() {
        Usuario usuario = ecommerce.getUsuarioLogado();

        if (usuario.getPedidos().isEmpty()) {
            PedidoView.nenhumPedidoDisponivel();
            return;
        }

        try {
            visualizarPedidosUsuario();

            int id = PedidoView.informarIdPedido();
            
            Pedido pedido = usuario.getPedidos().stream()
                                   .filter(p -> p.getId() == id)
                                   .findFirst()
                                   .orElseThrow(() -> new NoSuchElementException("Pedido não encontrado."));

            if (pedido.getSituacao().equals("Cancelado")) {
                PedidoView.pedidoJaCancelado();
                return;
            }

            pedido.setSituacao("Cancelado");
            Util.salvarLogPedidoCancelado(pedido);
            serializarObjeto(pedido, "Pedido_" + pedido.getId());
            PedidoView.pedidoCancelado();
        } catch (NumberFormatException e) {
            ErroView.mostrarErro("ID de pedido inválido.");
        } catch (NoSuchElementException e) {
            ErroView.mostrarErro(e.getMessage());
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao cancelar pedido: " + e.getMessage());
        }
    }
}
