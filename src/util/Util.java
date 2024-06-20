package util;

import java.util.Scanner;

public class Util {
    private static int idAtual = 0;

    public static synchronized int gerarId() {
        return ++idAtual;
    }

    public static void limpaConsole() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public static String nextLine(String mensagem){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensagem);
        return sc.nextLine();
    }

    public static int nextInt(String mensagem){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensagem);
        return sc.nextInt();
    }

    public static boolean validaEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
