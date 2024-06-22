package view;

import model.Usuario;
import util.Util;

public class UsuarioContaView {
    public static void mostraMenu() {
        System.out.println("Usuario:");
        System.out.println("1. Visualizar conta");
        System.out.println("2. Editar conta");
        System.out.println("3. Excluir conta");
        System.out.println("0. Voltar");
    }


    public static void visualizarConta(Usuario usuario) {
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Telefone: " + usuario.getTelefone());
    }

    public static Usuario editarConta(Usuario usuario) {
        try {
            String nome = Util.nextLine("Digite seu nome:");
            String telefone = Util.nextLine("Digite seu telefone:");
            String email = Util.nextLine("Digite seu email:");
            String senha = Util.nextLine("Digite sua senha");
            String senhaConfirmacao = Util.nextLine("Confirme sua senha");
    
            while (!senha.equals(senhaConfirmacao)) {
                System.out.println("Senhas não conferem.");
                senha = Util.nextLine("Digite sua senha");
                senhaConfirmacao = Util.nextLine("Confirme sua senha");
            }
            Util.salvarLogEditarConta(usuario);
            return new Usuario(nome, email, senha, telefone);
            
        } catch (Exception e) {
            System.out.println("Erro ao editar conta: " + e.getMessage());
            return null;
        }
    }

    
}
