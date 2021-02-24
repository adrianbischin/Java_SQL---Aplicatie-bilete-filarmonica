package DAO;

import DatabaseConnection.DatabaseConnector;
import Models.Places;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlacesDAO {

    private static final String selectAllPlacesStatement = "select * from baza_de_date_filarmonica.locuri";
    private static final String selectAvailablePlacesStatement = "select * from baza_de_date_filarmonica.locuri where categorie = 'locurile disponibile pentru abonament'";
    private static final String insertPlaceStatement = "insert into baza_de_date_filarmonica.locuri(categorie, lista locuri) values(?, ?)";
    private static final String deletePlaceStatement = "delete from baza_de_date_filarmonica.locuri where id = ?";
    private static final String updatePlaceStatement = "update baza_de_date_filarmonica.locuri set lista_locuri = ? where categorie = 'locurile disponibile pentru abonament'";


    // Static Methods
    public static ArrayList<Places> selectAll(DatabaseConnector dbConn) {
        ArrayList<Places> toReturn = new ArrayList<Places>();

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectAllPlacesStatement);
            rs = statement.executeQuery();
            while (rs.next()) {
                toReturn.add(new Places(rs.getString("id"), rs.getString("categorie"),
                        rs.getString("lista_locuri")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static Places selectAvailablePlaces(DatabaseConnector dbConn) {
        Places toReturn = null;
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectAvailablePlacesStatement);
            rs = statement.executeQuery();
            if (rs.next()) {
                toReturn = new Places(rs.getString("id"), rs.getString("categorie"),
                        rs.getString("lista_locuri"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static void insertPlace(DatabaseConnector dbConn, Places place) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(insertPlaceStatement);
            statement.setString(1, place.getCategory());
            statement.setString(2, place.getPlacesList());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePlace(DatabaseConnector dbConn, String id) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(deletePlaceStatement);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePlace(DatabaseConnector dbConn, String lista_locuri) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(updatePlaceStatement);
            statement.setString(1, lista_locuri);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
