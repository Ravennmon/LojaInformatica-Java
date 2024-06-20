package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;

public class CheckoutController extends MenuBase {
    public CheckoutController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        System.out.println("Informe o método de pagamento");
        
        for(int i = 0; i < ecommerceController.getMetodosDePagamento().size(); i++){
            System.out.println((i + 1) + ". " + ecommerceController.getMetodosDePagamento().get(i).getDescricao());
        }

        System.out.println("0. Voltar");
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

        ecommerceController.getUsuarioLogado().getCarrinho().setMetodoDePagamento(ecommerceController.getMetodosDePagamento().get(opcao - 1));
        System.out.println("Método de pagamento selecionado.");
    }
}
