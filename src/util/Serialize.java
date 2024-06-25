package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Serialize {
    public static void store(Object obj, String name) throws Exception{
        try {
            File caminho = new File("obj/" + name + ".ser");

            caminho.getParentFile().mkdirs();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(caminho));
            objOutput.writeObject(obj);
            objOutput.close();
        } catch (Exception e) {
            throw new Exception("Não foi possível salvar o objeto : " + e.getMessage());
        }
    }

    public static Object get(String name) throws Exception{
        try {
            File caminho = new File("obj/Produtos.ser");

            if (caminho.exists() && caminho.isFile()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(caminho));
                return objInput.readObject();
            }
            throw new Exception("Objeto não encontrado");
        } catch (Exception e) {
            throw new Exception("Não foi possível Ler o objeto : " + e.getMessage());
        }
    }
    
}
