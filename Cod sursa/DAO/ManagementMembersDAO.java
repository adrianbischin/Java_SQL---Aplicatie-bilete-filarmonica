package DAO;

import DatabaseConnection.DatabaseConnector;
import Models.Concert;
import Models.ManagementMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagementMembersDAO {

    private static final String selectAllManagementMembersStatement = "select * from baza_de_date_filarmonica.organizatoric";
    private static final String insertManagementMemberStatement = "insert into baza_de_date_filarmonica.organizatoric" +
            " (nume, prenume, functie) values(?, ?, ?)";
    private static final String deleteManagementMemberStatement = "delete from baza_de_date_filarmonica.organizatoric" +
            " where id = ?";


    // Static Methods
    public static ArrayList<ManagementMember> selectAll(DatabaseConnector dbConn) {
        ArrayList<ManagementMember> toReturn = new ArrayList<ManagementMember>();

        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        ResultSet rs;
        try {
            statement = dbConnection.prepareStatement(selectAllManagementMembersStatement);
            rs = statement.executeQuery();
            while(rs.next()) {
                toReturn.add(new ManagementMember(rs.getString("id"), rs.getString("nume"),
                        rs.getString("prenume"), rs.getString("functie")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toReturn;
    }

    public static void insertManagementMember(DatabaseConnector dbConn, String lastName, String firstName, String position) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(insertManagementMemberStatement);
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, position);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteManagementMember(DatabaseConnector dbConn, String id) {
        Connection dbConnection = dbConn.getConnection();
        PreparedStatement statement;
        try {
            statement = dbConnection.prepareStatement(deleteManagementMemberStatement);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
