package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.pagamento.MetodoDePagamento;
import util.Util;
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
        try {
            if(opcao > ecommerceController.getMetodosDePagamento().size()){
                System.out.println("Opção inválida.");
                return;
            }
    
            MetodoDePagamento metodoDePagamento = ecommerceController.getMetodosDePagamento().get(opcao - 1);
    
            ecommerceController.getUsuarioLogado().getCarrinho().setMetodoDePagamento(metodoDePagamento);
    
            if(metodoDePagamento.getDescricao().contains("Cartão")){
                MetodoDePagamentoView.cadastrarCartao();
            }
    
            this.menuController.setMenuAtual(menuController.getMenus().get(5));
    
            Util.salvarLogPagamento(metodoDePagamento.getDescricao());
    
            System.out.println("Método de pagamento selecionado com sucesso.\n");

        } catch (Exception e) {
            System.out.println("Erro ao selecionar o método de pagamento: " + e.getMessage());
        }
    }
}
