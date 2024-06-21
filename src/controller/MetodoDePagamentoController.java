package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Usuario;
import model.UsuarioCartao;
import model.pagamento.MetodoDePagamento;
import view.MetodoDePagamentoView;

public class MetodoDePagamentoController extends MenuBase {
    public MetodoDePagamentoController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        MetodoDePagamentoView.mostraMenu(ecommerceController);
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        if(opcao < 1){
            if(opcao == 0){
                menuController.setMenuAtual(menuController.getMenus().get(0));
                return;
            } 

            System.out.println("Opção inválida.");
        }

        selecionaMetodoDePagamento(opcao);
    }

    public void selecionaMetodoDePagamento(int opcao){
        if(opcao > ecommerceController.getMetodosDePagamento().size()){
            System.out.println("Opção inválida.");
            return;
        }

        Usuario usuario =  ecommerceController.getUsuarioLogado();

        MetodoDePagamento metodoDePagamento = ecommerceController.getMetodosDePagamento().get(opcao - 1);

        usuario.getCarrinho().setMetodoDePagamento(metodoDePagamento);

        if(metodoDePagamento.isCartao()){
            UsuarioCartao usuarioCartao = MetodoDePagamentoView.cadastrarCartao();
            usuario.getCartoes().add(usuarioCartao);
        }

        this.menuController.setMenuAtual(menuController.getMenus().get(5));
    }
}
