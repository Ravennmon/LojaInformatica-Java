package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializador implements ISerializador {
    @Override
    public void serializar(Object objeto, String nomeArquivo) {
        try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(objeto);
            System.out.println("Objeto serializado e salvo em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao serializar objeto: " + e.getMessage());
        }
    }

    public void deserializar(Object objeto, String nomeArquivo) {
        try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(objeto);
            System.out.println("Objeto serializado e salvo em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao serializar objeto: " + e.getMessage());
        }
    }
}