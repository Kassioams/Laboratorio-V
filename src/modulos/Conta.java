package modulos;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe destinada a alocação das contas dos clientes.
 */
public class Conta  implements Comparable<Conta>{


    private String fornecedor;

    /**
     * Array que contém as compras do clientes.
     */
    private ArrayList<Compra> compras;

    /**
     * Construtor que cria o ArrayList.
     */
    public Conta(String fornecedor) {
        this.compras = new ArrayList<>();
        this.fornecedor = fornecedor;
    }

    /**
     * Método que adiciona a compra do cliente.
     *  @param data      a data da compra
     * @param nome      o nome do produto
     * @param descricao a descricao do produto
     * @param preco     o preço do produto
     */
    public void adicionaCompra(String data, String nome, String descricao, double preco) {
        Compra compra = new Compra(data, nome, descricao, preco);
        this.compras.add(compra);
    }

    /**
     * Método que retorna o valor do atributo debito.
     *
     * @return o valor do atributo.
     */
    public String getDebito() {
        double soma = 0;
        for (Compra compra : compras) {
            soma += compra.getPreco();
        }
        String resultado = String.format("%.2f", soma);
        return resultado.replace(",", ".");
    }

    /**
     * Método que cria a lista das contas.
     *
     * @return a lista das contas.
     */
    public String exibeContas() {
        String retorno = "";
        for (int i = 0; i < this.compras.size(); i++) {
            retorno += compras.get(i).toString() + " | ";
        }
        return retorno.substring(0, retorno.length() - 3);
    }

    /**
     *
     * @return
     */
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * Representação textual das compras, como ela será exibida.
     *
     * @return o texto da criação da compra.
     */
    @Override
    public String toString() {
        String retorno = "";
        for (Compra compras : compras){
            retorno += compras.toString() + " | ";
        }
        return retorno;
    }

    /**
     * Método que faz a ordenação dos objetos.
     *
     * @param conta a conta
     * @return as contas ordenadas
     */
    @Override
    public int compareTo(Conta conta) {
        return this.fornecedor.compareTo(conta.getFornecedor());
    }

    /**
     * Método que lista das as compras da conta.
     *
     * @param criterio o criterio definido
     * @param cliente o nome do cliente
     * @return a lista das compras
     */
    public List<String> listarCompras(String criterio, String cliente) {
        List<String> lista = new ArrayList<>();
        for (Compra c : compras){
            lista.add(c.listarCompras(criterio, fornecedor, cliente));
        }
        return lista;
    }
}




