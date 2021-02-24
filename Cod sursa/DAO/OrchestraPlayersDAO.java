package DAO;

import DatabaseConnection.DatabaseConnector;
import Models.Concert;
import Models.OrchestraPlayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrchestraPlayersDAO {

    private static final String selectAllOrchestraPlayersStatement = "select * from baza_de_date_filarmonica.instrumentisti";
    private static final String insertOrchestraPlayerStatement = "insert into baza_de_date_filarmonica.instrumentisti" +
            "(nume, prenume, partida, sef_partida, concertmaestru) values(?, ?, ?, ?, ?)";
    private static final String deleteOrchestraPlayerStatement = "delete from baza_de_date_filarmonica.instrumentisti where id = ?";


    // Static Methods
    public static ArrayList<OrchestraPlayer> selectAll(DatabaseConnector dbConn) {
        ArrayList<OrchestraPlayer> toReturn = new ArrayList<OrchestraPlayer>();

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectAllOrchestraPlayersStatement);
            rs = statement.executeQuery();
            while(rs.next()) {
                toReturn.add(new OrchestraPlayer(rs.getString("id"), rs.getString("nume"),
                        rs.getString("prenume"), rs.getString("partida"),
                        rs.getString("sef_partida"), rs.getString("concertmaestru")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static void insertOrchestraPlayer(DatabaseConnector dbConn, String lastName, String firstName, String section,
                                             String sectionPrincipal, String concertmaster) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(insertOrchestraPlayerStatement);
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, section);
            statement.setString(4, sectionPrincipal);
            statement.setString(5, concertmaster);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOrchestraPlayer(DatabaseConnector dbConn, String id) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(deleteOrchestraPlayerStatement);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
