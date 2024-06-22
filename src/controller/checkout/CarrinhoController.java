package controller.checkout;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import model.Produto;
import model.ProdutoCarrinho;
import util.Util;
import util.enums.MenuType;
import view.MenuPrincipalView;
import view.checkout.CarrinhoView;

public class CarrinhoController extends MenuBase {
    private static final int OPCAO_VISUALIZAR_PRODUTOS = 1;
    private static final int OPCAO_ADICIONAR_PRODUTO = 2;
    private static final int OPCAO_REMOVER_PRODUTO = 3;
    private static final int OPCAO_METODO_PAGAMENTO = 4;
    private static final int OPCAO_MENU_PRINCIPAL = 0;

    public CarrinhoController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
    }

    @Override
    public void mostraMenu() {
        CarrinhoView.mostraMenu();
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case OPCAO_VISUALIZAR_PRODUTOS:
                visualizarProdutos();
                break;
            case OPCAO_ADICIONAR_PRODUTO:
                adicionarProduto();
                break;
            case OPCAO_REMOVER_PRODUTO:
                removerProduto();
                break;
            case OPCAO_METODO_PAGAMENTO:
                menuNavegacao(menuController, MenuType.METODO_DE_PAGAMENTO_CONTROLLER);
                break;
            case OPCAO_MENU_PRINCIPAL:
                menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
        }
    }

    public void visualizarProdutos() {
        CarrinhoView.visualizarProdutos(ecommerce);
    }

    public void adicionarProduto() {
        try {
            if (!ecommerce.isUsuarioLogado()) {
                CarrinhoView.usuarioDeslogado();
                return;
            }

            CarrinhoView.adicionarProduto();
            String nome = CarrinhoView.nomeProduto(ecommerce);
            Produto produto = getProdutoByName(nome);

            int quantidade = CarrinhoView.quantidadeProduto();

            if (produto.getQuantidadeEstoque() < quantidade) {
                CarrinhoView.quantidadeIndisponivel();
                return;
            }

            ecommerce.getUsuarioLogado().getCarrinho().adicionarProduto(produto, quantidade);
            produto.removerQuantidadeEstoque(produto, quantidade);

            Util.salvarLogProduto(produto.getNome(), produto.getDescricao(), produto.getPreco(), quantidade);
        } catch (IllegalArgumentException e) {
            CarrinhoView.erro("\nProduto não encontrado: " + e.getMessage() + "\n");
        } catch (Exception e) {
            CarrinhoView.erro("\nOcorreu um erro ao adicionar o produto: " + e.getMessage() + "\n");
        }
    }

    private Produto getProdutoByName(String nome) {
        return ecommerce.getProdutos().stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + nome));
    }

    public void removerProduto() {
        try {
            if (!ecommerce.isUsuarioLogado()) {
                CarrinhoView.usuarioDeslogado();
                return;
            }

            CarrinhoView.removerProduto();
            String nome = CarrinhoView.nomeProduto(ecommerce);
            ProdutoCarrinho produtoCarrinho = getProdutoCarrinhoByName(nome);

            Util.salvarLogProdutoRemovido(produtoCarrinho.getProduto().getNome(), produtoCarrinho.getProduto().getDescricao(), produtoCarrinho.getProduto().getPreco());

            try {
                ecommerce.getUsuarioLogado().getCarrinho().removerProduto(produtoCarrinho);
                produtoCarrinho.getProduto().adicionarQuantidadeEstoque(produtoCarrinho.getProduto(), produtoCarrinho.getQuantidade());
                CarrinhoView.produtoRemovido();
 
            } catch (IllegalArgumentException e) {
                CarrinhoView.erro("\nO produto não está no carrinho.\n");
            } catch (Exception e) {
                CarrinhoView.erro("\nOcorreu um erro ao remover o produto: " + e.getMessage() + "\n");
            }
        } catch (Exception e) {
            CarrinhoView.erro("\nOcorreu um erro ao remover o produto: " + e.getMessage() + "\n");
        }
    }

    private ProdutoCarrinho getProdutoCarrinhoByName(String nome) {
        return ecommerce.getUsuarioLogado().getCarrinho().getProdutos().stream()
                .filter(p -> p.getProduto().getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado no carrinho: " + nome));
    }

    public void listarProdutos() {
        ecommerce.getProdutos().forEach(System.out::println);
    }
}
