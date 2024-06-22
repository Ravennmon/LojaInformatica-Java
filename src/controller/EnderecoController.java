package controller;

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

public class EnderecoController extends MenuBase {
    private static final int CADASTRAR_ENDERECO = 1;
    private static final int VISUALIZAR_ENDERECOS = 2;
    private static final int EDITAR_ENDERECO = 3;
    private static final int EXCLUIR_ENDERECO = 4;
    private static final int MENU_PRINCIPAL = 0;

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
            case CADASTRAR_ENDERECO:
                cadastrarEndereco();
                break;
            case VISUALIZAR_ENDERECOS:
                visualizarEnderecos();
                break;
            case EDITAR_ENDERECO:
                editarEndereco();
                break;
            case EXCLUIR_ENDERECO:
                excluirEndereco();
                break;
            case MENU_PRINCIPAL:
                menuNavegacao(menuController, MenuType.MENU_PRINCIPAL);
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
            menuNavegacao(menuController, MenuType.USUARIO_CONTROLLER);
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
            Endereco endereco = usuario.getEnderecos().stream()
                    .filter(e -> e.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));

            Endereco enderecoAlterado = EnderecoView.cadastrarEndereco();
            atualizarEndereco(endereco, enderecoAlterado);
            Util.salvarLogEnderecoEditado(endereco);
        } catch (IllegalArgumentException e) {
            ErroView.mostrarErro("Erro ao editar o endereço: " + e.getMessage());
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao editar o endereço: " + e.getMessage());
        }
    }

    public void excluirEndereco() {
        try {
            visualizarEnderecos();
            int id = Integer.parseInt(Util.nextLine("Informe o id do endereço que deseja excluir:"));
            Usuario usuario = ecommerce.getUsuarioLogado();
            Endereco endereco = usuario.getEnderecos().stream()
                    .filter(e -> e.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));

            usuario.getEnderecos().remove(endereco);
            Util.salvarLogEnderecoExcluido(endereco);
        } catch (IllegalArgumentException e) {
            ErroView.mostrarErro("Erro ao excluir o endereço: " + e.getMessage());
        } catch (Exception e) {
            ErroView.mostrarErro("Erro ao excluir o endereço: " + e.getMessage());
        }
    }

    private void atualizarEndereco(Endereco endereco, Endereco enderecoAlterado) {
        endereco.setCep(enderecoAlterado.getCep());
        endereco.setBairro(enderecoAlterado.getBairro());
        endereco.setCidade(enderecoAlterado.getCidade());
        endereco.setComplemento(enderecoAlterado.getComplemento());
        endereco.setEstado(enderecoAlterado.getEstado());
        endereco.setRua(enderecoAlterado.getRua());
        endereco.setNumero(enderecoAlterado.getNumero());
    }
}
