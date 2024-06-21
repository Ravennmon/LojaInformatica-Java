package util.factories;

import model.Usuario;

public class UsuarioFactory {

    public static Usuario criarUsuario(String nome, String email, String senha, String confirmacaoSenha) {
        return new Usuario(nome, email, senha, confirmacaoSenha);
    }
}
