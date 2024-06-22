package view;

import java.util.Map;

import model.FormaDeEntrega;
import model.Pedido;
import model.Produto;

public class PedidoView {
    public static void mostraMenu() {
        
    }

    public static void mostrarPedido(Pedido pedido) {
        System.out.println("Pedido: " + pedido.getId());
        System.out.println("Data: " + pedido.getData());
        
        FormaDeEntrega formaDeEntrega = pedido.getFormaDeEntrega();
        pedido.setFormaDeEntrega(formaDeEntrega);
        if (formaDeEntrega != null) {
            System.out.println("Valor total: " + (pedido.getValorTotal() + formaDeEntrega.getValor()) + " - Frete: " + formaDeEntrega.getValor());
        } else {
            System.out.println("Valor total: " + pedido.getValorTotal());
        }
        
        System.out.println("Situação: " + pedido.getSituacao());
        System.out.println("Método de pagamento: " + pedido.getMetodoDePagamento().getDescricao());
        //System.out.println("Endereço de entrega: " + pedido.getEnderecoEntrega().getRua() + ", " + pedido.getEnderecoEntrega().getNumero() + " - " + pedido.getEnderecoEntrega().getBairro());
        //System.out.printl
    
        System.out.println("Produtos: ");
        for (Map.Entry<Produto, Integer> entry : pedido.getProdutos().entrySet()) {
            Produto produto = entry.getKey();
            Integer quantidade = entry.getValue();
            System.out.println(produto.getNome() + " - " + produto.getPreco() + " - " + quantidade);
        }
        
        pedido.processarPedido();
        System.out.println("Situação: " + pedido.getSituacao());
        finalizarPedido(pedido);
       
    }

    public static void finalizarPedido(Pedido pedido) {
        System.out.println("\nPedido finalizado. Obrigado pela sua compra!\n");
        System.exit(0);
    }
}
