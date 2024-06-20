package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.FormaDeEntrega;
import view.FormaDeEntregaView;


public class FormaDeEntregaController extends MenuBase {
    public FormaDeEntregaController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        FormaDeEntregaView.mostraMenu(ecommerceController);
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

        selecionaFormaDePagamento(opcao);


    }

    public void selecionaFormaDePagamento(int opcao){
        FormaDeEntrega formaDeEntrega = ecommerceController.getFormasDeEntrega().get(opcao - 1);
        ecommerceController.getUsuarioLogado().getCarrinho().setFormaDeEntrega(formaDeEntrega);
        menuController.setMenuAtual(menuController.getMenus().get(7));
    }
}
