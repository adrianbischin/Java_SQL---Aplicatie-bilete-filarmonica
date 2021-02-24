package Logic_and_GUI;

import DAO.ConcertsDAO;
import DAO.PlacesDAO;
import DAO.TicketsDAO;
import DatabaseConnection.DatabaseConnector;
import Models.Concert;
import Models.Ticket;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReserveTicketGUI implements ActionListener {

    private DatabaseConnector dbConn;
    private Concert selectedConcert;
    private User loggedUser;

    private JFrame reserveTicketFrame;
    private JPanel reserveTicketPanel;
    private JLabel reserveTicketTitle;
    private JLabel concertHallImage;
    private JComboBox availablePlaces;
    private JButton selectButton;

    public ReserveTicketGUI(DatabaseConnector dbConn, Concert selectedConcert, User loggedUser) {

        this.dbConn = dbConn;
        this.selectedConcert = selectedConcert;
        this.loggedUser = loggedUser;

        //title label
        reserveTicketTitle = new JLabel("Filarmonica de stat Transilvania Cluj-Napoca               Selectați un loc:");
        reserveTicketTitle.setBounds(100, 10, 850, 30);
        Font f = new Font("Comic Sans MS", Font.BOLD, 22);
        reserveTicketTitle.setFont(f);
        reserveTicketTitle.setHorizontalAlignment(JLabel.CENTER);
        reserveTicketTitle.setForeground(Color.DARK_GRAY);

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
        String[] places = selectedConcert.getAvailableSits().split("[,\\s]+");
        for (String s : places) {
            availablePlaces.addItem(s);
        }

        //select button
        selectButton = new JButton("Aplică");
        selectButton.setBounds(800, 710, 150, 30);
        selectButton.addActionListener(this);

        //panel
        reserveTicketPanel = new JPanel();
        reserveTicketPanel.setLayout(null);
        reserveTicketPanel.setVisible(true);
        reserveTicketPanel.setBackground(new Color(240, 240, 240));
        reserveTicketPanel.add(reserveTicketTitle);
        reserveTicketPanel.add(concertHallImage);
        reserveTicketPanel.add(availablePlaces);
        reserveTicketPanel.add(selectButton);

        //frame
        reserveTicketFrame = new JFrame("Filarmonica de stat Transilvania Cluj-Napoca");
        reserveTicketFrame.setBounds(200, 20, 1000, 800);
        reserveTicketFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        reserveTicketFrame.setResizable(false);
        reserveTicketFrame.setLayout(null);
        reserveTicketFrame.setContentPane(reserveTicketPanel);
        reserveTicketFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == selectButton) {
            ConcertsDAO.updateConcert(dbConn, selectedConcert.getAvailableSits().replace(
                    this.availablePlaces.getSelectedItem() + ", ", ""), selectedConcert.getId());
//            String places = PlacesDAO.selectAvailablePlaces(dbConn).getPlacesList();
//            PlacesDAO.updatePlace(dbConn, places.replace(this.availablePlaces.getSelectedItem() + ", ", ""));
            TicketsDAO.insertTicket(dbConn, loggedUser.getId(), selectedConcert.getId());
            this.reserveTicketFrame.setVisible(false);
        }
    }
}