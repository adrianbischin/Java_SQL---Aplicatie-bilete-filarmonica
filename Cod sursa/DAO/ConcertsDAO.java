package DAO;

import DatabaseConnection.DatabaseConnector;
import Models.Concert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConcertsDAO {

    private static final String selectAllConcertsStatement = "select * from baza_de_date_filarmonica.concerte";
    private static final String selectAllDatetimesStatement = "select data_ora from baza_de_date_filarmonica.concerte";
    private static final String selectConcertStatement = "select * from baza_de_date_filarmonica.concerte where data_ora = ?";
    private static final String insertConcertStatement = "insert into baza_de_date_filarmonica.concerte(data_ora, " +
            "locatie, detalii, pret, locuri_disponibile) values(str_to_date(?, '%d %m %Y %H:%i'), ?, ?, ?, ?)";
    private static final String deleteConcertStatement = "delete from baza_de_date_filarmonica.concerte where id = ?";
    private static final String updateConcertStatement = "update baza_de_date_filarmonica.concerte set locuri_disponibile" +
            " = ? where id = ?";


    // Static Methods
    public static ArrayList<Concert> selectAll(DatabaseConnector dbConn) {
        ArrayList<Concert> toReturn = new ArrayList<Concert>();

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectAllConcertsStatement);
            rs = statement.executeQuery();
            while(rs.next()) {
                toReturn.add(new Concert(rs.getString("id"), rs.getString("data_ora"),
                        rs.getString("locatie"), rs.getString("detalii"),
                        rs.getString("pret"), rs.getString("locuri_disponibile")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static ArrayList<String> selectAllDateTime(DatabaseConnector dbConn) {
        ArrayList<String> toReturn = new ArrayList<String>();

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectAllDatetimesStatement);
            rs = statement.executeQuery();
            while(rs.next()) {
                toReturn.add(rs.getString("data_ora"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static Concert selectConcert(DatabaseConnector dbConn, String data_ora) {
        Concert toReturn = null;

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectConcertStatement);
            statement.setString(1, data_ora);
            rs = statement.executeQuery();
            if(rs.next()) {
                toReturn = new Concert(rs.getString("id"), rs.getString("data_ora"),
                        rs.getString("locatie"), rs.getString("detalii"),
                        rs.getString("pret"), rs.getString("locuri_disponibile"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static void insertConcert(DatabaseConnector dbConn, String dateTime, String location, String details, String price) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(insertConcertStatement);
            statement.setString(1, dateTime);
            statement.setString(2, location);
            statement.setString(3, details);
            statement.setString(4, price);
            statement.setString(5, PlacesDAO.selectAvailablePlaces(dbConn).getPlacesList());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteConcert(DatabaseConnector dbConn, String id) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(deleteConcertStatement);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateConcert(DatabaseConnector dbConn, String availableSits, String id) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(updateConcertStatement);
            statement.setString(1, availableSits);
            statement.setString(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
