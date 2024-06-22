package view;

import model.Ecommerce;
import model.Usuario;
import util.Util;

public class UsuarioView {
    public static void mostraMenu(Ecommerce ecommerce) {
        System.out.println("Usuário:");

        if(ecommerce.isUsuarioLogado()){
            menuLogado();
            return;
        }

        menuDeslogado();
    }

    public static void menuLogado(){
        Util.limpaConsole();

        System.out.println("1. Enderecos");
        System.out.println("2. Cartoes");
        System.out.println("3. Pedidos");
        System.out.println("4. Conta");
        System.out.println("5. Logout");
        System.out.println("0. Voltar");
    }

    public static void menuDeslogado(){
        Util.limpaConsole();

        System.out.println("1. Cadastrar-se");
        System.out.println("2. Login");
        System.out.println("0. Voltar");
    }

    public static Usuario cadastrarUsuario(){
        Util.limpaConsole();

        String nome = Util.nextLine("Digite seu nome:");
        String telefone = Util.nextLine("Digite seu telefone:");
        String email = Util.nextLine("Digite seu email:");

        while (!Util.validaEmail(email)) {
            System.out.println("Email inválido.");
            email = Util.nextLine("Digite seu email novamente:");
        }

        String senha = Util.nextLine("Digite sua senha");
        String senhaConfirmacao = Util.nextLine("Confirme sua senha");

        while (!senha.equals(senhaConfirmacao)) {
            System.out.println("\n Senhas não conferem. \n");
            senha = Util.nextLine("Digite sua senha");
            senhaConfirmacao = Util.nextLine("Confirme sua senha");
        }


        return new Usuario(nome, email, senha, telefone);
    }

    public static Usuario login(Ecommerce ecommerce){
        Util.limpaConsole();

        String email = Util.nextLine("Digite seu email:");
        String senha = Util.nextLine("Digite sua senha:");

        return ecommerce.getUsuarios().stream()
                .filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha)).findFirst().orElse(null);
    
    }

    public static void loginSucesso(){
        Util.limpaConsole();

        System.out.println("\n Login realizado com sucesso. \n");
    }

    public static void loginFalha(){
        Util.limpaConsole();
        
        System.out.println("\n Email ou senha inválidos. \n");
    }
}
