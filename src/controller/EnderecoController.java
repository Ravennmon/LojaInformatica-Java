package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Endereco;
import model.Usuario;
import views.EnderecoView;

public class EnderecoController extends MenuBase {
    public EnderecoController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        EnderecoView.mostraMenu();
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case 1:
                break;
            case 2:
                cadastrarEndereco();
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void cadastrarEndereco() {
        Endereco endereco = EnderecoView.cadastrarEndereco();

        Usuario usuario = ecommerceController.getUsuarioLogado();
        usuario.addEndereco(endereco);
        usuario.getCarrinho().setEnderecoEntrega(endereco);

        menuController.setMenuAtual(menuController.getMenus().get(6));
    }


    
}
