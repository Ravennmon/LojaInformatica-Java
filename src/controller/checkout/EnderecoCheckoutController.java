package controller.checkout;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import model.Endereco;
import model.Usuario;
import util.Util;
import util.enums.MenuType;
import view.EnderecoView;
import view.ErroView;
import view.MenuPrincipalView;
import view.checkout.EnderecoCheckoutView;

public class EnderecoCheckoutController extends MenuBase {
    private static final int OPCAO_CADASTRAR_ENDERECO = 1;
    private static final int OPCAO_SELECIONAR_ENDERECO = 2;
    private static final int OPCAO_MENU_PRINCIPAL = 0;

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
            case OPCAO_CADASTRAR_ENDERECO:
                cadastrarEndereco();
                break;
            case OPCAO_SELECIONAR_ENDERECO:
                selecionarEndereco();
                break;
            case OPCAO_MENU_PRINCIPAL:
                menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
                break;
        }
    }

    public void visualizarEnderecos() {
        try {
            Usuario usuario = ecommerce.getUsuarioLogado();
            EnderecoView.visualizarEnderecos(usuario.getEnderecos());
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao visualizar endereços: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public void cadastrarEndereco() {
        try {
            Endereco endereco = EnderecoView.cadastrarEndereco();
            Usuario usuario = ecommerce.getUsuarioLogado();

            usuario.addEndereco(endereco);
            usuario.getCarrinho().setEnderecoEntrega(endereco);
            Util.salvarLogEndereco(endereco);

            avancaCheckout();
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao cadastrar endereço: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public void selecionarEndereco() {
        try {
            visualizarEnderecos();
            int id = EnderecoCheckoutView.informarIdEndereco();

            Usuario usuario = ecommerce.getUsuarioLogado();
            Endereco endereco = usuario.getEnderecos().stream()
                                       .filter(e -> e.getId() == id)
                                       .findFirst()
                                       .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));

            usuario.getCarrinho().setEnderecoEntrega(endereco);
            Util.salvarLogEndereco(endereco);

            avancaCheckout();
        } catch (IllegalArgumentException e) {
            ErroView.mostrarErro("\nEndereço não encontrado: " + e.getMessage() + "\n");
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao selecionar endereço: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    private void avancaCheckout() {
        try {
            menuNavegacao(menuController, MenuType.FORMA_DE_ENTREGA_CONTROLLER);
        } catch (Exception e) {
            ErroView.mostrarErro("\nErro ao avançar no checkout: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }
}
