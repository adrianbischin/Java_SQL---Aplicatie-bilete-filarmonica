package DatabaseConnection;

import java.sql.*;

public class DatabaseConnector {

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String connectionURL = "jdbc:mysql://localhost:3306/baza_de_date_filarmonica";
    private static final String username = "root";
    private static final String password = "babolat";


    private Connection connection;

    /**Constructor*/
    public DatabaseConnector() {
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(connectionURL, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DatabaseConnector();
    }
}
