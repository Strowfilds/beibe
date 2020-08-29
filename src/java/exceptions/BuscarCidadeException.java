/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Leonardo
 */
public class BuscarCidadeException extends Exception {

    /**
     * Creates a new instance of <code>BuscarCidadeException</code> without
     * detail message.
     */
    public BuscarCidadeException() {
    }

    /**
     * Constructs an instance of <code>BuscarCidadeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BuscarCidadeException(String msg) {
        super(msg);
    }
}
