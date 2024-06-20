package views;

import controller.EcommerceController;
import model.Endereco;
import util.Util;

public class EnderecoView {
    public static void mostraMenu() {
        System.out.println("Endereco:");
        System.out.println("1. Escolher endereco");
        System.out.println("2. Adicionar endereco");
        System.out.println("0. Voltar");
    }

    public static Endereco cadastrarEndereco(){
        String cep = Util.nextLine("Informe o CEP:");

        String logradouro = Util.nextLine("Informe o logradouro:");

        String numero = Util.nextLine("Informe o número:");

        String complemento = Util.nextLine("Informe o complemento:");

        String bairro = Util.nextLine("Informe o bairro:");

        String cidade = Util.nextLine("Informe a cidade:");

        String estado = Util.nextLine("Informe o estado:");

        return new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, estado, false);
    }
}
