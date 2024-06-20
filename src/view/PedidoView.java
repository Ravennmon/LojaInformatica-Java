package view;

import model.Pedido;
import model.Produto;

public class PedidoView {
    public static void mostraMenu() {
        
    }

    public static void mostrarPedido(Pedido pedido) {
        System.out.println("Pedido: " + pedido.getId());
        System.out.println("Data: " + pedido.getData());
        System.out.println("Valor total: " + pedido.getValorTotal());
        System.out.println("Situação: " + pedido.getSituacao());
        System.out.println("Método de pagamento: " + pedido.getMetodoDePagamento().getDescricao());
        System.out.println("Endereço de entrega: " + pedido.getEnderecoEntrega().getRua() + ", " + pedido.getEnderecoEntrega().getNumero() + " - " + pedido.getEnderecoEntrega().getBairro());
        //System.out.printl

        System.out.println("Produtos: ");
        for (Produto produto : pedido.getProdutos()) {
            System.out.println(produto.getNome() + " - " + produto.getPreco());
        }
    }
}
