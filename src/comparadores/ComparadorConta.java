package comparadores;

import modulos.Conta;


import java.util.Comparator;

public class ComparadorConta implements Comparator<Conta> {

    @Override
    public int compare(Conta conta, Conta conta1) {
        return conta.getFornecedor().compareTo(conta1.getFornecedor());
    }
}

