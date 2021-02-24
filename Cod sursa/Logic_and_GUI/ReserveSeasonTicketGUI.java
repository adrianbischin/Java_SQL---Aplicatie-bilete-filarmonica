package Logic_and_GUI;

import DAO.ConcertsDAO;
import DAO.PlacesDAO;
import DAO.UsersDAO;
import DatabaseConnection.DatabaseConnector;
import Models.Concert;
import Models.Places;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReserveSeasonTicketGUI implements ActionListener {

    private DatabaseConnector dbConn;
    private Places places;
    private User loggedUser;

    private JFrame reserveSeasonTicketFrame;
    private JPanel reserveSeasonTicketPanel;
    private JLabel reserveSeasonTicketTitle;
    private JLabel concertHallImage;
    private JComboBox availablePlaces;
    private JButton selectButton;

    public ReserveSeasonTicketGUI(DatabaseConnector dbConn, Places places, User loggedUser) {

        //database conector
        this.dbConn = dbConn;
        this.places = places;
        this.loggedUser = loggedUser;

        //title label
        reserveSeasonTicketTitle = new JLabel("Filarmonica de stat Transilvania Cluj-Napoca");
        reserveSeasonTicketTitle.setBounds(110, 10, 500, 30);
        Font f = new Font("Comic Sans MS", Font.BOLD, 22);
        reserveSeasonTicketTitle.setFont(f);
        reserveSeasonTicketTitle.setHorizontalAlignment(JLabel.CENTER);
        reserveSeasonTicketTitle.setForeground(Color.DARK_GRAY);

        //image
        concertHallImage = new JLabel();
        concertHallImage.setIcon(new ImageIcon("D:\\Scoala\\An III Sem 1\\IS - Inginerie Software\\Proiect\\" +
                "IntelliJ project\\plan_sala.PNG"));
        concertHallImage.setBounds(30, 60, 700, 680);

        //concert chooser comboBox
        availablePlaces = new JComboBox();
        availablePlaces.setBounds(740, 60, 230, 30);
        availablePlaces.setSelectedItem("Selecteaza concert (data si ora)");
        availablePlaces.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] placesList = places.getPlacesList().split("[,\\s]+");
        for (String s : placesList) {
            availablePlaces.addItem(s);
        }


        //select button
        selectButton = new JButton("Aplică");
        selectButton.setBounds(800, 710, 150, 30);
        selectButton.addActionListener(this);

        //panel
        reserveSeasonTicketPanel = new JPanel();
        reserveSeasonTicketPanel.setLayout(null);
        reserveSeasonTicketPanel.setVisible(true);
        reserveSeasonTicketPanel.setBackground(new Color(240, 240, 240));
        reserveSeasonTicketPanel.add(reserveSeasonTicketTitle);
        reserveSeasonTicketPanel.add(concertHallImage);
        reserveSeasonTicketPanel.add(availablePlaces);
        reserveSeasonTicketPanel.add(selectButton);

        //frame
        reserveSeasonTicketFrame = new JFrame("Filarmonica de stat Transilvania Cluj-Napoca");
        reserveSeasonTicketFrame.setBounds(200, 20, 1000, 800);
        reserveSeasonTicketFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        reserveSeasonTicketFrame.setResizable(false);
        reserveSeasonTicketFrame.setLayout(null);
        reserveSeasonTicketFrame.setContentPane(reserveSeasonTicketPanel);
        reserveSeasonTicketFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == selectButton) {
            String places = PlacesDAO.selectAvailablePlaces(dbConn).getPlacesList();
            PlacesDAO.updatePlace(dbConn, places.replace(this.availablePlaces.getSelectedItem() + ", ", ""));
            ArrayList<Concert> concerts = ConcertsDAO.selectAll(dbConn);
            for (Concert concert : concerts) {
                ConcertsDAO.updateConcert(dbConn, concert.getAvailableSits().replace(availablePlaces.getSelectedItem() +
                        ", ", ""), concert.getId());
            }
            UsersDAO.updateUser(dbConn, String.valueOf(availablePlaces.getSelectedItem()));
            this.reserveSeasonTicketFrame.setVisible(false);
        }
    }
}