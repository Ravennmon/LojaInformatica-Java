package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializador implements ISerializador {
    @Override
    public void serializar(Object objeto, String nomeArquivo) {
        try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo + ".ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(objeto);
            System.out.println("Objeto serializado e salvo em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao serializar objeto: " + e.getMessage());
        }
    }

    @Override
    public Object desserializar(String nomeArquivo) {
        try (FileInputStream fileIn = new FileInputStream(nomeArquivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            return in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao desserializar objeto: " + e.getMessage());
            return null;
        }
    }
}