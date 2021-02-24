package DAO;

import DatabaseConnection.DatabaseConnector;
import Models.Administrator;
import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdministratorsDAO {

    private static final String selectAllAdministratorsStatement = "select * from baza_de_date_filarmonica.administratori";
    private static final String selectAdministratorStatement = "select * from baza_de_date_filarmonica.administratori " +
            "where nume_utilizator = ? and parola = ?";
    private static final String deleteAdministratorStatement = "delete from baza_de_date_filarmonica.administratori where id = ?";
    private static final String insertAdministratorStatement = "insert into baza_de_date_filarmonica.administratori(nume," +
            "prenume, nume_utilizator, parola) values(?, ?, ?, ?)";


    // Static Methods
    public static ArrayList<Administrator> selectAll(DatabaseConnector dbConn) {
        ArrayList<Administrator> toReturn = new ArrayList<Administrator>();

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectAllAdministratorsStatement);
            rs = statement.executeQuery();
            while(rs.next()) {
                toReturn.add(new Administrator(rs.getString("id"), rs.getString("nume"),
                        rs.getString("prenume"), rs.getString("nume_utilizator"),
                        rs.getString("parola")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static Administrator selectAdministrator(DatabaseConnector dbConn, String username, String password) {
        Administrator toReturn = null;

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectAdministratorStatement);
            statement.setString(1, username);
            statement.setString(2, password);
            rs = statement.executeQuery();
            if(rs.next()) {
                toReturn = new Administrator(rs.getString("id"), rs.getString("nume"),
                        rs.getString("prenume"), rs.getString("nume_utilizator"),
                        rs.getString("parola"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static void insertAdministrator(DatabaseConnector dbConn, Administrator administrator) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(insertAdministratorStatement);
            statement.setString(1, administrator.getLastName());
            statement.setString(2, administrator.getFirstName());
            statement.setString(3, administrator.getUsername());
            statement.setString(4, administrator.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAdministrator(DatabaseConnector dbConn, String id) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(deleteAdministratorStatement);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
