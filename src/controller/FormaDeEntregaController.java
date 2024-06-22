package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import model.FormaDeEntrega;
import util.Util;
import view.ErroView;
import view.FormaDeEntregaView;
import view.MenuPrincipalView;


public class FormaDeEntregaController extends MenuBase {
    public FormaDeEntregaController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
    }

    @Override
    public void mostraMenu() {
        FormaDeEntregaView.mostraMenu(ecommerce);
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        if(opcao < 1){
            if(opcao == 0){
                menuController.setMenuAtual(menuController.getMenus().get(0));
                return;
            } 
            MenuPrincipalView.opcaoInvalida();
            System.out.println("Opção inválida.");

        }
        selecionaFormaDePagamento(opcao);
    }

    public void selecionaFormaDePagamento(int opcao){
         try {
            FormaDeEntrega formaDeEntrega = ecommerce.getFormasDeEntrega().get(opcao - 1);
            ecommerce.getUsuarioLogado().getCarrinho().setFormaDeEntrega(formaDeEntrega);
            menuController.setMenuAtual(menuController.getMenus().get(7));
            Util.salvarLogFormaDeEntrega(formaDeEntrega.getNome(), formaDeEntrega.getValor());
            
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao selecionar a forma de entrega: " + e.getMessage());
        }
    }
}
