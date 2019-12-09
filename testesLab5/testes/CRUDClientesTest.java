package testes;

import controladores.CRUDClientes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CRUDClientesTest {

    private CRUDClientes controladorClientes;

    @BeforeEach
    void setUp() {
        this.controladorClientes = new CRUDClientes();
    }

    @Test
    void cadastraClienteCpfVazio() {
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.adicionaCliente("   ", "Japa", "clientemalcuo@gmail.com", "LCC3"));
    }

    @Test
    void cadastraClienteCpfNulo() {
        assertThrows(NullPointerException.class, () -> this.controladorClientes.adicionaCliente(null, "Andre", "andrezinho.12@yahoo.com", "LCC2"));
    }

    @Test
    void cadastrarClienteNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.adicionaCliente("74125369813", "  ", "matheus.12@yahoo.com", "LSD"));
    }

    @Test
    void cadastrarClienteNomeNulo() {
        assertThrows(NullPointerException.class, () -> this.controladorClientes.adicionaCliente("74125369813", null, "andrezinho.12@yahoo.com", "LCC2"));
    }

    @Test
    void cadastrarClienteEmailVazio() {
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.adicionaCliente("73063179428", "Arthur", "  ", "Analytics"));
    }

    @Test
    void cadastrarClienteEmailNulo() {
        assertThrows(NullPointerException.class, () -> this.controladorClientes.adicionaCliente("73063179428", "Arthur", null, "Analytics"));
    }

    @Test
    void cadastrarClienteLocalizacaoVazia() {
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.adicionaCliente("73063179428", "Arthur", "arthur.xda@outlook.com", "  "));
    }

    @Test
    void cadastrarClienteLocalizacaoNula() {
        assertThrows(NullPointerException.class, () -> this.controladorClientes.adicionaCliente("73063179428", "Arthur", "arthur.xda@outlook.com", null));
    }

    @Test
    void cadastrarClienteCpfInvalido() {
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.adicionaCliente("123455", "Gabriel Maracuja", "gsmtech@ccc.ufcg.edu.br", "Propex"));
    }

    @Test
    void cadastrarClienteExistente() {
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.adicionaCliente("00023827490", "Carlos Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc"));
    }

    @Test
    void exibirCliente(){
        this.controladorClientes.adicionaCliente("00023827490", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
        assertEquals("Victor Emanuel - Labarc - vitao@ccc.ufcg.edu.br", this.controladorClientes.exibeCliente("00023827490"));
    }

    @Test
    void exibirClienteNomeNulo() {
        assertThrows(NullPointerException.class, () -> this.controladorClientes.exibeCliente(null));
    }

    @Test
    void exibirClienteNomeVazio() {

        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.exibeCliente(""));
    }

    @Test
    void exibirClienteCpfInvalido() {
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.exibeCliente("12345678911"));
    }

    @Test
    void editarNomeCliente() {
        this.controladorClientes.adicionaCliente("45301797364", "rejane", "rejane@gmail.com", "LCC2");
        this.controladorClientes.editaCliente("45301797364", "nome", "Rejane");
    }

    @Test
    void editarEmailCliente() {
        this.controladorClientes.adicionaCliente("12541265483", "Antonio", "toinho@gmail.com", "LSD");
        this.controladorClientes.editaCliente("12541265483", "email", "antonio_3721@hotmail.com");
    }

    @Test
    void editarLocalizacaoCliente() {
        this.controladorClientes.adicionaCliente("35725896410", "Hugo", "hugo_civic@gmail.com", "SPLAB");
        this.controladorClientes.editaCliente("35725896410", "localizacao", "Monitoria");
    }

    @Test
    void editarClienteAtributoNomeVazio() {
        this.controladorClientes.adicionaCliente("18469841265", "Karla", "karla_jarlita@outlook.com", "Secretaria");
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.editaCliente("18469841265", "", "Diretoria"));
    }

    @Test
    void editarClienteAtributoNomeNull() {
        this.controladorClientes.adicionaCliente("54037964850", "Maria", "maria_10@yahoo.com", "Vtex");
        assertThrows(NullPointerException.class, () -> this.controladorClientes.editaCliente("58469841265", null, "Propex"));
    }

    @Test
    void editarClienteAtributoInvalido() {
        this.controladorClientes.adicionaCliente("10684753330", "Jessica", "jessica_gabriela@gmail.com", "SPG");
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.editaCliente("10684753330", "cpf", "SPLAB"));
    }

    @Test
    void editarClienteAtributoInexistente() {
        this.controladorClientes.adicionaCliente("60115573692", "Andressa", "andressa_karla@gmail.com", "Analytics");
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.editaCliente("60115573692", "sobrenome", "PetComputacao"));
    }

    @Test
    void editarClienteCpfInvalido() {
        this.controladorClientes.adicionaCliente("10684753330", "jessica", "jessica_gabriela@gmail.com", "SPG");
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.editaCliente("412356", "nome", "Jessica"));
    }

    @Test
    void removeCliente(){
        this.controladorClientes.adicionaCliente("33872288130", "Giovana", "giovanasin34@outlook.com", "LCC3");
        this.controladorClientes.removeCliente("33872288130");
    }
    @Test
    void removeClienteCpfVazio() {
        this.controladorClientes.adicionaCliente("07001163031", "Benjamin", "benjamin_gabriel@yahoo.com", "Propex");
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.removeCliente(""));
    }

    @Test
    void removeClienteCpfNulo() {
        this.controladorClientes.adicionaCliente("01698848056", "Benicio", "benicio_araujo@yahoo.com", "PetComputacao");
        assertThrows(NullPointerException.class, () -> this.controladorClientes.removeCliente(null));
    }

    @Test
    void removeClienteInexistente() {
        this.controladorClientes.adicionaCliente("21159160007", "Augusto", "augustocesar@gmail.com", "SPG");
        assertThrows(IllegalArgumentException.class, () -> this.controladorClientes.removeCliente("41539"));
    }

}