package testes;

import controladores.CRUDFornecedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CRUDFornecedorTest {

    private CRUDFornecedor controladorFornecedor;

    @BeforeEach
    void setUp(){
        this.controladorFornecedor = new CRUDFornecedor();
    }

    @Test
    void cadastraFornecedorNomeVazio(){
        assertThrows(IllegalArgumentException.class, () -> this.controladorFornecedor.adicionaFornecedor("", "davi_miguel@gmail.com", "35978462"));
    }

    @Test
    void cadastraFornecedorNomeNulo(){
        assertThrows(NullPointerException.class, () -> this.controladorFornecedor.adicionaFornecedor(null, "arthur_lopez@hotmail.com", "412654127"));
    }

    @Test
    void cadastraFornecedorEmailVazio(){
        assertThrows(IllegalArgumentException.class, () -> this.controladorFornecedor.adicionaFornecedor("Davi", "", "35978462"));
    }

    @Test
    void cadastraFornecedorEmailNulo(){
        assertThrows(NullPointerException.class, () -> this.controladorFornecedor.adicionaFornecedor("Arthur", null, "412654127"));
    }

    @Test
    void cadastraFornecedorTelefoneVazio(){
        assertThrows(IllegalArgumentException.class, () -> this.controladorFornecedor.adicionaFornecedor("Joao", "joaozinho@yahoo.com", ""));
    }

    @Test
    void cadastraFornecedorTelefoneNulo(){
        assertThrows(NullPointerException.class, () -> this.controladorFornecedor.adicionaFornecedor("Andre", "andreguedes_@outlook.com", null));
    }

    @Test
    void exibeFornecedorInvalido(){
        assertThrows(IllegalArgumentException.class, () -> this.controladorFornecedor.exibeFornecedor("Wesley"));
    }

    @Test
    void editarNomeFornecedor(){
        this.controladorFornecedor.adicionaFornecedor("Adriele", "amanda_gomes@yahoo.com", "17413256980");
        assertThrows(IllegalArgumentException.class, () -> this.controladorFornecedor.editaFornecedor("Amanda", "nome", "Amanda"));
    }
    @Test
    void editarEmailFornecedor(){
        this.controladorFornecedor.adicionaFornecedor("Gabriel", "gabriel_9@gmail.com","741852963");
        this.controladorFornecedor.editaFornecedor("Gabriel", "email", "biel_9@gmail.com");
    }

    @Test
    void editarTelefoneFornecedor(){
        this.controladorFornecedor.adicionaFornecedor("Cesar", "cesariano_13@gmail.com","695937281");
        this.controladorFornecedor.editaFornecedor("Cesar", "telefone", "959381278");
    }

    @Test
    void editaFornecedorInexistente(){
        this.controladorFornecedor.adicionaFornecedor("Karol", "karolzinha@hotmail.com","741852963");
        assertThrows(IllegalArgumentException.class, () -> this.controladorFornecedor.editaFornecedor("Marilia", "email", "cristina_marilia@hotmail.com"));
    }

    @Test
    void editaFornecedor123(){}
}