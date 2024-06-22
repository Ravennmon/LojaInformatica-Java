package util.factories;

import model.Endereco;

public class EnderecoFactory {
    public static Endereco criarEndereco(String rua, String numero, String complemento, String bairro, String cidade, String estado, String cep, String pais, boolean principal) {
        return new Endereco(rua, numero, complemento, bairro, cidade, estado, cep, pais, principal);
    }
}
