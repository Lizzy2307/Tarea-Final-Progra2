package javamysql;

import java.sql.*;

public class MySQLManager {
  public static final String URL = "jdbc:mysql://localhost/isunah_prog2";
    public static final String USER = "root";
    public static final String CLAVE = "1234";
    
    public Connection getConexion() {

        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("No Conectado");
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }  
}
