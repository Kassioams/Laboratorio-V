package comparadores;

import modulos.Compra;

import java.util.Comparator;

public class ComparadorCompra implements Comparator<Compra>{

    @Override
    public int compare(Compra compra, Compra compra1) {
        return compra.getNome().compareTo(compra1.getNome());
    }
}
