package modulos;

import comparadores.ComparadorProduto;
import util.Validador;

import java.util.*;

/**
 * Classe destinada a alocação as informações dos clientes.
 *
 */
public class Fornecedor implements Comparable<Fornecedor> {

    /**
     * Verificador das entradas de tratamento.
     */
    private Validador validador;

    /**
     * Texto que representa o nome do fornecedor.
     */
    private String nome;

    /**
     * Texto que representa o telefone do fornecedor.
     */
    private String telefone;

    /**
     * Texto que representa o email do fornecedor.
     */
    private String email;

    /**
     * Mapa dos produtos a serem colocados.
     */
    private HashMap<String, Produto> mapaProdutos;

    /**
     * Mapa das contas a serem colocadas.
     */
    private HashMap<String, Conta> mapaContas;

    /**
     * Contrutor do fornecedor, cria o fornecedor com respectivo nome, telefone e email.
     *
     * @param nome     o nome do fornecedor
     * @param email    o email do fornecedor
     * @param telefone o telefone do fornecedor
     */
    public Fornecedor(String nome, String email, String telefone) {
        this.validador = new Validador();
        this.validador.valida(nome, "Nome ");
        this.validador.valida(telefone, "Telefone ");
        this.validador.valida(email, "Email ");
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.mapaProdutos = new HashMap<>();
        this.mapaContas = new HashMap<>();
    }

    /**
     * Método que cria e adiciona produtos no mapa.
     *
     * @param nome      o nome do produto
     * @param descricao a descrição do produto
     * @param preco     o preço do produto
     */
    public void adicionaProduto(String nome, String descricao, double preco) {
        String key = nome + " - " + descricao;
        if (!mapaProdutos.containsKey(key)) {
            this.validador.valida(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
            this.validador.valida(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
            if (preco < 0.0) {
                throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
            }
            Produto produtos = new Produto(nome, descricao, preco);
            mapaProdutos.put(key, produtos);
        } else {
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        }
    }

    /**
     * Método que realiza a exibição do produto
     *
     * @param key o identificador do produto
     * @return a representação textual do produto
     */
    public String exibeProduto(String key) {
        if (mapaProdutos.containsKey(key)) {
            return mapaProdutos.get(key).toString();
        } else {
            throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        }
    }

    /**
     * Método que realiza a edição do produto
     *
     * @param key o identificador do produto
     * @param novoPreco a novo preco a ser mudado
     */
    public void editaProduto(String key, double novoPreco) {
        if (novoPreco < 0) {
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        }
        if (mapaProdutos.containsKey(key)) {
            mapaProdutos.get(key).setPreco(novoPreco);
        } else {
            throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
        }
    }

    /**
     * ]
     * Método que edita o preço do produto do fornecedpr.
     *
     * @param nome  o nome do produto
     * @param preco o preço a ser alterado
     */
    public void editaFornecedor(String nome, double preco) {
        mapaProdutos.get(nome).setPreco(preco);
    }

    /**
     * Método que exibe o produto do mapa.
     *
     * @param nome o nome do produto a ser mostrado
     */
    public void exibeFornecedor(String nome) {
        mapaProdutos.get(nome);
    }


    /**
     * Método que remove o produto do fornecedor.
     *
     * @param nome o nome do produto a ser removido
     */
    public void removeProduto(String nome, String descricao) {
        String key = nome + " - " + descricao;
        if (mapaProdutos.containsKey(key)) {
            this.mapaProdutos.remove(key);
        } else {
            throw new IllformedLocaleException("Erro na remocao de produto: produto nao existe.");
        }
    }

    /**
     * Método que lista todos os produtos de um fornecedor.
     *
     * @return todos os produtos do fornecedor
     */

    public String exibeProdutos() {
        String retorno = "";
        if (mapaProdutos.size() == 0) {
            retorno += this.nome + " -";
        } else {
            ArrayList<Produto> listaProdutos = new ArrayList<>(this.mapaProdutos.values());
            ComparadorProduto c = new ComparadorProduto();
            listaProdutos.sort(c);
            for (int i = 0; i < listaProdutos.size(); i++) {
                if (i < listaProdutos.size() - 1) {
                    retorno += this.nome + " - " + listaProdutos.get(i).toString() + " | ";
                } else {
                    retorno += this.nome + " - " + listaProdutos.get(i).toString();
                }
            }
        }
        return retorno;
    }

    /**
     * Método que realiza a exibição dos produtos de todos os fornecedores
     * @return
     */
    public String exibeProdutosFornecedor() {
        String retorno = "";
        ArrayList<Produto> listaProdutos = new ArrayList<>(this.mapaProdutos.values());
        ComparadorProduto c = new ComparadorProduto();
        listaProdutos.sort(c);
        Iterator<Produto> itr = listaProdutos.iterator();
        while (itr.hasNext()) {
            retorno += this.nome + " - " + itr.next().toString();
            if (itr.hasNext()) {
                retorno += " | ";
            }
        }
        return retorno;
    }

    /**
     * Representação textual do contato, como ele será exibido.
     *
     * @return o texto da criação do fornecedor.
     */
    public String toString() {
        return this.nome + " - " + this.email + " - " + this.telefone;
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
     * Realiza a alteração do valor do atributo telefone.
     *
     * @param telefone o telefone do contato.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Realiza a alteração do valor do atributo email.
     *
     * @param email o telefone do contato.
     */
    public void setEmail(String email) {
        this.email = email;
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
        Fornecedor that = (Fornecedor) o;
        return nome.equals(that.getNome());
    }

    /**
     * Retorna um valor que indica a posição do objeto na memória.
     *
     * @return o valor da posição do nome
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    /**
     * Método que faz a ordenação dos objetos.
     *
     * @param fornecedor o fornecedor
     * @return os fornecedores ordenados
     */
    @Override
    public int compareTo(Fornecedor fornecedor) {
        return getNome().compareTo(fornecedor.getNome());
    }

    /**
     * Método que retorna a existencia do produto.
     *
     * @param key o identificador do produto
     * @return a existencia do produto
     */
    public boolean existeProduto(String key) {
        return this.mapaProdutos.containsKey(key);
    }

    /**
     * Retorna o valor do atributo preco.
     *
     * @return o valor do atributo.
     */
    public double getPreco(String key) {
        return mapaProdutos.get(key).getPreco();
    }

    /**
     * Método que realiza a adição do combo.
     *
     * @param nome o nome do produto
     * @param descricao a descrição do produto
     * @param fator o fator do combo
     * @param produtos os produtos do combo
     * @return
     */
    public String adicionaCombo(String nome, String descricao, double fator, String produtos) {
        String key = nome + " - " + descricao;
        if (this.mapaProdutos.containsKey(key)) {
            throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
        }
        String[] produto = produtos.trim().split(", ");
        double preco = 0.0;
        for (String chave: produto){
            if(!this.mapaProdutos.containsKey(chave)){
                throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
            }
            if(this.mapaProdutos.get(chave).getClass() == Combo.class) {
                throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
            }
            preco += this.mapaProdutos.get(chave).getPreco();
        }
        this.mapaProdutos.put(key, new Combo(nome, descricao, preco, fator));
        return key;
    }

    /**
     * Método que edita o fator do combo.
     *
     * @param nome o nome do produto
     * @param descricao a descricao do produto
     * @param novoFator o novo fator do combo
     */
    public void editaCombo(String nome, String descricao, double novoFator) {
        this.validador.valida(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
        this.validador.valida(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
        this.validador.validaFator(novoFator, "Erro na edicao de combo: fator invalido.");
        String key =  nome + " - " + descricao;
        if (!this.mapaProdutos.containsKey(key)){
            throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
        }
        Combo combo = (Combo)this.mapaProdutos.get(key);
        combo.setFator(novoFator);
    }
}


