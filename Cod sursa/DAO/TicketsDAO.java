package DAO;

import DatabaseConnection.DatabaseConnector;
import Models.Ticket;
import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketsDAO {

    private static final String selectAllTicketsStatement = "select * from baza_de_date_filarmonica.bilete";
    private static final String insertTicketStatement = "insert into baza_de_date_filarmonica.bilete(utilizator," +
            "concert) values(?, ?)";
    private static final String deleteTicketStatement = "delete from baza_de_date_filarmonica.bilete where id = ?";


    // Static Methods
    public static ArrayList<Ticket> selectAll(DatabaseConnector dbConn) {
        ArrayList<Ticket> toReturn = new ArrayList<Ticket>();

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectAllTicketsStatement);
            rs = statement.executeQuery();
            while(rs.next()) {
                toReturn.add(new Ticket(rs.getString("id"), rs.getString("utilizator"),
                        rs.getString("concert")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static void insertTicket(DatabaseConnector dbConn, String userId, String concertId) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(insertTicketStatement);
            statement.setString(1, userId);
            statement.setString(2, concertId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTicket(DatabaseConnector dbConn, String id) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(deleteTicketStatement);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
