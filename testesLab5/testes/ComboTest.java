package testes;

import modulos.Combo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComboTest {

    private Combo comboTest;

    @Test
    public void testCombo() {
        this.comboTest = new Combo("X-burguer + suco", "X-burguer com suco de maracuja", 4.00, 0.20);
        assertEquals("X-burguer + suco", this.comboTest.getNome());
        assertEquals(3.20, this.comboTest.getPreco());
        this.comboTest.setFator(0.5);
        assertEquals(2.00, this.comboTest.getPreco());
    }
}