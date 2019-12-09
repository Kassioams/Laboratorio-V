package controladores;

import modulos.Fornecedor;
import util.Validador;

import java.util.*;

/**
 * Classe que representa controlador dos fornecedores do sistema.
 */

public class CRUDFornecedor {

    /**
     * Mapa dos fornecedores a serem colocados.
     */
    private HashMap<String, Fornecedor> mapaFornecedor;

    /**
     * Verificador das entradas de tratamento.
     */
    private Validador validador;

    /**
     * Construtor do mapa e do validador.
     */
    public CRUDFornecedor() {
        this.mapaFornecedor = new HashMap<>();
        this.validador = new Validador();
    }

    /**
     * Método que repassa os parâmetros para a adição do fornecedor ao mapa.
     *
     * @param nome     o nome e identificador do fornecedor
     * @param email    o email do fornecedor
     * @param telefone o telefone do fornecedor
     */
    public String adicionaFornecedor(String nome, String email, String telefone) {
        this.validador.valida(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        this.validador.valida(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        this.validador.valida(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        if (!mapaFornecedor.containsKey(nome)) {
            Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
            mapaFornecedor.put(nome, fornecedor);
        } else {
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }
        return nome;
    }

    /**
     * Método que repassa os parâmetros para a edição do fornecedor
     *
     * @param nome      o nome do fornecedor a ser editado
     * @param atributo  o atributo as ser editado
     * @param novoValor o novo valor do atributo
     */
    public void editaFornecedor(String nome, String atributo, String novoValor) {
        this.validador.valida(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        this.validador.valida(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        this.validador.valida(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        if (mapaFornecedor.containsKey(nome)) {
            if ("nome".equals(atributo)) {
                throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
            } else if ("email".equals(atributo)) {
                this.validador.valida(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
                this.validador.valida(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
                this.mapaFornecedor.get(nome).setEmail(novoValor);
            } else if ("telefone".equals(atributo)) {
                this.validador.valida(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
                this.validador.valida(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
                this.mapaFornecedor.get(nome).setTelefone(novoValor);
            } else {
                throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
            }
        } else {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
        }
    }

    /**
     * Método que repassa os parâmetros para a remoção do fornecedor do mapa.
     *
     * @param nome o cpf que identifica o fornecedor
     */
    public void removeFornecedor(String nome) {
        this.validador.valida(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
        if (mapaFornecedor.containsKey(nome)) {
            mapaFornecedor.remove(nome);
        } else {
            throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
        }
    }

    /**
     * Método que repassa os parâmetros para  exibição dos fornecedores do mapa.
     *
     * @param nome o cpf que identifica o cliente
     * @return
     */
    public Fornecedor exibeFornecedor(String nome) {
        if (mapaFornecedor.containsKey(nome)) {
            return this.mapaFornecedor.get(nome);
        } else {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }
    }

    /**
     * Método que repassa os parâmetros para a exibição de todos os fornecedores.
     *
     * @return a lista com todos os fornecedores do sistema
     */
    public String exibeFornecedores() {
        String retorno = "";
        ArrayList<Fornecedor> listaFornecedores = new ArrayList<>(mapaFornecedor.values());
        Collections.sort(listaFornecedores);
        Iterator<Fornecedor> itr = listaFornecedores.iterator();
        while (itr.hasNext()) {
            retorno += itr.next().toString();
            if (itr.hasNext()) {
                retorno += " | ";
            }
        }
        return retorno;
    }

    /**
     * Método que repassa os parâmentros para a adicão de produtos ao fornecedor.
     *
     * @param nomeFornecedor o nome do fornecedor a ser adicionado
     * @param nome           o nome do produto
     * @param descricao      a descrição do produto
     * @param preco          o preço do produto
     */
    public void adicionaProduto(String nomeFornecedor, String nome, String descricao, double preco) {
        this.validador.valida(nomeFornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        if (mapaFornecedor.containsKey(nomeFornecedor)) {
            mapaFornecedor.get(nomeFornecedor).adicionaProduto(nome, descricao, preco);
        } else {
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        }
    }

    /**
     * Método que repassa os parâmetros para a exibição dos produtos de um fornecedor.
     *
     * @param nomeFornecedor o nome do fornecedor a ser exibido os produtos
     */
    public String exibeProduto(String nome, String descricao, String nomeFornecedor) {
        this.validador.valida(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        this.validador.valida(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        this.validador.valida(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        if (mapaFornecedor.containsKey(nomeFornecedor)) {
            String key = nome + " - " + descricao;
            return mapaFornecedor.get(nomeFornecedor).exibeProduto(key);
        } else {
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        }
    }

    /**
     * Método que repassa os parâmetros pela edição do preço do produto.
     *
     * @param nome o nome do produto
     * @param descricao a descrição do produto
     * @param fornecedor o nome do fornecedor
     * @param novoPreco o novo preço do produto
     */
    public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
        this.validador.valida(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        this.validador.valida(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        this.validador.valida(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        if (mapaFornecedor.containsKey(fornecedor)) {
            String key = nome + " - " + descricao;
            mapaFornecedor.get(fornecedor).editaProduto(key, novoPreco);
        } else {
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
        }
    }

    /**
     * Método que repassa os parâmetros pela remoção de um produto.
     *
     * @param nome o nome do produto
     * @param descricao a descrição do produto
     * @param fornecedor o nome do fornecedor
     */
    public void removeProduto(String nome, String descricao, String fornecedor) {
        this.validador.valida(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        this.validador.valida(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        this.validador.valida(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        if (mapaFornecedor.containsKey(fornecedor)) {
            this.mapaFornecedor.get(fornecedor).removeProduto(nome, descricao);
        } else {
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
        }
    }

    /**
     * Método que repassa os parâmetros para a exibição dos produtos de determinado fornecedor.
     *
     * @param fornecedor o fornecedor pedido
     * @return a lista com os produtos do fornecedor
     */
    public String exibeProdutosFornecedor(String fornecedor) {
        this.validador.valida(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        if (mapaFornecedor.containsKey(fornecedor)) {
            return this.mapaFornecedor.get(fornecedor).exibeProdutosFornecedor();
        } else {
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        }
    }

    /**
     * Método que repassa os parâmetros para exibição dos os produtos de todos os fornecedores.
     *
     * @return a lista de todos os produtos
     */
    public String exibeProdutos() {
        String retorno = "";
        ArrayList<Fornecedor> listaFornecedores = new ArrayList<>(mapaFornecedor.values());
        Collections.sort(listaFornecedores);
        Iterator<Fornecedor> itr = listaFornecedores.iterator();
        for (int i = 0; i < listaFornecedores.size(); i++) {
            if (i < listaFornecedores.size() - 1) {
                retorno += listaFornecedores.get(i).exibeProdutos() + " | ";
          } else {
                retorno += listaFornecedores.get(i).exibeProdutos();
            }
        }
        return retorno;
    }

    /**
     * Método que repassa os parâmetros que checam a existencia do fornecedor.
     *
     * @param fornecedor o fornecedor
     * @return a existencia do fornecedor
     */
    public boolean existeFornecedor(String fornecedor) {
        return this.mapaFornecedor.containsKey(fornecedor);
    }

    /**
     * Método que repassa os parâmetros que checam a existencia do produto.
     *
     * @param fornecedor o fornecedor
     * @param nome o nome do produto
     * @param descricao a descricao do produto
     * @return a existencia do fornecedor
     */
    public boolean existeProduto(String fornecedor, String nome, String descricao) {
        String key = nome + " - " + descricao;
        return this.mapaFornecedor.get(fornecedor).existeProduto(key);
    }

    /**
     * Método que repassa os parâmetro para o retorno do preco do produto.
     *
     * @param fornecedor o fornecedor
     * @param nome o nome do produto
     * @param descricao a descricao do produto
     * @return o preco do produto
     */

    public double getPreco(String fornecedor, String nome, String descricao) {
        String key = nome + " - " + descricao;
        return mapaFornecedor.get(fornecedor).getPreco(key);
    }

    /**
     * Método que repassa os parâmetros para a adição de um combo.
     *
     * @param fornecedor o fornecedor
     * @param nome o nome do produto
     * @param descricao a descricao do produto
     * @param fator o fator para a reducao do preco
     * @param produtos os produtos do combo
     * @return a adicao do combo
     */
    public String adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
        this.validador.valida(fornecedor,"Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
        this.validador.valida(nome, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
        this.validador.valida(descricao,"Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
        this.validador.valida(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
        this.validador.validaFator(fator, "Erro no cadastro de combo: fator invalido.");
        if (!existeFornecedor(fornecedor)) {
            throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
        }
        return this.mapaFornecedor.get(fornecedor).adicionaCombo(nome, descricao, fator, produtos);
    }
    /**
     * Método que repassa os parâmetros para a edição de um combo.
     *
     * @param fornecedor o fornecedor
     * @param nome o nome do produto
     * @param descricao a descricao do produto
     * @param novoFator o novo fator para a reducao do preco
     */
    public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
        this.validador.valida(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
        this.validador.valida(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
        this.validador.valida(fornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
        this.validador.validaFator(novoFator, "Erro na edicao de combo: fator invalido.");
        if (!existeFornecedor(fornecedor)){
            throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
        }
        this.mapaFornecedor.get(fornecedor).editaCombo(nome,descricao, novoFator);
    }

}

