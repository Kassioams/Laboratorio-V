package modulos;

import util.Validador;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Classe destinada a alocação as informação dos produtos.
 */
public class Produto implements Comparable<Produto> {


    /**
     * Verificador das entradas de tratamento.
     */
    private Validador validador;

    /**
     * Texto que representa o nome do produto.
     */
    private String nome;

    /**
     * Texto que representa a descrição do produto.
     */
    private String descricao;

    /**
     * Texto que representa o preço do produto.
     */

    protected double preco;
    /**
     * Contrutor do produto do fornecedor.
     *  @param nome      o nome do produto
     * @param descricao a descrição do produto
     * @param preco     o preço do produto
     */
    public Produto(String nome, String descricao, double preco) {
        this.validador = new Validador();
        this.validador.valida(nome, "Nome do Produto ");
        this.validador.valida(descricao, "Descrição do Produto ");
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * Retorna o valor do atributo nome.
     *
     * @return o valor do atributo.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Representação textual do produto, como ele será exibido.
     *
     * @return o texto da criação do produto.
     */
    public String toString() {
        return this.nome + " - " + this.descricao + " - " + "R$" + String.format("%.2f", this.getPreco());
    }

    /**
     * Realiza a alteração do valor do atributo preco.
     *
     * @param preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Método que retorna o valor do atributo preço.
     *
     * @return o valor do atributo.
     */
    public double getPreco() {
        return this.preco;
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
        Produto produtos = (Produto) o;
        return nome.equals(produtos.nome) &&
                descricao.equals(produtos.descricao);
    }

    /**
     * Retorna um valor que indica a posição do objeto na memória.
     *
     * @return o valor da posição do nome e da descricao
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    /**
     * Método que faz a ordenação dos objetos.
     *
     * @param produto o produto
     * @return os produtos ordenados
     */
    @Override
    public int compareTo(Produto produto) {
        return nome.compareTo(produto.getNome());
    }
}
