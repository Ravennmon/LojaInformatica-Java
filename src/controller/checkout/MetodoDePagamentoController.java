package controller.checkout;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import model.Usuario;
import model.pagamento.MetodoDePagamento;
import view.ErroView;
import util.Util;
import view.MenuPrincipalView;
import view.checkout.MetodoDePagamentoView;

public class MetodoDePagamentoController extends MenuBase {
    public MetodoDePagamentoController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
    }

    @Override
    public void mostraMenu() {
        try {
            MetodoDePagamentoView.mostraMenu(ecommerce);
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao mostrar menu de métodos de pagamento: " + e.getMessage() + "\n");
        }
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
        selecionaMetodoDePagamento(opcao);

    }

    public void selecionaMetodoDePagamento(int opcao){
        try {
            if(opcao > ecommerce.getMetodosDePagamento().size()){
                MenuPrincipalView.opcaoInvalida();
                return;
            }

            Usuario usuario =  ecommerce.getUsuarioLogado();

            MetodoDePagamento metodoDePagamento = ecommerce.getMetodosDePagamento().get(opcao - 1);
    
            usuario.getCarrinho().setMetodoDePagamento(metodoDePagamento);
    
            usuario.getCarrinho().setMetodoDePagamento(metodoDePagamento);
            if(metodoDePagamento.isCartao()){
                menuController.setMenuAtual(menuController.getMenus().get(11));
                return;
            }
            Util.salvarLogPagamento(metodoDePagamento.getDescricao());
            this.menuController.setMenuAtual(menuController.getMenus().get(10));
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao selecionar método de pagamento: " + e.getMessage() + "\n");
        }
        
    }
}
