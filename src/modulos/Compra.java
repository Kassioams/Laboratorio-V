package modulos;

import java.util.Objects;

/**
 * Classe destinada a alocação as informações da compra.
 *
 */
public class Compra implements Comparable<Compra> {

    /**
     * Texto que representa a data da compra.
     *
     */
    private String data;

    /**
     * Texto que representa a descrição do produto da compra.
     *
     */
    private String descricao;

    /**
     * Texto que representa o nome do produto da compra.
     *
     */
    private String nome;

    /**
     * Valor que representa o preço da compra
     *
     */
    private double preco;

    /**
     * Constrói a compra do cliente.
     *
     * @param data a data da compra
     * @param nome o nome do produto
     * @param descricao a descricao do produto
     * @param preco o preco do produto
     */
    public Compra(String data, String nome, String descricao, double preco) {
        this.data = data;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * Método que retorna o valor do atributo nome.
     *
     * @return o valor do atributo.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o valor do atributo data.
     *
     * @return o valor do atributo.
     */
    public String getData() {
        return data;
    }

    /**
     * Realiza a alteração do valor do atributo data.
     *
     * @param data o nome da compra.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Método que retorna o valor do atributo preço.
     *
     * @return o valor do atributo.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Realiza a alteração do valor do atributo preco.
     *
     * @param preco o novo preço
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Representação textual da compra, como ela será exibida.
     *
     * @return o texto da criação da compra.
     */
    @Override
    public String toString() {
        return getNome() + " - " + getData().replace("/", "-");
    }

    /**
     * Realiza a comparação de dois objetos retorna se são iguais ou não.
     *
     * @return o valor boleano da comparação.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(descricao, compra.descricao) &&
                Objects.equals(nome, compra.nome);
    }

    /**
     * Retorna um valor que indica a posição do objeto na memória.
     *
     * @return o valor da posição da descrição e do nome
     */
    @Override
    public int hashCode() {
        return Objects.hash(descricao, nome);
    }

    /**
     * Método que faz a ordenação dos objetos.
     *
     * @param compra a compra
     * @return as compras ordenadas
     */
    @Override
    public int compareTo(Compra compra) {
        return getNome().compareTo(compra.getNome());
    }

    /**
     * Método que ordena a lista das compras seguindo o critério definico.
     *
     * @param criterio o criterio de ordenação
     * @param fornecedor o fornecedor
     * @param cliente o nome do cliente
     * @return
     */
    public String listarCompras(String criterio, String fornecedor, String cliente) {
        if (criterio.equals("Cliente")) {
            String lista = cliente + ", " + fornecedor + ", "  + descricao + ", "  + data;
            return lista;

        } else if (criterio.equals("Fornecedor")) {
            String lista = fornecedor + ", " + cliente + ", " + descricao + ", " + data;
            return lista;
        } else {
            String lista = data + ", " + cliente + ", " +  fornecedor  + ", " +  descricao;
            return lista;
        }
    }
}
