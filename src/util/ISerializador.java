package util;

public interface ISerializador {
    void serializar(Object objeto, String nomeArquivo);
    Object desserializar(String nomeArquivo);
}