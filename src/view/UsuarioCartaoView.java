package view;

import java.util.List;

import model.UsuarioCartao;
import util.Util;

public class UsuarioCartaoView {
    public static void mostraMenu() {
        System.out.println("Cartoes:");
        System.out.println("1. Adicionar cartao");
        System.out.println("2. Visualizar cartoes");
        System.out.println("3. Editar cartao");
        System.out.println("4. Excluir cartao");
        System.out.println("0. Voltar");
    }

    public static UsuarioCartao cadastrarUsuarioCartao(){
        Util.limpaConsole();
        
        String numeroCartao = Util.nextLine("Informe o número do cartão:");
        String nomeTitular = Util.nextLine("Informe o nome do titular:");
        String validade = Util.nextLine("Informe a validade:");
        String cvv = Util.nextLine("Informe o CVV:");
        String debito = Util.nextLine("O cartão é de débito? (S/N)");
        String credito = Util.nextLine("O cartão é de crédito? (S/N)");

        boolean isDebito = debito.equalsIgnoreCase("S");
        boolean isCredito = credito.equalsIgnoreCase("S");

        return new UsuarioCartao(nomeTitular, numeroCartao, validade, cvv, isCredito, isDebito);
    }

    public static void visualizarUsuarioCartaos(List<UsuarioCartao> cartoes) {
        Util.limpaConsole();

        if(cartoes.isEmpty()){
            System.out.println("Nenhum cartão cadastrado.");
            return;
        }
        
        for (UsuarioCartao cartao : cartoes) {
            System.out.println(cartao);
        }
    }

    public static int informarIdCartao() {
        return Util.nextInt("Informe o id do cartão:");
    }

    public static void cartaoSucesso() {
        System.out.println("Cartão cadastrado com sucesso!");
    }
}
