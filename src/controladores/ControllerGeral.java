package controladores;

import modulos.Cliente;
import modulos.Fornecedor;
import util.Validador;

import java.util.List;

/**
 * Controloador responsavel por gerir o sistema pro completo.
 *
 */
public class ControllerGeral {

    private Validador validador;

    /**
     * Instância do controlador do fornecedor
     *
     */
    private CRUDFornecedor controllerFornecedor;

    /**
     * Instãncia do controlador do cliente.
     *
     */
    private CRUDClientes controllerCliente;

    /**
     * Inicializa os controladores instâciados.
     *
     */

    public ControllerGeral(){
        this.controllerCliente = new CRUDClientes();
        this.controllerFornecedor = new CRUDFornecedor();
        this.validador = new Validador();
    }

    /**
     * Método que passa ao controlador do cliente os parâmetros a serem cadastrados.
     *
     * @param cpf o cpf do cliente
     * @param nome o nome do cliente
     * @param email o email do cliente
     * @param localizacao a localização do cliente
     * @return
     */

    public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
        return this.controllerCliente.adicionaCliente(cpf, nome, email, localizacao);
    }

    /**
     * Método que passa ao controlador do cliente os parâmetros a serem editados.
     *
     * @param cpf o cpf do cliente
     * @param atributo o atributo a ser modificado
     * @param novoValor o novo valor para o atributo
     */
    public void editaCliente(String cpf, String atributo, String novoValor){
        this.controllerCliente.editaCliente(cpf, atributo, novoValor);
    }

    /**
     * Método que passa ao controlador do cliente o parâmetro para ser removido.
     *
     * @param cpf o cpf do cliente a ser removido
     */
    public void removeCliente(String cpf){
        this.controllerCliente.removeCliente(cpf);
    }
    /** Método que passa ao controlador do cliente o parâmetro para ser exibido.
     *
     * @param cpf o cpf do cliente a ser exibido
     */
    public Cliente exibeCliente(String cpf){
        return this.controllerCliente.exibeCliente(cpf);
    }

    public String exibeClientes(){
        return this.controllerCliente.exibeClientes();
    }

    /** Método que passa ao controlador do fornecedor os parâmetros do fornecedor a ser adicionado.
     *
     * @param nome o nome do fornecedor
     * @param telefone o telefone do fornecedor
     * @param email o email do fornecedor
     */
    public String adicionaFornecedor(String nome, String telefone, String email){
      return this.controllerFornecedor.adicionaFornecedor(nome, telefone, email);
    }

    /**
     * Método que passa ao controlador do fornecedor os parâmetros do fornecedor a ser editado.
     *
     * @param nome o nome do fornecedor
     * @param atributo o atributo a se editar
     * @param novoValor o novo valor do atributo
     */
    public void editaFornecedor(String nome, String atributo, String novoValor) {
        this.controllerFornecedor.editaFornecedor(nome, atributo, novoValor);
    }

    /**
     * Método que passa ao controlador do fornecedor o parâmetro do fornecedor a ser removido.
     *
     * @param nome o nome do fornecedor
     */
    public void removeFornecedor(String nome){
        this.controllerFornecedor.removeFornecedor(nome);
    }

    /**
     * Método que passa ao controlador do fornecedor o parâmetro do fornecedor a ser exibido.
     *
     * @param nome o nome do fornecedor
     */
    public Fornecedor exibeFornecedor(String nome){
        return this.controllerFornecedor.exibeFornecedor(nome);
    }

    public String exibeFornecedores(){
        return this.controllerFornecedor.exibeFornecedores();
    }

    /**
     * Método que passa ao controlador do fornecedo os parâmetros do produto a ser adicionado ao fornecedor.
     *
     * @param nomeFornecedor o nome do fornecedor para se cadastrar os produtos
     * @param nome o nome do produtp a ser cadastrado
     * @param descricao a descrição do produto
     * @param preco o preço do produto
     */
    public void adicionaProduto(String nomeFornecedor, String nome, String descricao, double preco) {
        this.controllerFornecedor.adicionaProduto(nomeFornecedor, nome, descricao, preco);
    }

    /**
     * Método que passa ao controlador do fornecedor os parâmetros para a exibição.
     *
     * @param nomeFornecedor o nome do fornecedor para se exibir os produtos
     */
    public String exibeProduto(String nome, String descricao, String nomeFornecedor){
      return this.controllerFornecedor.exibeProduto(nome, descricao, nomeFornecedor);
    }

    /**
     * Método que passa ao controlador do fornecedor o nome do fornecedor para a exibição dos produtos.
     *
     * @param fornecedor o fornecedor pedido
     * @return a lista com os produtos do fornecedor
     */
    public String exibeProdutosFornecedor(String fornecedor){
        return this.controllerFornecedor.exibeProdutosFornecedor(fornecedor);
    }

    /**
     * Método que pede ao controlador do fornecedor todos os produtos de todos os fornecedores.
     *
     * @return a lista com todos os produtos
     */
    public String exibeProdutos(){
        return this.controllerFornecedor.exibeProdutos();
    }

    /**
     * Método que passa ao controlador do fornecedor as parãmetros para se fazer a edição do produto.
     *
     * @param nome o nome do produto
     * @param descricao a descricao do produto
     * @param fornecedor o nome do fornecedor
     * @param novoPreco o preço a ser mudado
     */
    public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco){
        this.controllerFornecedor.editaProduto(nome, descricao, fornecedor, novoPreco);
    }

    public void removeProduto(String nome, String descricao, String fornecedor){
        this.controllerFornecedor.removeProduto(nome, descricao, fornecedor);
    }

    /**
     * Método que passa ao controlador de cliente as parãmetros para se fazer a adição de uma compra.
     *
     * @param cpf o cpf do cliente
     * @param fornecedor o nome do fornecedor
     * @param data a data da compra
     * @param nome o nome do produto
     * @param descricao a descrição do produto
     */
    public String  adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao) {
        this.validador.valida(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
        this.validador.valida(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
        this.validador.valida(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        this.validador.valida(nome, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        this.validador.valida(descricao, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
        this.validador.validaData(data, "Erro ao cadastrar compra: data invalida.");
        this.validador.validaCpf(cpf, "Erro ao cadastrar compra: cpf invalido.");
        if (!this.controllerFornecedor.existeFornecedor(fornecedor)) {
            throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
        }
        if (!this.controllerFornecedor.existeProduto(fornecedor, nome, descricao)) {
            throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
        }
        if (this.controllerCliente.naoExisteCliente(cpf)) {
            throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
        }
            double preco = this.controllerFornecedor.getPreco(fornecedor, nome, descricao);
            return this.controllerCliente.adicionaCompra(cpf, fornecedor, data, nome, descricao, preco);
    }

    /**
     * Método que passa ao controlador de cliente os parâmetros para ser feito a debito da conta.
     *
     * @param cpf o cpf do cliente
     * @param fornecedor o nome do fornecedor
     * @return o debito da conta
     */
    public String getDebito(String cpf, String fornecedor) {
        this.validador.valida(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
        this.validador.validaCpf(cpf, "Erro ao recuperar debito: cpf invalido.");
        this.validador.valida(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");

        if (this.controllerCliente.naoExisteCliente(cpf)) {
            throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
        }
        if (!this.controllerFornecedor.existeFornecedor(fornecedor)) {
            throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
        }
        return this.controllerCliente.getDebito(cpf, fornecedor);
    }

    /**
     * Método que passa ao contralador de cliente os parâmetros para se exibir as compras das contas.
     *
     * @param cpf o cpf do cliente
     * @param fornecedor o nome do fornecedor
     * @return os produtos comprados
     */
    public String exibeContas(String cpf, String fornecedor) {
        this.validador.valida(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
        this.validador.valida(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
        this.validador.validaCpf(cpf, "Erro ao exibir conta do cliente: cpf invalido.");
        if (this.controllerCliente.naoExisteCliente(cpf)) {
            throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
        }
        if (this.controllerFornecedor.existeFornecedor(fornecedor)) {

            return this.controllerCliente.exibeContas(cpf, fornecedor);
        }else {
            throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
        }
    }

    public String adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
        return this.controllerFornecedor.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
    }

    public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
        this.controllerFornecedor.editaCombo(nome, descricao, fornecedor, novoFator);
    }

    public String exibeContasClientes(String cpf) {
        return this.controllerCliente.exibeContasClientes(cpf);
    }

    public void realizaPagamento(String cpf, String fornecedor) {
        this.validador.valida(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
        this.validador.validaCpf(cpf, "Erro no pagamento de conta: cpf invalido.");
        this.validador.valida(fornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
        if (this.controllerFornecedor.existeFornecedor(fornecedor)) {
            this.controllerCliente.realizaPagamento(cpf, fornecedor);
        }else{
            throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao existe.");
        }
    }

    public void ordenaPor(String criterio) {
            this.controllerCliente.ordenaPor(criterio);
    }

    public String listarCompras() {
        return this.controllerCliente.listarCompras();
    }
}
