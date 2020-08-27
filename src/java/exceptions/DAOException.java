package exceptions;

import java.sql.SQLException;

public class DAOException extends Exception {

    /**
     * Creates a new instance of <code>DAOException</code> without detail
     * message.
     */
    public DAOException() {
    }

    /**
     * Constructs an instance of <code>DAOException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DAOException(String msg) {
        super(msg);
    }

    public DAOException(String string, ClassNotFoundException ex) {
        super();
    }

    public DAOException(String string, SQLException ex) {
        super();
    }
}
