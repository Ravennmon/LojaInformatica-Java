package util.enums;

public enum MenuType {
    MENU_PRINCIPAL(0),
    USUARIO_CONTROLLER(1),
    USUARIO_CONTA_CONTROLLER(2),
    ENDERECO_CONTROLLER(3),
    USUARIO_CARTAO_CONTROLLER(4),
    PEDIDO_CONTROLLER(5),
    PRODUTO_CONTROLLER(6),
    CARRINHO_CONTROLLER(7),
    CHECKOUT_CONTROLLER(8),
    METODO_DE_PAGAMENTO_CONTROLLER(9),
    CARTAO_CHECKOUT_CONTROLLER(10),
    ENDERECO_CHECKOUT_CONTROLLER(11),
    FORMA_DE_ENTREGA_CONTROLLER(12);

    private final int index;

    MenuType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
