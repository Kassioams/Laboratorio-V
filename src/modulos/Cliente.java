package modulos;

import comparadores.ComparadorConta;
import util.Validador;

import java.util.*;

/**
 * Classe destinada a alocação as informação dos clientes.
 *
 */
public class Cliente implements Comparable<Cliente>{

    /**
     * Verificador das entradas de tratamento.
     *
     */
    private Validador validador;


    private HashMap<String, Conta> mapaContas;
    /**
     * Texto que representa o cpf do cliente.
     *
     */
    private String cpf;

    /**
     * Texto que representa o nome do cliente.
     *
     */
    private String nome;

    /**
     * Texto que representa o email do cliente.
     *
     */
    private String email;

    /**
     * Texto que representa o telefone do cliente.
     *
     */
    private String localizacao;


    /**
     * Contrutor do cliente, cria o cliente com respectivo cpf, nome, email e localização.
     *
     * @param cpf o cpf do cliente
     * @param nome o nome do cliente
     * @param email o email do cliente
     * @param localizacao a localizacao do cliente
     */
    public Cliente(String cpf, String nome, String email, String localizacao) {
        this.validador = new Validador();
        this.validador.valida(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
        this.validador.valida(nome, "Erro na edicao do cliente: nome nao pode ser vazio ou nulo.");
        this.validador.valida(email, "Erro na edicao do cliente: email nao pode ser vazio ou nulo.");
        this.validador.valida(localizacao, "Erro na edicao do cliente: localizacao nao pode ser vazio ou nulo.");
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
        this.mapaContas = new HashMap<>();
    }


    public String adicionaCompra(String fornecedor, String data, String nome, String descricao, double preco){
        if (mapaContas.containsKey(fornecedor)) {
            this.mapaContas.get(fornecedor).adicionaCompra(data, nome, descricao, preco);
        } else {
            Conta conta = new Conta(fornecedor);
            conta.adicionaCompra(data, nome, descricao, preco);
            mapaContas.put(fornecedor, conta);
        }
        return fornecedor;

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
     * Representação textual dos clientes.
     *
     * @return o cliente montado
     */
    public String toString() {
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }

    /**
     * Realiza a alteração do valor do atributo telefone.
     *
     * @param nome o nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Realiza a alteração do valor do atributo telefone.
     *
     * @param email o email do cliente.
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Realiza a alteração do valor do atributo telefone.
     *
     * @param localizacao a localização do cliente.
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
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
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    /**
     * Retorna um valor que indica a posição do objeto na memória.
     *
     * @return o valor da posição do cpf
     */
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    /**
     * Método que faz a ordenação dos objetos.
     *
     * @param cliente o cliente
     * @return os clientes ordenados
     */
    @Override
    public int compareTo(Cliente cliente) {
        return getNome().compareTo(cliente.getNome());
    }

    /**
     * Método que repassa os parâmetros para o cálculo do débito.
     *
     * @param fornecedor o fornecedor
     * @return o débito do cliente
     */
    public String getDebito(String fornecedor) {
       if(mapaContas.containsKey(fornecedor)) {
           return mapaContas.get(fornecedor).getDebito();
       } else {
           throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
       }
    }

    /**
     * Método que exibe as compras do cliente.
     *
     * @param fornecedor o nome do fornecedor{
            lista.add(c.listarCompras(criterio, fornecedor, cliente));
        }
    }
     * @return as compras da conta
     */
    public String exibeContas(String fornecedor) {
        if (this.mapaContas.containsKey(fornecedor)) {
          return "Cliente: " + this.nome + " | "  + fornecedor + " | " + this.mapaContas.get(fornecedor).exibeContas();
        }else{
            throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
        }
    }

    /**
     * Método que lista a conta do cliente
     *
     * @return a lista da conta
     */
     public String exibeContasClientes() {
        if (this.mapaContas.size() == 0){
            throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
        }
       String retorno = "Cliente: " + this.nome + " | ";
       List<Conta> listaContas = new ArrayList<>(this.mapaContas.values());
       listaContas.sort(new ComparadorConta());
       for (Conta conta: listaContas){
           retorno += conta.getFornecedor()  + " | " + conta.toString();
       }
       return retorno.substring(0,retorno.length()-3);
     }

    /**
     * Método que repassa os parâmetros para a realização do pagamento.
     *
     * @param fornecedor o fornecedor
     */
    public void realizaPagamento(String fornecedor) {
        if (mapaContas.containsKey(fornecedor)){
            this.mapaContas.remove(fornecedor);
        }else{
            throw new IllegalArgumentException("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
        }
    }

    /**
     * Método que repassa o parâmetro para a listagem das compras.
     *
     * @param criterio o criterio desejado
     * @return a lista das compras
     */
    public List<String> listarCompras(String criterio) {
        List<String> lista = new ArrayList<>();

        for (Conta c : this.mapaContas.values()) {
            lista.addAll(c.listarCompras(criterio,nome));
        }
        return lista;
    }
}
