package controladores;

import modulos.Cliente;
import modulos.Fornecedor;
import easyaccept.EasyAccept;

import java.util.List;

public class Facade {

    private ControllerGeral controllerGeral;

    private Fornecedor fornecedor;

    public static void main(String[] args) {
        args = new String[]{"controladores.Facade", "testesAceitacao/use_case_1.txt", "testesAceitacao/use_case_2.txt",
                            "testesAceitacao/use_case_3.txt", "testesAceitacao/use_case_4.txt", "testesAceitacao/use_case_6.txt",
                            "testesAceitacao/use_case_5.txt", "testesAceitacao/use_case_7.txt", "testesAceitacao/use_case_8.txt"};
        EasyAccept.main(args);
    }

    public Facade() {
        this.controllerGeral = new ControllerGeral();
    }

    public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
        return this.controllerGeral.adicionaCliente(cpf, nome, email, localizacao);
    }

    public void editaCliente(String cpf, String atributo, String novoValor) {
        this.controllerGeral.editaCliente(cpf, atributo, novoValor);
    }

    public void removeCliente(String cpf) {
        this.controllerGeral.removeCliente(cpf);
    }

    public Cliente exibeCliente(String cpf) {
        return this.controllerGeral.exibeCliente(cpf);
    }

    public String exibeClientes(){
        return this.controllerGeral.exibeClientes();
    }

    public String adicionaFornecedor(String nome, String telefone, String email) {
        return this.controllerGeral.adicionaFornecedor(nome, telefone, email);
    }

    public void editaFornecedor(String nome, String atributo, String novoValor) {
        this.controllerGeral.editaFornecedor(nome, atributo, novoValor);
    }

    public void removeFornecedor(String nome) {
        this.controllerGeral.removeFornecedor(nome);
    }

    public Fornecedor exibeFornecedor(String nome) {
        return this.controllerGeral.exibeFornecedor(nome);
    }

    public String exibeFornecedores(){
        return this.controllerGeral.exibeFornecedores();
    }

    public void adicionaProduto(String nomeFornecedor,String nome, String descricao, double preco) {
        this.controllerGeral.adicionaProduto(nomeFornecedor, nome, descricao, preco);
    }

    public String exibeProduto(String nome, String descricao, String nomeFornecedor){
       return this.controllerGeral.exibeProduto(nome, descricao, nomeFornecedor);
    }

    public String exibeProdutosFornecedor(String fornecedor){
        return this.controllerGeral.exibeProdutosFornecedor(fornecedor);
    }

    public String exibeProdutos(){
        return this.controllerGeral.exibeProdutos();
    }

    public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
        this.controllerGeral.editaProduto(nome, descricao, fornecedor, novoPreco);
    }
    public void removeProduto(String nome, String descricao, String fornecedor) {
        this.controllerGeral.removeProduto(nome, descricao, fornecedor);
    }

   public void adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao){
        this.controllerGeral.adicionaCompra(cpf, fornecedor, data, nome, descricao);
    }

    public String getDebito(String cpf, String fornecedor){
        return this.controllerGeral.getDebito(cpf, fornecedor);
    }

    public String exibeContas(String cpf, String fornecedor){
        return this.controllerGeral.exibeContas(cpf, fornecedor);
   }

   public String adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos){
        return this.controllerGeral.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
   }

   public void editaCombo(String nome, String descricao, String fornecedor, double novoFator){
        this.controllerGeral.editaCombo(nome, descricao, fornecedor, novoFator);
   }

   public String exibeContasClientes(String cpf){
       return this.controllerGeral.exibeContasClientes(cpf);
   }

   public void realizaPagamento(String cpf, String fornecedor){
        this.controllerGeral.realizaPagamento(cpf, fornecedor);
   }

   public void ordenaPor(String criterio){
        this.controllerGeral.ordenaPor(criterio);
   }

   public String listarCompras(){
       return this.controllerGeral.listarCompras();
   }
}
