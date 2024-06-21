package util.factories;

import model.Categoria;
import model.Produto;

public class ProdutoFactory {
    public static Produto criarProduto(String nome,String descricao, float preco, int quantidade, Categoria categoria) {
        return new Produto(nome, descricao, preco, quantidade, categoria);
    }
}
