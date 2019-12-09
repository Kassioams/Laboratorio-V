package util;

/**
 * Classe exclusiva para tratamento de excessões.
 *
 */

public class Validador {

    /**
     * Método para o tratamento de entradas nulas.
     *  @param dado o valor a ser conferido e validado
     * @param msg  a mensagem do metodo referido*/

    public void valida(String dado, String msg) {
        this.validaNulo(dado, msg);
        this.validaVazio(dado, msg);
    }

    /**
     * Método para o tratamento de entradas vazias.
     *
     * @param dado o valor a ser conferido e validadp
     * @param msg  a mensagem do método referido
     */

    private void validaVazio(String dado, String msg) {
        if (dado.trim().equals("")) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Método para o tratamento de entradas nulas.
     *
     * @param dado o valor a ser conferido e validadp
     * @param msg  a mensagem do método referido
     */

    private void validaNulo(String dado, String msg) {
        if (dado == null) {
            throw new NullPointerException(msg);
        }
    }

    /**
     * Método para o tratamento do cpf.
     *
     * @param cpf o cpf a ser validado
     * @param msg  a mensagem do método referido
     */
    public void validaCpf(String cpf, String msg){
        if (cpf.length() != 11){
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Método para tratamento da data.
     * @param data
     * @param msg
     */
    public void validaData(String data, String msg){
        if (data.length() > 10){
            throw new IllegalArgumentException(msg);
        }
    }

    public void validaFator(double fator, String msg) {
        if (fator <= 0 || fator >= 1) {
            throw new IllegalArgumentException(msg);
        }
    }
}
