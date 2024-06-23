package util;

public interface ISerializador {
    void serializar(Object objeto, String nomeArquivo);
    void deserializar(Object objeto, String nomeArquivo);
}