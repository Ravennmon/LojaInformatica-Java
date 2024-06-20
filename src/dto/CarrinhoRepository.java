package dto;

import model.Produto;

public interface CarrinhoRepository {
    public void adicionarProduto(Produto produto, int quantidade);
    
    public void adicionarProduto(Produto produto);
   
}
