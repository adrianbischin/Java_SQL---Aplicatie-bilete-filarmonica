package DAO;

import DatabaseConnection.DatabaseConnector;
import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDAO {

    private static final String selectAllUsersStatement = "select * from baza_de_date_filarmonica.utilizatori";
    private static final String selectUserStatement = "select * from baza_de_date_filarmonica.utilizatori " +
            "where nume_utilizator = ? and parola = ?";
    private static final String deleteUserStatement = "delete from baza_de_date_filarmonica.utilizatori where id = ?";
    private static final String insertUserStatement = "insert into baza_de_date_filarmonica.utilizatori(nume, " +
            "prenume, nume_utilizator, parola) values(?, ?, ?, ?)";
    private static final String updateUserStatement = "update baza_de_date_filarmonica.utilizatori set abonament = ?";


    // Static Methods
    public static ArrayList<User> selectAll(DatabaseConnector dbConn) {
        ArrayList<User> toReturn = new ArrayList<User>();

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectAllUsersStatement);
            rs = statement.executeQuery();
            while(rs.next()) {
                toReturn.add(new User(rs.getString("id"), rs.getString("nume"),
                        rs.getString("prenume"), rs.getString("nume_utilizator"),
                        rs.getString("parola"), rs.getString("abonament")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static User selectUser(DatabaseConnector dbConn, String username, String password) {
        User toReturn = null;

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectUserStatement);
            statement.setString(1, username);
            statement.setString(2, password);
            rs = statement.executeQuery();
            if(rs.next()) {
                toReturn = new User(rs.getString("id"), rs.getString("nume"),
                        rs.getString("prenume"), rs.getString("nume_utilizator"),
                        rs.getString("parola"), rs.getString("abonament"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static void insertUser(DatabaseConnector dbConn, String lastName, String firstName, String username, String password) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(insertUserStatement);
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(DatabaseConnector dbConn, String id) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(deleteUserStatement);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(DatabaseConnector dbConn, String seasonTicket) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(updateUserStatement);
            statement.setString(1, seasonTicket);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
