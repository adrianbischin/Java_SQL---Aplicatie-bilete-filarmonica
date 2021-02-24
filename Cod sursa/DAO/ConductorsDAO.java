package DAO;

import DatabaseConnection.DatabaseConnector;
import Models.Concert;
import Models.Conductor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConductorsDAO {

    private static final String selectAllConductorsStatement = "select * from baza_de_date_filarmonica.dirijori";
    private static final String insertConductorStatement = "insert into baza_de_date_filarmonica.dirijori(nume, prenume, informatii)" +
            " values(?, ?, ?)";
    private static final String deleteConductorStatement = "delete from baza_de_date_filarmonica.dirijori where id = ?";


    // Static Methods
    public static ArrayList<Conductor> selectAll(DatabaseConnector dbConn) {
        ArrayList<Conductor> toReturn = new ArrayList<Conductor>();

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectAllConductorsStatement);
            rs = statement.executeQuery();
            while(rs.next()) {
                toReturn.add(new Conductor(rs.getString("id"), rs.getString("nume"),
                        rs.getString("prenume"), rs.getString("informatii")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static void insertConductor(DatabaseConnector dbConn, String lastName, String firstName, String details) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(insertConductorStatement);
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, details);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteConductor(DatabaseConnector dbConn, String id) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(deleteConductorStatement);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
