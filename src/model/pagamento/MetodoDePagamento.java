package model.pagamento;

public abstract class MetodoDePagamento implements IMetodoDePagamento {
    protected String descricao;
    protected boolean cartao = true;
    protected boolean ativo = true;

    public MetodoDePagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isCartao() {
        return cartao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCartao(boolean cartao) {
        this.cartao = cartao;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
