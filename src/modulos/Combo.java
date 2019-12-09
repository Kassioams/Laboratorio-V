package modulos;

/**
 * Classe destinada a alocação as informações do combo.
 * O combo herdam a classe produto.
 */
public class Combo extends Produto {

    /**
     * Valor que representa o fator do combo.
     *
     */
    private double fator;

    /**
     * Constrói o combo de produtos.
     *
     * @param nome o nome do produto
     * @param descricao a descricao do produto
     * @param preco o preco do produto
     * @param fator o fator para o preco
     */
    public Combo(String nome, String descricao, double preco, double fator){
        super(nome, descricao, preco);
        this.fator= 1 - fator;
    }

    /**
     * Realiza a alteração do valor do atributo fator.
     *
     * @param novoFator o novo fator do combo.
     */
    public void setFator(double novoFator) {
        this.fator = 1 - novoFator;
    }

    /**
     * Retorna o valor do atributo preco.
     *
     * @return o valor do atributo.
     */
    @Override
    public double getPreco() {
        return this.preco * this.fator;
    }
}
