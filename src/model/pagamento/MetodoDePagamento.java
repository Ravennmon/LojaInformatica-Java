package model.pagamento;

import util.GeraId;

public abstract class MetodoDePagamento implements IMetodoDePagamento {
    protected int id;
    protected String descricao;
    protected boolean cartao = true;
    protected boolean ativo = true;

    public MetodoDePagamento(String descricao) {
        this.id = GeraId.getProximoId(MetodoDePagamento.class);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MetodoDePagamento [id=" + id + ", descricao=" + descricao + ", cartao=" + cartao + ", ativo=" + ativo
                + "]";
    }

    
    
}
