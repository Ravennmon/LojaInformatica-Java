package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Endereco;
import model.Usuario;
import util.Util;
import view.EnderecoCheckoutView;
import view.EnderecoView;

public class EnderecoCheckoutController extends MenuBase {
    public EnderecoCheckoutController(MenuController menuController, EcommerceController ecommerceController) {
        super(menuController, ecommerceController);
    }

    @Override
    public void mostraMenu() {
        EnderecoCheckoutView.mostraMenu();
    }

    @Override
    public void opcao(int opcao, MenuController menuController) {
        switch (opcao) {
            case 1:
                cadastrarEndereco();
                break;
            case 2:
                selecionarEndereco();
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void visualizarEnderecos() {
        Usuario usuario = ecommerceController.getUsuarioLogado();
        EnderecoView.visualizarEnderecos(usuario.getEnderecos());
    }

    public void cadastrarEndereco() {
        Endereco endereco = EnderecoView.cadastrarEndereco();

        Usuario usuario = ecommerceController.getUsuarioLogado();
        usuario.addEndereco(endereco);
        usuario.getCarrinho().setEnderecoEntrega(endereco);

        avancaCheckout();
    }

    
    public void selecionarEndereco() {
        visualizarEnderecos();
        int id = Integer.parseInt(Util.nextLine("Informe o id do endereço que deseja selecionar:"));

        Usuario usuario = ecommerceController.getUsuarioLogado();
        Endereco endereco = usuario.getEnderecos().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        
        usuario.getCarrinho().setEnderecoEntrega(endereco);

        avancaCheckout();
    }

    private void avancaCheckout() {
        menuController.setMenuAtual(menuController.getMenus().get(6));
    }
}
