package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    public static final String URL = "jdbc:postgresql://localhost:5432/appliancesBrands";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "Relhzijd";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;

        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
}
