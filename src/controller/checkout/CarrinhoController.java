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
            case 1:
                visualizarProdutos();
                break;
            case 2:
                adicionarProduto();
                break;
            case 3:
                removerProduto();
                break;
            case 4:
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.METODO_DE_PAGAMENTO_CONTROLLER.getIndex()));
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(MenuType.MENU_PRINCIPAL.getIndex()));
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
            Produto produto = ecommerce.getProdutos().stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);

            if (produto == null) {
                CarrinhoView.produtoNaoEcontrado();
                return;
            }

            int quantidade = CarrinhoView.quantidadeProduto();
            
            if(produto.getQuantidadeEstoque() < quantidade){
                CarrinhoView.quantidadeIndisponivel();
                return;
            }

            ecommerce.getUsuarioLogado().getCarrinho().adicionarProduto(produto, quantidade);

            produto.removerQuantidadeEstoque(produto, quantidade);
    
            Util.salvarLogProduto(produto.getNome(), produto.getDescricao(), produto.getPreco(), quantidade);
        } catch (Exception e) {
            CarrinhoView.erro("\nOcorreu um erro ao adicionar o produto: " + e.getMessage() + "\n");
        }
    }

    public void removerProduto() {
        try {
            if (!ecommerce.isUsuarioLogado()) {
                CarrinhoView.usuarioDeslogado();
                return;
            }


            CarrinhoView.removerProduto();
            String nome = CarrinhoView.nomeProduto(ecommerce);

            Produto produto = ecommerce.getProdutos().stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            ProdutoCarrinho produtoCarrinho = ecommerce.getUsuarioLogado().getCarrinho().getProdutos().stream().filter(p -> p.getProduto().getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);

            if (produtoCarrinho == null) {
                CarrinhoView.produtoNaoEcontrado();
                return;
            }
    
    
            Util.salvarLogProdutoRemovido(produtoCarrinho.getProduto().getNome(), produtoCarrinho.getProduto().getDescricao(), produtoCarrinho.getProduto().getPreco());
    
            try {
                ecommerce.getUsuarioLogado().getCarrinho().removerProduto(produtoCarrinho);
                produto.adicionarQuantidadeEstoque(produto, produtoCarrinho.getQuantidade());
                CarrinhoView.produtoRemovido();
                
            } catch (Exception e) {
                CarrinhoView.erro("\nO produto não está no carrinho.\n");
            }
        } catch (Exception e) {
            CarrinhoView.erro("\nOcorreu um erro ao remover o produto: " + e.getMessage() + "\n");
        }
    }

    public void listarProdutos() {
        ecommerce.getProdutos().forEach(System.out::println);
    }
}
