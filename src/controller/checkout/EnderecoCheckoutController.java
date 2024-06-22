package controller.checkout;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import model.Endereco;
import model.Usuario;
import view.EnderecoView;
import view.ErroView;
import view.MenuPrincipalView;
import view.checkout.EnderecoCheckoutView;

public class EnderecoCheckoutController extends MenuBase {
    public EnderecoCheckoutController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
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
                MenuPrincipalView.opcaoInvalida();
        }
    }

    public void visualizarEnderecos() {
        try {
            Usuario usuario = ecommerce.getUsuarioLogado();
            EnderecoView.visualizarEnderecos(usuario.getEnderecos());
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao visualizar endereços: " + e.getMessage() + "\n");
        }

    }

    public void cadastrarEndereco() {

        try {
            Endereco endereco = EnderecoView.cadastrarEndereco();

            Usuario usuario = ecommerce.getUsuarioLogado();
            usuario.addEndereco(endereco);
            usuario.getCarrinho().setEnderecoEntrega(endereco);
    
            avancaCheckout();
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao cadastrar endereço: " + e.getMessage() + "\n");
        }
    }

    
    public void selecionarEndereco() {
        try {
            visualizarEnderecos();
            int id = EnderecoCheckoutView.informarIdEndereco();
    
            Usuario usuario = ecommerce.getUsuarioLogado();
            Endereco endereco = usuario.getEnderecos().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
            
            usuario.getCarrinho().setEnderecoEntrega(endereco);
    
            avancaCheckout();
    
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao selecionar endereço: " + e.getMessage() + "\n");
        }

    }

    private void avancaCheckout() {
        try {
            menuController.setMenuAtual(menuController.getMenus().get(8));
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao avançar no checkout: " + e.getMessage() + "\n");
        }
    }
}
