package DAO;

import DatabaseConnection.DatabaseConnector;
import Models.ChoirPlayer;
import Models.Concert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChoirPlayersDAO {

    private static  final String selectAllChoirPlayersStatement = "select * from baza_de_date_filarmonica.coristi";
    private static  final String insertChoirPlayerStatement = "insert into baza_de_date_filarmonica.coristi" +
            "(nume, prenume, partida, sef_partida) values(?, ?, ?, ?)";
    private static  final String deleteChoirPlayerStatement = "delete from baza_de_date_filarmonica.coristi where id = ?";


    // Static Methods
    public static ArrayList<ChoirPlayer> selectAll(DatabaseConnector dbConn) {
        ArrayList<ChoirPlayer> toReturn = new ArrayList<ChoirPlayer>();

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectAllChoirPlayersStatement);
            rs = statement.executeQuery();
            while(rs.next()) {
                toReturn.add(new ChoirPlayer(rs.getString("id"), rs.getString("nume"),
                        rs.getString("prenume"), rs.getString("partida"),
                        rs.getString("sef_partida")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static void insertChoirPlayer(DatabaseConnector dbConn, String lastName, String firstName, String section, String sectionPrincipal) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(insertChoirPlayerStatement);
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, section);
            statement.setString(4, sectionPrincipal);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteChoirPlayer(DatabaseConnector dbConn, String id) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(deleteChoirPlayerStatement);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
