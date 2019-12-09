package testes;

import modulos.Compra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompraTest {
    private Compra compraTest;

    @Test
    void compraTest() {
        this.compraTest = new Compra("14/07/2018", "Coxao com batata", "Coxao de frango com batata frita", 4.00);
        assertEquals("Coxao com batata", this.compraTest.getNome());
        assertEquals("14/07/2018", this.compraTest.getData());
        assertEquals("Coxao com batata - 14-07-2018" , this.compraTest.toString());
        assertEquals(4.00, this.compraTest.getPreco());
    }
}