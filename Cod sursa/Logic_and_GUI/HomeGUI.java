package Logic_and_GUI;

import DAO.*;
import DatabaseConnection.DatabaseConnector;
import Models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomeGUI implements ActionListener {

    private DatabaseConnector dbConn;
    private Concert selectedConcert;

    private JFrame homeFrame;
    private JPanel homePanel;
    private JLabel homeTitle;
    private JComboBox concertChooser;
    private JTextArea concertDetails;
    private JButton reserveTicket;
    private JButton reserveSeasonTicket;
    private JButton aboutUs;
    private JButton register;
    private JButton adminLogin;


    public HomeGUI(DatabaseConnector dbConn, ArrayList<String> concertDateTimes) {

        //database connector initializing
        this.dbConn = dbConn;

        //title label
        homeTitle = new JLabel("Filarmonica de stat Transilvania Cluj-Napoca");
        homeTitle.setBounds(50, 25, 500, 30);
        Font f = new Font("Comic Sans MS", Font.BOLD, 22);
        homeTitle.setFont(f);
        homeTitle.setHorizontalAlignment(JLabel.CENTER);
        homeTitle.setForeground(Color.DARK_GRAY);

        //concert chooser comboBox
        concertChooser = new JComboBox();
        concertChooser.setBounds(50, 100, 500, 30);
        concertChooser.setAlignmentX(Component.CENTER_ALIGNMENT);
        for(int i = 0; i < concertDateTimes.size(); i++) {
            concertChooser.addItem(concertDateTimes.get(i));
        }
        concertChooser.setSelectedItem(null);
        concertChooser.addActionListener(this);

        //text box
        concertDetails = new JTextArea();
        concertDetails.setBounds(50, 150, 500, 200);
        concertDetails.setBackground(new Color(195, 209, 219));
        concertDetails.setLineWrap(true);
        concertDetails.setWrapStyleWord(true);
        concertDetails.setEditable(false);

        //rezerve ticket button
        reserveTicket = new JButton("Rezervă bilet");
        reserveTicket.setBounds(245, 360, 110, 30);
        reserveTicket.setBackground(new Color(194, 208, 218));
        reserveTicket.addActionListener(this);

        //rezerve season ticket button
        reserveSeasonTicket = new JButton("Rezervă abonament");
        reserveSeasonTicket.setBounds(50, 430, 150, 30);
        reserveSeasonTicket.setBackground(new Color(248, 36, 36, 235));
        reserveSeasonTicket.addActionListener(this);

        //info button
        aboutUs = new JButton("Despre noi");
        aboutUs.setBounds(225, 430, 150, 30);
        aboutUs.setBackground(new Color(94, 205, 94, 210));
        aboutUs.addActionListener(this);

        //register button
        register = new JButton("Înregistrare");
        register.setBounds(400, 430, 150, 30);
        register.setBackground(new Color(232, 190, 81, 255));
        register.addActionListener(this);

        //admin login button
        adminLogin = new JButton("Autentificare administrator");
        adminLogin.setBounds(400, 480, 190, 15);
        adminLogin.setBackground(new Color(240, 240, 240));
        adminLogin.setBorder(null);
        adminLogin.addActionListener(this);

        //content panel
        homePanel = new JPanel();
        homePanel.setLayout(null);
        homePanel.setVisible(true);
        homePanel.setBackground(new Color(240, 240, 240));
        homePanel.add(homeTitle);
        homePanel.add(concertChooser);
        homePanel.add(concertDetails);
        homePanel.add(reserveTicket);
        homePanel.add(reserveSeasonTicket);
        homePanel.add(aboutUs);
        homePanel.add(register);
        homePanel.add(adminLogin);

        //frame
        homeFrame = new JFrame("Meniu principal");
        homeFrame.setBounds(400, 200, 600, 540);
        homeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        homeFrame.setResizable(false);
        homeFrame.setLayout(null);
        homeFrame.setContentPane(homePanel);
        homeFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Concert concert;
        String selectedDate = String.valueOf(concertChooser.getSelectedItem());


        //selectare concert
        if(source == concertChooser) {
            selectedConcert = new ConcertsDAO().selectConcert(dbConn, selectedDate);
            String[] infos = selectedConcert.getDetails().split("[|]+");
            String finalString = "Locație: " + selectedConcert.getLocation() + "\n";
            for(int i = 0; i < infos.length; i++) {
                if(i > 2) {
                    finalString += "\n        ";
                }
                else {
                    finalString += "\n";
                }

                finalString += infos[i];
            }
            finalString += "\n\nPreț bilet: " + selectedConcert.getPrice() + " lei";
            concertDetails.setText(finalString);
        }

        //reserve ticket -> user login
        else if(source == reserveTicket) {
            if(concertChooser.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Niciun concert selectat!", "Avertisment",
                        JOptionPane.WARNING_MESSAGE);
            }
            else {
                new LoginUserGUI(dbConn, selectedConcert);
            }
        }

        //reserve season ticket -> administrator login
        else if(source == reserveSeasonTicket) {
            new LoginUserGUI(dbConn, null);
        }

        //info window
        else if(source == aboutUs) {
            String[] tuple;

            ArrayList<OrchestraPlayer> orchestra =  OrchestraPlayersDAO.selectAll(dbConn);
            String[][] orchestraPlayers = new String[orchestra.size()][6];
            for(int i = 0; i < orchestra.size(); i++) {
                //System.out.println(orchestra.get(i).toString());
                orchestraPlayers[i][0] = orchestra.get(i).getId();
                orchestraPlayers[i][1] = orchestra.get(i).getLastName();
                orchestraPlayers[i][2] = orchestra.get(i).getFirstName();
                orchestraPlayers[i][3] = orchestra.get(i).getSection();
                orchestraPlayers[i][4] = orchestra.get(i).getSectionPrincipal();
                orchestraPlayers[i][5] = orchestra.get(i).getConcertmaster();
            }
            ArrayList<ChoirPlayer> choir =  ChoirPlayersDAO.selectAll(dbConn);
            tuple = new String[5];
            String[][] choirPlayers = new String[choir.size()][5];
            for(int i = 0; i < choir.size(); i++) {
                //System.out.println(choir.get(i).toString());
                choirPlayers[i][0] = choir.get(i).getId();
                choirPlayers[i][1] = choir.get(i).getLastName();
                choirPlayers[i][2] = choir.get(i).getFirstName();
                choirPlayers[i][3] = choir.get(i).getSection();
                choirPlayers[i][4] = choir.get(i).getSectionPrincipal();
            }
            ArrayList<Conductor> conductors = ConductorsDAO.selectAll(dbConn);
            String[][] allConductors = new String[conductors.size()][4];
            for(int i = 0; i < conductors.size(); i++) {
                //System.out.println(conductors.get(i).toString());
                allConductors[i][0] = conductors.get(i).getId();
                allConductors[i][1] = conductors.get(i).getLastName();
                allConductors[i][2] = conductors.get(i).getFirstName();
                allConductors[i][3] = conductors.get(i).getInfo();
            }
            ArrayList<ManagementMember> managers = ManagementMembersDAO.selectAll(dbConn);
            String[][] managementMembers = new String[managers.size()][4];
            for(int i = 0; i < managers.size(); i++) {
                //System.out.println(managers.get(i).toString());
                managementMembers[i][0] = managers.get(i).getId();
                managementMembers[i][1] = managers.get(i).getLastName();
                managementMembers[i][2] = managers.get(i).getFirstName();
                managementMembers[i][3] = managers.get(i).getPosition();
            }
            new InfoGUI(orchestraPlayers, choirPlayers, allConductors, managementMembers);
        }

        //register
        else if(source == register) {
            new RegisterGUI(dbConn);
        }

        //admin login
        else if(source == adminLogin) {
            new LoginAdminGUI(dbConn);
        }
    }

    public static void main(String[] args) {
        DatabaseConnector dbConn = new DatabaseConnector();
        ArrayList<String> concertDateTimes = ConcertsDAO.selectAllDateTime(dbConn);
        HomeGUI homeGUI = new HomeGUI(dbConn, concertDateTimes);
    }
}