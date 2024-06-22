package controller;

import controller.menu.MenuBase;
import controller.menu.MenuController;
import model.Ecommerce;
import model.Endereco;
import model.Usuario;
import util.Util;
import view.EnderecoView;
import view.ErroView;
import view.MenuPrincipalView;

public class EnderecoController extends MenuBase {
    public EnderecoController(MenuController menuController, Ecommerce ecommerce) {
        super(menuController, ecommerce);
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

            Usuario usuario = ecommerce.getUsuarioLogado();
            usuario.addEndereco(endereco);
            usuario.getCarrinho().setEnderecoEntrega(endereco);

            menuController.setMenuAtual(menuController.getMenus().get(6));
            Util.salvarLogEndereco(endereco);

        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao cadastrar o endereço: " + e.getMessage());
        }
    }

    public void visualizarEnderecos() {
        Usuario usuario = ecommerce.getUsuarioLogado();
        EnderecoView.visualizarEnderecos(usuario.getEnderecos());
    }

    public void editarEndereco() {
        try {
            visualizarEnderecos();
            int id = EnderecoView.informarIdEndereco();
    
            Usuario usuario = ecommerce.getUsuarioLogado();
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
            ErroView.mostrarErro("Erro ao editar o endereço: " + e.getMessage());
        }
    }
    
    public void excluirEndereco() {
        try {
            visualizarEnderecos();
            int id = Integer.parseInt(Util.nextLine("Informe o id do endereço que deseja excluir:"));
    
            Usuario usuario = ecommerce.getUsuarioLogado();
            Endereco endereco = usuario.getEnderecos().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
            usuario.getEnderecos().remove(endereco);
            Util.salvarLogEnderecoExcluido(endereco);
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao excluir o endereço: " + e.getMessage());
        }
    }
}
