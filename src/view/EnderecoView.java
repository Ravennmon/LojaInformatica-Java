package view;

import java.util.List;

import model.Endereco;
import util.Util;

public class EnderecoView {
    public static void mostraMenu() {
        System.out.println("Endereco:");
        System.out.println("1. Adicionar endereco");
        System.out.println("2. Visualizar enderecos");
        System.out.println("3. Editar endereco");
        System.out.println("4. Excluir endereco");
        System.out.println("0. Voltar");
    }

    public static Endereco cadastrarEndereco(){
        String cep = Util.nextLine("Informe o CEP:");

        String estado = Util.nextLine("Informe o estado:");
        
        String cidade = Util.nextLine("Informe a cidade:");

        String bairro = Util.nextLine("Informe o bairro:");
        
        String logradouro = Util.nextLine("Informe o logradouro:");

        String numero = Util.nextLine("Informe o número:");

        String complemento = Util.nextLine("Informe o complemento:");

        return new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, estado, false);
    }

    public static void visualizarEnderecos(List<Endereco> enderecos) {
        if(enderecos.isEmpty()){
            System.out.println("Nenhum endereço cadastrado.");
            return;
        }
        
        for (Endereco endereco : enderecos) {
            System.out.println(endereco);
        }
    }
}
