package dao;

import exceptions.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable {

    //private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String ALTDRIVER = "com.mysql.jdbc.Driver";
    //private static final String URL = "jdbc:mysql://localhost:3306/javaweb2";
    private static final String URL = "jdbc:postgresql://localhost:5432/web2_beibe";
    private static final String USUARIO = "web2";
    //private static final String USUARIO = "postgres";
    private static final String SENHA = "web2";
    //private static final String SENHA = "rootroot";
    //private static final String TIMEZONEPARAM = "?useTimezone=true&serverTimezone=UTC";
    private static final String TIMEZONEPARAM = "";

    private Connection con = null;

    public Connection getConnection() throws DAOException {
        if (con == null) {
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException e) {
                try {
                    Class.forName(ALTDRIVER);
                    con = DriverManager.getConnection((URL + TIMEZONEPARAM), USUARIO, SENHA);
                } catch (ClassNotFoundException ex) {
                    throw new DAOException("Drivers do banco não encontrado: " + DRIVER + "/" + ALTDRIVER, ex);
                } catch (SQLException ex) {
                    throw new DAOException("Erro conectando ao BD: " + URL + "/" + USUARIO + "/" + SENHA, ex);
                }
            } catch (SQLException ex) {
                throw new DAOException("Erro conectando ao BD: " + URL + "/" + USUARIO + "/" + SENHA, ex);
            }
        }
        return con;
    }

    @Override
    public void close() throws Exception {
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (Exception e) {
                System.out.println("Erro fechando a conexão. IGNORADO");
                e.printStackTrace();
            }
        }
    }
}
