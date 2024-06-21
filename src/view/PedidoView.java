package view;

import java.util.List;

import model.Pedido;
import model.Produto;

public class PedidoView {
    public static void mostraMenu() {
        System.out.println("1. Visualizar Pedidos");
        System.out.println("2. Cancelar Pedido");
        System.out.println("0. Voltar");
        
    }

    public static void visualizarPedidos(List<Pedido> pedidos) {
        if(pedidos.isEmpty()){
            System.out.println("Nenhum pedido encontrado.");
            return;
        }
        
        for (Pedido pedido : pedidos) {
            mostrarPedido(pedido);
        }
    }

    public static void mostrarPedido(Pedido pedido) {
        System.out.println("--------------------");
        System.out.println("");
        System.out.println("Pedido: " + pedido.getId());
        System.out.println("Data: " + pedido.getData());
        System.out.println("Valor total: " + pedido.getValorTotal());
        System.out.println("Situação: " + pedido.getSituacao());
        System.out.println("Método de pagamento: " + pedido.getMetodoDePagamento().getDescricao());
        //System.out.println("Endereço de entrega: " + pedido.getEnderecoEntrega().getRua() + ", " + pedido.getEnderecoEntrega().getNumero() + " - " + pedido.getEnderecoEntrega().getBairro());
        //System.out.printl

        System.out.println("");
        System.out.println("Produtos: ");
        for (Produto produto : pedido.getProdutos()) {
            System.out.println(produto.getNome() + " - " + produto.getPreco());
        }

        System.out.println("");
        System.out.println("--------------------");

        System.out.println("0. Voltar");
    }
}
