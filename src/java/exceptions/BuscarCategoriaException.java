package exceptions;

public class BuscarCategoriaException extends Exception {

    /**
     * Creates a new instance of <code>BuscarCategoriaException</code> without
     * detail message.
     */
    public BuscarCategoriaException() {
    }

    /**
     * Constructs an instance of <code>BuscarCategoriaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BuscarCategoriaException(String msg) {
        super(msg);
    }
}
