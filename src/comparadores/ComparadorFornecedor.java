package comparadores;

import modulos.Fornecedor;

import java.util.Comparator;

public class ComparadorFornecedor implements Comparator<Fornecedor> {

    @Override
    public int compare(Fornecedor f1, Fornecedor f2) {
        return f1.getNome().compareTo(f2.getNome());
    }
}
