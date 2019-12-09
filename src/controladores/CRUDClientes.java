package controladores;

import comparadores.ComparadorData;
import modulos.Cliente;
import util.Validador;

import java.util.*;

/**
 * Classe que representa controlador dos clientes do sistema.
 */
public class CRUDClientes {

    private String criterio;

    /**
     * Verificador das entradas de tratamento.
     */
    private Validador validador;

    /**
     * Mapa dos clientes a serem colocados.
     */
    private HashMap<String, Cliente> mapaClientes;


    /**
     * Construtor do mapa e do verificador do validador.
     */
    public CRUDClientes() {
        this.validador = new Validador();
        this.mapaClientes = new HashMap<>();

    }

    /**
     * Método que repassa os parametros adiciona os clientes ao mapa.
     *
     * @param cpf         o cpf que identifica o cliente
     * @param nome        o nome do cliente
     * @param email       o email do cliente
     * @param localizacao a localização do cliente
     * @return
     */
    public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
        this.validador.valida(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        this.validador.valida(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        this.validador.valida(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        this.validador.valida(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        this.validador.validaCpf(cpf, "Erro no cadastro do cliente: cpf invalido.");
        String retorno = "";
        if (!this.mapaClientes.containsKey(cpf)) {
            Cliente cliente = new Cliente(cpf, nome, email, localizacao);
            mapaClientes.put(cpf, cliente);
            retorno = cpf;
        } else {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
        }
        return retorno;
    }

    /**
     * Método que repassa os parâmetros para a edição do cliente.
     *
     * @param cpf       o cpf que identifica o cliente
     * @param atributo  o atributo a ser editado
     * @param novoValor o novo valor do atributo
     */
    public void editaCliente(String cpf, String atributo, String novoValor) {
        this.validador.valida(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
        this.validador.valida(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        this.validador.valida(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        if (mapaClientes.containsKey(cpf)) {
            if ("cpf".equals((atributo))) {
                throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
            } else if ("nome".equals(atributo)) {
                this.mapaClientes.get(cpf).setNome(novoValor);
            } else if ("email".equals(atributo)) {
                this.mapaClientes.get(cpf).setEmail(novoValor);
            } else if ("localizacao".equals(atributo)) {
                this.mapaClientes.get(cpf).setLocalizacao(novoValor);
            } else {
                throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
            }
        } else {
            throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
        }
    }

    /**
     * Método que repassa os parãmetros para a remoção do cliente.
     *
     * @param cpf o cpf que identifica o cliente
     */
    public void removeCliente(String cpf) {
        this.validador.valida(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
        if (mapaClientes.containsKey(cpf)) {
            this.mapaClientes.remove(cpf);
        } else {
            throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
        }
    }

    /**
     * Método que repassa os parâmetros para a exibição do cliente.
     *
     * @param cpf o cpf que identifica o cliente
     * @return a exibição do cliente
     */
    public Cliente exibeCliente(String cpf) {
        this.validador.valida(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
        if (mapaClientes.containsKey(cpf)) {
            return this.mapaClientes.get(cpf);
        } else {
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        }
    }

    /**
     * Método que repassa os parâmetros para a exibição de todos os clientes.
     *
     * @return a lista dos clientes
     */
    public String exibeClientes() {
        String retorno = "";
        ArrayList<Cliente> listaClientes = new ArrayList<>(this.mapaClientes.values());
        Collections.sort(listaClientes);
        Iterator<Cliente> itr = listaClientes.iterator();
        while (itr.hasNext()) {
            retorno += itr.next().toString();
            if (itr.hasNext()) {
                retorno += " | ";
            }
        }
        return retorno;
    }

    /**
     * Método que repassa os parâmetros para a verficação da existência do cliente.
     *
     * @param cpf o cpf do cliente
     * @return a existencia do cliente
     */
    public boolean naoExisteCliente(String cpf) {
        return !mapaClientes.containsKey(cpf);
    }

    /**
     * Método que repassa os parâmetros para a adição da compra.
     *
     * @param cpf o cpf do cliente
     * @param fornecedor o fornecedor
     * @param data a data da compra
     * @param nome o nome do produto
     * @param descricao a descrição do produto
     * @param preco o preço da compra
     * @return a adição da compra
     */
    public String adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao, double preco) {
       return this.mapaClientes.get(cpf).adicionaCompra(fornecedor, data, nome, descricao, preco);
    }

    /**
     * Método que repassa os parâmetros para o calculo do débito do cliente.
     *
     * @param cpf
     * @param fornecedor
     * @return
     */
    public String getDebito(String cpf, String fornecedor) {
        if (this.mapaClientes.containsKey(cpf)) {
           return mapaClientes.get(cpf).getDebito(fornecedor);
       } else {
           throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
       }
    }

    /**
     * Método que repassa os parâmetros para a exibição de todas as compras na conta do cliente.
     *
     * @param cpf o do cliente
     * @param fornecedor o nome do fornecedor
     * @return a lista das compras
     */
    public String exibeContas(String cpf, String fornecedor) {
        this.validador.valida(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
        this.validador.valida(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
        return this.mapaClientes.get(cpf).exibeContas(fornecedor);
    }

    /**
     * Método que repassa o parâmetro para a exibição de toda a conta do cliente.
     *
     * @param cpf o cpf do cliente
     * @return a conta da cliente
     */
    public String exibeContasClientes(String cpf) {
        this.validador.valida(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
        this.validador.validaCpf(cpf, "Erro ao exibir contas do cliente: cpf invalido.");
        if (mapaClientes.containsKey(cpf)) {
            return this.mapaClientes.get(cpf).exibeContasClientes();
        }else{
            throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
        }
    }

    /**
     * Método que repassa os parâmetros que para a realização do pagamento.
     *
     * @param cpf o cpf do cliente
     * @param fornecedor o fornecedor
     */
    public void realizaPagamento(String cpf, String fornecedor) {
        if (this.mapaClientes.containsKey(cpf)){
            this.mapaClientes.get(cpf).realizaPagamento(fornecedor);
        }else{
            throw new IllegalArgumentException("Erro no pagamento de conta: cliente nao existe.");
        }
    }

    /**
     * Método que repassa o parâmetro que define o critério.
     *
     * @param criterio o criterio desejado
     */
    public void ordenaPor(String criterio) {
        this.validador.valida(criterio, "Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
        this.criterio = criterio;
    }

    /**
     * Método que lista de todas as compras de todos os clientes.
     *
     * @return a lista das compras
     */
    public String listarCompras() {
        List<String> lista = new ArrayList<>();
        for (Cliente c : this.mapaClientes.values()) {
            lista.addAll(c.listarCompras(criterio));
        }
        if (criterio.equals("Data")){
            Collections.sort(lista, new ComparadorData());
        }
        Collections.sort(lista);

        String listar = "";
        for(String dados: lista){
             listar += dados + " | ";
        }
        return listar.substring(0, listar.length()-3 );
    }
}
