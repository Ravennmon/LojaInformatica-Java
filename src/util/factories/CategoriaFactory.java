package util.factories;

import model.Categoria;

public class CategoriaFactory {
    public static Categoria criarCategoria(String nome, String descricao) {
        return new Categoria(nome, descricao);
    }
}
