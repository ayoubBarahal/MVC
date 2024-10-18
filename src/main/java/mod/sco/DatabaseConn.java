package mod.sco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {

    private static Connection conn;

    private static final String URL = "jdbc:mysql://localhost:3306/scolarite";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion établie !");

            } catch (ClassNotFoundException e) {

                e.printStackTrace();
                throw new SQLException(" Driver JDBC introuvable. ");

            }
        }
        return conn;
    }
}
