package view;

import controller.EcommerceController;
import model.Usuario;
import util.Util;

public class UsuarioView {
    public static void mostraMenu() {
        System.out.println("Usuário:");
        System.out.println("1. Cadastrar-se");
        System.out.println("2. Login");
        System.out.println("0. Voltar");
    }

    public static Usuario cadastrarUsuario(){
        String nome = Util.nextLine("Digite seu nome:");
        String telefone = Util.nextLine("Digite seu telefone:");
        String email = Util.nextLine("Digite seu email:");
        String senha = Util.nextLine("Digite sua senha");

        while (!Util.validaEmail(email)) {
            System.out.println("Email inválido.");
            email = Util.nextLine("Digite seu email novamente:");
        }

        return new Usuario(nome, email, senha, telefone);
    }

    public static Usuario login(EcommerceController ecommerceController){
        String email = Util.nextLine("Digite seu email:");
        String senha = Util.nextLine("Digite sua senha:");

        return ecommerceController.getUsuarios().stream()
                .filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha)).findFirst().orElse(null);
    
    }
}
