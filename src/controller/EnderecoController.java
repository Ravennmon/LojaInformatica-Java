package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Endereco;
import model.Usuario;
import util.Util;
import view.EnderecoView;
import view.MenuPrincipalView;

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
                cadastrarEndereco();
                break;
            case 2:
                visualizarEnderecos();
                break;
            case 3:
                editarEndereco();
                break;
            case 4:
                excluirEndereco();
                break;
            case 0:
                menuController.setMenuAtual(menuController.getMenus().get(0));
                break;
            default:
                MenuPrincipalView.opcaoInvalida();
        }
    }

    public void cadastrarEndereco() {
        try {
            Endereco endereco = EnderecoView.cadastrarEndereco();
            Usuario usuario = ecommerceController.getUsuarioLogado();
            usuario.addEndereco(endereco);
            usuario.getCarrinho().setEnderecoEntrega(endereco);
            menuController.setMenuAtual(menuController.getMenus().get(6));
            Util.salvarLogEndereco(endereco);

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o endereço: " + e.getMessage());
        }
    }

    public void visualizarEnderecos() {
        Usuario usuario = ecommerceController.getUsuarioLogado();
        EnderecoView.visualizarEnderecos(usuario.getEnderecos());
    }

    public void editarEndereco() {
        try {
            visualizarEnderecos();
            int id = Integer.parseInt(Util.nextLine("Informe o id do endereço que deseja editar:"));
            Usuario usuario = ecommerceController.getUsuarioLogado();
            Endereco endereco = usuario.getEnderecos().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
            Endereco enderecoAlterado = EnderecoView.cadastrarEndereco();
            endereco.setCep(enderecoAlterado.getCep());
            endereco.setBairro(enderecoAlterado.getBairro());   
            endereco.setCidade(enderecoAlterado.getCidade());
            endereco.setComplemento(enderecoAlterado.getComplemento());
            endereco.setEstado(enderecoAlterado.getEstado());
            endereco.setRua(enderecoAlterado.getRua());
            endereco.setNumero(enderecoAlterado.getNumero());
            Util.salvarLogEnderecoEditado(endereco);
            
        } catch (Exception e) {
            System.out.println("Erro ao editar o endereço: " + e.getMessage());
        }
    }
    
    public void excluirEndereco() {
        try {
            visualizarEnderecos();
            int id = Integer.parseInt(Util.nextLine("Informe o id do endereço que deseja excluir:"));
            Usuario usuario = ecommerceController.getUsuarioLogado();
            Endereco endereco = usuario.getEnderecos().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
            usuario.getEnderecos().remove(endereco);
            Util.salvarLogEnderecoExcluido(endereco);

        } catch (Exception e) {
            System.out.println("Erro ao excluir o endereço: " + e.getMessage());
        }
    }
}
