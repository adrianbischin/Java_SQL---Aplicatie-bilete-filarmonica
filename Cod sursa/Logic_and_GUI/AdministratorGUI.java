package Logic_and_GUI;

import DAO.*;
import DatabaseConnection.DatabaseConnector;
import Models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdministratorGUI implements ActionListener {

    DatabaseConnector dbConn;

    //general components
    private JFrame adminFrame;
    private JTabbedPane adminTabbedPane;

    //concerts components
    private JTable concertsTable;
    private JLabel concertsDeleteLabel;
    private JTextField concertsDeleteField;
    private JButton concertsDeleteButton;
    private JLabel dateTimeLabel;
    private JTextField dateTimeField;
    private JLabel locationLabel;
    private JTextField locationField;
    private JLabel detailsLabel;
    private JTextField detailsField;
    private JLabel priceLabel;
    private JTextField priceField;
    private JButton concertsAddButton;
    private JPanel concertsPanel;


    //orchestra components
    private JTable orchestraTable;
    private JLabel orchestraDeleteLabel;
    private JTextField orchestraDeleteField;
    private JButton orchestraDeleteButton;
    private JLabel orchestraLastNameLabel;
    private JTextField orchestraLastNameField;
    private JLabel orchestraFirstNameLabel;
    private JTextField orchestraFirstNameField;
    private JLabel orchestraSectionLabel;
    private JTextField orchestraSectionField;
    private JLabel orchestraSectionPrincipalLabel;
    private JTextField orchestraSectionPrincipalField;
    private JLabel orchestraConcertmasterLabel;
    private JTextField orchestraConcertmasterField;
    private JButton orchestraAddButton;
    private JPanel orchestraPanel;

    //choir components
    private JTable choirTable;
    private JLabel choirDeleteLabel;
    private JTextField choirDeleteField;
    private JButton choirDeleteButton;
    private JLabel choirLastNameLabel;
    private JTextField choirLastNameField;
    private JLabel choirFirstNameLabel;
    private JTextField choirFirstNameField;
    private JLabel choirSectionLabel;
    private JTextField choirSectionField;
    private JLabel choirSectionPrincipalLabel;
    private JTextField choirSectionPrincipalField;
    private JButton choirAddButton;
    private JPanel choirPanel;

    //conductors components
    private JTable conductorsTable;
    private JLabel conductorsDeleteLabel;
    private JTextField conductorsDeleteField;
    private JButton conductorsDeleteButton;
    private JLabel conductorsLastNameLabel;
    private JTextField conductorsLastNameField;
    private JLabel conductorsFirstNameLabel;
    private JTextField conductorsFirstNameField;
    private JLabel conductorsDetailsLabel;
    private JTextField conductorsDetailsField;
    private JButton conductorsAddButton;
    private JPanel conductorsPanel;

    //team components
    private JTable teamTable;
    private JLabel teamDeleteLabel;
    private JTextField teamDeleteField;
    private JButton teamDeleteButton;
    private JLabel teamLastNameLabel;
    private JTextField teamLastNameField;
    private JLabel teamFirstNameLabel;
    private JTextField teamFirstNameField;
    private JLabel teamPositionLabel;
    private JTextField teamPositionField;
    private JButton teamAddButton;
    private JPanel teamPanel;

    //users components
    private JTable usersTable;
    private JLabel usersDeleteLabel;
    private JTextField usersDeleteField;
    private JButton usersDeleteButton;
    private JPanel usersPanel;

    //tickets components
    private JTable ticketsTable;
    private JLabel ticketsDeleteLabel;
    private JTextField ticketsDeleteField;
    private JButton ticketsDeleteButton;
    private JPanel ticketsPanel;


    //useful data
    private ArrayList<Concert> concerts;
    private ArrayList<OrchestraPlayer> orchestraPlayers;
    private ArrayList<ChoirPlayer> choirPlayers;
    private ArrayList<Conductor> conductors;
    private ArrayList<ManagementMember> managementMembers;
    private ArrayList<User> users;
    private ArrayList<Ticket> tickets;


    public AdministratorGUI(DatabaseConnector dbConn, ArrayList<Concert> concerts, ArrayList<OrchestraPlayer> orchestraPlayers,
                            ArrayList<ChoirPlayer> choirPlayers, ArrayList<Conductor> conductors, ArrayList<ManagementMember>
                                    managementMembers, ArrayList<User> users, ArrayList<Ticket> tickets) {

        this.dbConn = dbConn;

        //initialising data
        this.concerts = concerts;
        this.orchestraPlayers = orchestraPlayers;
        this.choirPlayers = choirPlayers;
        this.conductors = conductors;
        this.managementMembers = managementMembers;
        this.users = users;
        this.tickets = tickets;

        //concerts
        String[][] concertsString = new String[concerts.size()][5];
        for(int i = 0; i < concerts.size(); i++) {
            concertsString[i][0] = concerts.get(i).getId();
            concertsString[i][1] = concerts.get(i).getDateTime();
            concertsString[i][2] = concerts.get(i).getLocation();
            concertsString[i][3] = concerts.get(i).getDetails();
            concertsString[i][4] = concerts.get(i).getPrice();
        }
        concertsTable = new JTable(concertsString, new String[]{"Id", "Data Ora", "Locație", "Detalii", "Preț"});
        JScrollPane concertsScroll = new JScrollPane(concertsTable);
        concertsScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        concertsScroll.setBounds(40, 20, 700, 200);
        concertsDeleteLabel = new JLabel("Concert de șters : ");
        concertsDeleteLabel.setBounds(110, 230, 110, 30);
        concertsDeleteField = new JTextField("  Id");
        concertsDeleteField.setBounds(230, 230, 300, 30);
        concertsDeleteButton = new JButton("Șterge");
        concertsDeleteButton.setBounds(550, 230,100, 30);
        concertsDeleteButton.addActionListener(this);
        dateTimeLabel = new JLabel("Data și ora : ");
        dateTimeLabel.setBounds(40, 350, 100, 30);
        dateTimeField = new JTextField("    Format:    ZZ LL AAAA OO:MM");
        dateTimeField.setBounds(150, 350, 550, 30);
        locationLabel = new JLabel("Locație : ");
        locationLabel.setBounds(40, 400, 550, 30);
        locationField = new JTextField();
        locationField.setBounds(150, 400, 550, 30);
        detailsLabel = new JLabel("Detalii : ");
        detailsLabel.setBounds(40, 450, 550, 30);
        detailsField = new JTextField();
        detailsField.setBounds(150, 450, 550, 30);
        priceLabel = new JLabel("Preț : ");
        priceLabel.setBounds(40, 500, 550, 30);
        priceField = new JTextField();
        priceField.setBounds(150, 500, 550, 30);
        concertsAddButton = new JButton("Adaugă Concert");
        concertsAddButton.setBounds(320, 560, 150, 30);
        concertsAddButton.addActionListener(this);
        //concerts pannel
        concertsPanel = new JPanel();
        concertsPanel.setLayout(null);
        concertsPanel.setVisible(true);
        concertsPanel.setBackground(new Color(240, 240, 240));
        concertsPanel.add(concertsScroll);
        concertsPanel.add(concertsDeleteLabel);
        concertsPanel.add(concertsDeleteField);
        concertsPanel.add(concertsDeleteButton);
        concertsPanel.add(dateTimeLabel);
        concertsPanel.add(dateTimeField);
        concertsPanel.add(locationLabel);
        concertsPanel.add(locationField);
        concertsPanel.add(detailsLabel);
        concertsPanel.add(detailsField);
        concertsPanel.add(priceLabel);
        concertsPanel.add(priceField);
        concertsPanel.add(concertsAddButton);


        //orchestra
        String[][] orchestraString = new String[orchestraPlayers.size()][6];
        for(int i = 0; i < orchestraPlayers.size(); i++) {
            orchestraString[i][0] = orchestraPlayers.get(i).getId();
            orchestraString[i][1] = orchestraPlayers.get(i).getLastName();
            orchestraString[i][2] = orchestraPlayers.get(i).getFirstName();
            orchestraString[i][3] = orchestraPlayers.get(i).getSection();
            orchestraString[i][4] = orchestraPlayers.get(i).getSectionPrincipal();
            orchestraString[i][5] = orchestraPlayers.get(i).getConcertmaster();
        }
        orchestraTable = new JTable(orchestraString, new String[]{"Id", "Nume", "Prenume", "Partidă", "Șef Partidă", "Concertmaestru"});
        JScrollPane orchestraScroll = new JScrollPane(orchestraTable);
        orchestraScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        orchestraScroll.setBounds(40, 20, 700, 200);
        orchestraDeleteLabel = new JLabel("Instrumentist de șters : ");
        orchestraDeleteLabel.setBounds(81, 230, 140, 30);
        orchestraDeleteField = new JTextField("  Id");
        orchestraDeleteField.setBounds(230, 230, 300, 30);
        orchestraDeleteButton = new JButton("Șterge");
        orchestraDeleteButton.setBounds(550, 230,100, 30);
        orchestraDeleteButton.addActionListener(this);
        orchestraLastNameLabel = new JLabel("Nume : ");
        orchestraLastNameLabel.setBounds(40, 300, 100, 30);
        orchestraLastNameField = new JTextField();
        orchestraLastNameField.setBounds(150, 300, 550, 30);
        orchestraFirstNameLabel = new JLabel("Prenume : ");
        orchestraFirstNameLabel.setBounds(40, 350, 550, 30);
        orchestraFirstNameField = new JTextField();
        orchestraFirstNameField.setBounds(150, 350, 550, 30);
        orchestraSectionLabel = new JLabel("Partidă : ");
        orchestraSectionLabel.setBounds(40, 400, 550, 30);
        orchestraSectionField = new JTextField();
        orchestraSectionField.setBounds(150, 400, 550, 30);
        orchestraSectionPrincipalLabel = new JLabel("Șef Partidă : ");
        orchestraSectionPrincipalLabel.setBounds(40, 450, 550, 30);
        orchestraSectionPrincipalField = new JTextField("  0 / 1");
        orchestraSectionPrincipalField.setBounds(150, 450, 550, 30);
        orchestraConcertmasterLabel = new JLabel("Concertmaestru : ");
        orchestraConcertmasterLabel.setBounds(40, 500, 550, 30);
        orchestraConcertmasterField = new JTextField("  0 / 1");
        orchestraConcertmasterField.setBounds(150, 500, 550, 30);
        orchestraAddButton = new JButton("Adaugă Instrumentist");
        orchestraAddButton.setBounds(320, 560, 160, 30);
        orchestraAddButton.addActionListener(this);
        //orchestra pannel
        orchestraPanel = new JPanel();
        orchestraPanel.setLayout(null);
        orchestraPanel.setVisible(true);
        orchestraPanel.setBackground(new Color(240, 240, 240));
        orchestraPanel.add(orchestraScroll);
        orchestraPanel.add(orchestraDeleteLabel);
        orchestraPanel.add(orchestraDeleteField);
        orchestraPanel.add(orchestraDeleteButton);
        orchestraPanel.add(orchestraLastNameLabel);
        orchestraPanel.add(orchestraLastNameField);
        orchestraPanel.add(orchestraFirstNameLabel);
        orchestraPanel.add(orchestraFirstNameField);
        orchestraPanel.add(orchestraSectionLabel);
        orchestraPanel.add(orchestraSectionField);
        orchestraPanel.add(orchestraSectionPrincipalLabel);
        orchestraPanel.add(orchestraSectionPrincipalField);
        orchestraPanel.add(orchestraConcertmasterLabel);
        orchestraPanel.add(orchestraConcertmasterField);
        orchestraPanel.add(orchestraAddButton);


        //choir
        String[][] choirString = new String[choirPlayers.size()][5];
        for(int i = 0; i < choirPlayers.size(); i++) {
            choirString[i][0] = choirPlayers.get(i).getId();
            choirString[i][1] = choirPlayers.get(i).getLastName();
            choirString[i][2] = choirPlayers.get(i).getFirstName();
            choirString[i][3] = choirPlayers.get(i).getSection();
            choirString[i][4] = choirPlayers.get(i).getSectionPrincipal();
        }
        choirTable = new JTable(choirString, new String[]{"Id", "Nume", "Prenume", "Partidă", "Șef Partidă"});
        JScrollPane choirScroll = new JScrollPane(choirTable);
        choirScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        choirScroll.setBounds(40, 20, 700, 200);
        choirDeleteLabel = new JLabel("Corist de șters : ");
        choirDeleteLabel.setBounds(121, 230, 140, 30);
        choirDeleteField = new JTextField("  Id");
        choirDeleteField.setBounds(230, 230, 300, 30);
        choirDeleteButton = new JButton("Șterge");
        choirDeleteButton.setBounds(550, 230,100, 30);
        choirDeleteButton.addActionListener(this);
        choirLastNameLabel = new JLabel("Nume : ");
        choirLastNameLabel.setBounds(40, 350, 100, 30);
        choirLastNameField = new JTextField();
        choirLastNameField.setBounds(150, 350, 550, 30);
        choirFirstNameLabel = new JLabel("Prenume : ");
        choirFirstNameLabel.setBounds(40, 400, 550, 30);
        choirFirstNameField = new JTextField();
        choirFirstNameField.setBounds(150, 400, 550, 30);
        choirSectionLabel = new JLabel("Partidă : ");
        choirSectionLabel.setBounds(40, 450, 550, 30);
        choirSectionField = new JTextField();
        choirSectionField.setBounds(150, 450, 550, 30);
        choirSectionPrincipalLabel = new JLabel("Șef Partidă : ");
        choirSectionPrincipalLabel.setBounds(40, 500, 550, 30);
        choirSectionPrincipalField = new JTextField("  0 / 1");
        choirSectionPrincipalField.setBounds(150, 500, 550, 30);
        choirAddButton = new JButton("Adaugă Corist");
        choirAddButton.setBounds(320, 560, 160, 30);
        choirAddButton.addActionListener(this);
        //choir pannel
        choirPanel = new JPanel();
        choirPanel.setLayout(null);
        choirPanel.setVisible(true);
        choirPanel.setBackground(new Color(240, 240, 240));
        choirPanel.add(choirScroll);
        choirPanel.add(choirDeleteLabel);
        choirPanel.add(choirDeleteField);
        choirPanel.add(choirDeleteButton);
        choirPanel.add(choirLastNameLabel);
        choirPanel.add(choirLastNameField);
        choirPanel.add(choirFirstNameLabel);
        choirPanel.add(choirFirstNameField);
        choirPanel.add(choirSectionLabel);
        choirPanel.add(choirSectionField);
        choirPanel.add(choirSectionPrincipalLabel);
        choirPanel.add(choirSectionPrincipalField);
        choirPanel.add(choirAddButton);


        //conductors
        String[][] conductorsString = new String[conductors.size()][4];
        for(int i = 0; i < conductors.size(); i++) {
            conductorsString[i][0] = conductors.get(i).getId();
            conductorsString[i][1] = conductors.get(i).getLastName();
            conductorsString[i][2] = conductors.get(i).getFirstName();
            conductorsString[i][3] = conductors.get(i).getInfo();
        }
        conductorsTable = new JTable(conductorsString, new String[]{"Id", "Nume", "Prenume", "Informații"});
        JScrollPane conductorsScroll = new JScrollPane(conductorsTable);
        conductorsScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        conductorsScroll.setBounds(40, 20, 700, 200);
        conductorsDeleteLabel = new JLabel("Dirijor de șters : ");
        conductorsDeleteLabel.setBounds(120, 230, 140, 30);
        conductorsDeleteField = new JTextField("  Id");
        conductorsDeleteField.setBounds(230, 230, 300, 30);
        conductorsDeleteButton = new JButton("Șterge");
        conductorsDeleteButton.setBounds(550, 230,100, 30);
        conductorsDeleteButton.addActionListener(this);
        conductorsLastNameLabel = new JLabel("Nume : ");
        conductorsLastNameLabel.setBounds(40, 400, 100, 30);
        conductorsLastNameField = new JTextField();
        conductorsLastNameField.setBounds(150, 400, 550, 30);
        conductorsFirstNameLabel = new JLabel("Prenume : ");
        conductorsFirstNameLabel.setBounds(40, 450, 100, 30);
        conductorsFirstNameField = new JTextField();
        conductorsFirstNameField.setBounds(150, 450, 550, 30);
        conductorsDetailsLabel = new JLabel("Informații : ");
        conductorsDetailsLabel.setBounds(40, 500, 100, 30);
        conductorsDetailsField = new JTextField();
        conductorsDetailsField.setBounds(150, 500, 550, 30);
        conductorsAddButton = new JButton("Adaugă Dirijor");
        conductorsAddButton.setBounds(320, 560, 160, 30);
        conductorsAddButton.addActionListener(this);
        //conductors pannel
        conductorsPanel = new JPanel();
        conductorsPanel.setLayout(null);
        conductorsPanel.setVisible(true);
        conductorsPanel.setBackground(new Color(240, 240, 240));
        conductorsPanel.add(conductorsScroll);
        conductorsPanel.add(conductorsDeleteLabel);
        conductorsPanel.add(conductorsDeleteField);
        conductorsPanel.add(conductorsDeleteButton);
        conductorsPanel.add(conductorsLastNameLabel);
        conductorsPanel.add(conductorsLastNameField);
        conductorsPanel.add(conductorsFirstNameLabel);
        conductorsPanel.add(conductorsFirstNameField);
        conductorsPanel.add(conductorsDetailsLabel);
        conductorsPanel.add(conductorsDetailsField);
        conductorsPanel.add(conductorsAddButton);


        //team
        String[][] managentManagersString = new String[managementMembers.size()][4];
        for(int i = 0; i < managementMembers.size(); i++) {
            managentManagersString[i][0] = managementMembers.get(i).getId();
            managentManagersString[i][1] = managementMembers.get(i).getLastName();
            managentManagersString[i][2] = managementMembers.get(i).getFirstName();
            managentManagersString[i][3] = managementMembers.get(i).getPosition();
        }
        teamTable = new JTable(managentManagersString, new String[]{"Id", "Nume", "Prenume", "Funcție"});
        JScrollPane teamScroll = new JScrollPane(teamTable);
        teamScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        teamScroll.setBounds(40, 20, 700, 200);
        teamDeleteLabel = new JLabel("Angajat de șters : ");
        teamDeleteLabel.setBounds(114, 230, 140, 30);
        teamDeleteField = new JTextField("  Id");
        teamDeleteField.setBounds(230, 230, 300, 30);
        teamDeleteButton = new JButton("Șterge");
        teamDeleteButton.setBounds(550, 230,100, 30);
        teamDeleteButton.addActionListener(this);
        teamLastNameLabel = new JLabel("Nume : ");
        teamLastNameLabel.setBounds(40, 400, 100, 30);
        teamLastNameField = new JTextField();
        teamLastNameField.setBounds(150, 400, 550, 30);
        teamFirstNameLabel = new JLabel("Prenume : ");
        teamFirstNameLabel.setBounds(40, 450, 100, 30);
        teamFirstNameField = new JTextField();
        teamFirstNameField.setBounds(150, 450, 550, 30);
        teamPositionLabel = new JLabel("Funcție : ");
        teamPositionLabel.setBounds(40, 500, 100, 30);
        teamPositionField = new JTextField();
        teamPositionField.setBounds(150, 500, 550, 30);
        teamAddButton = new JButton("Adaugă Angajat");
        teamAddButton.setBounds(320, 560, 160, 30);
        teamAddButton.addActionListener(this);
        //team pannel
        teamPanel = new JPanel();
        teamPanel.setLayout(null);
        teamPanel.setVisible(true);
        teamPanel.setBackground(new Color(240, 240, 240));
        teamPanel.add(teamScroll);
        teamPanel.add(teamDeleteLabel);
        teamPanel.add(teamDeleteField);
        teamPanel.add(teamDeleteButton);
        teamPanel.add(teamLastNameLabel);
        teamPanel.add(teamLastNameField);
        teamPanel.add(teamFirstNameLabel);
        teamPanel.add(teamFirstNameField);
        teamPanel.add(teamPositionLabel);
        teamPanel.add(teamPositionField);
        teamPanel.add(teamAddButton);


        //users
        String[][] usersString = new String[users.size()][4];
        for(int i = 0; i < users.size(); i++) {
            usersString[i][0] = users.get(i).getId();
            usersString[i][1] = users.get(i).getLastName();
            usersString[i][2] = users.get(i).getFirstName();
            usersString[i][3] = users.get(i).getSeasonTicket();
        }
        usersTable = new JTable(usersString, new String[]{"Id", "Nume", "Prenume", "Loc abonament"});
        JScrollPane usersScroll = new JScrollPane(usersTable);
        usersScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        usersScroll.setBounds(40, 20, 700, 200);
        usersDeleteLabel = new JLabel("Utilizator de șters : ");
        usersDeleteLabel.setBounds(106, 230, 140, 30);
        usersDeleteField = new JTextField("  Id");
        usersDeleteField.setBounds(230, 230, 300, 30);
        usersDeleteButton = new JButton("Șterge");
        usersDeleteButton.setBounds(550, 230,100, 30);
        usersDeleteButton.addActionListener(this);
        //users pannel
        usersPanel = new JPanel();
        usersPanel.setLayout(null);
        usersPanel.setVisible(true);
        usersPanel.setBackground(new Color(240, 240, 240));
        usersPanel.add(usersScroll);
        usersPanel.add(usersDeleteLabel);
        usersPanel.add(usersDeleteField);
        usersPanel.add(usersDeleteButton);


        //tickets
        String[][] ticketsString = new String[tickets.size()][3];
        for(int i = 0; i < tickets.size(); i++) {
            ticketsString[i][0] = tickets.get(i).getId();
            ticketsString[i][1] = tickets.get(i).getConcert();
            ticketsString[i][2] = tickets.get(i).getUser();
        }
        ticketsTable = new JTable(ticketsString, new String[]{"Id", "Concert", "Utilizator"});
        JScrollPane ticketsScroll = new JScrollPane(ticketsTable);
        ticketsScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ticketsScroll.setBounds(40, 20, 700, 200);
        ticketsDeleteLabel = new JLabel("Bilet de șters : ");
        ticketsDeleteLabel.setBounds(127, 230, 140, 30);
        ticketsDeleteField = new JTextField("  Id");
        ticketsDeleteField.setBounds(230, 230, 300, 30);
        ticketsDeleteButton = new JButton("Șterge");
        ticketsDeleteButton.setBounds(550, 230,100, 30);
        ticketsDeleteButton.addActionListener(this);
        //tickets pannel
        ticketsPanel = new JPanel();
        ticketsPanel.setLayout(null);
        ticketsPanel.setVisible(true);
        ticketsPanel.setBackground(new Color(240, 240, 240));
        ticketsPanel.add(ticketsScroll);
        ticketsPanel.add(ticketsDeleteLabel);
        ticketsPanel.add(ticketsDeleteField);
        ticketsPanel.add(ticketsDeleteButton);


        //tabbed pane
        adminTabbedPane = new JTabbedPane();
        adminTabbedPane.add(concertsPanel, "Concerte");
        adminTabbedPane.add(orchestraPanel, "Orchestră");
        adminTabbedPane.add(choirPanel, "Cor");
        adminTabbedPane.add(conductorsPanel, "Dirijori");
        adminTabbedPane.add(teamPanel, "Angajați");
        adminTabbedPane.add(usersPanel, "Utilizatori");
        adminTabbedPane.add(ticketsPanel, "Bilete");

        //frame
        adminFrame = new JFrame("Filarmonica de stat Transilvania Cluj-Napoca - ADMINISTRATOR");
        adminFrame.setBounds(250, 20, 800, 700);
        adminFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        adminFrame.setResizable(false);
        adminFrame.setLayout(null);
        adminFrame.setContentPane(adminTabbedPane);
        adminFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == concertsDeleteButton) {
            ConcertsDAO.deleteConcert(dbConn, concertsDeleteField.getText());
            this.adminFrame.setVisible(false);
            new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                    ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
        }
        else if(source == concertsAddButton) {
            ConcertsDAO.insertConcert(dbConn, dateTimeField.getText(), locationField.getText(), detailsField.getText(),
                    priceField.getText());
            this.adminFrame.setVisible(false);
            new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                    ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
        }
        else if(source == orchestraDeleteButton) {
            OrchestraPlayersDAO.deleteOrchestraPlayer(dbConn, orchestraDeleteField.getText());
            this.adminFrame.setVisible(false);
            new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                    ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
        }
        else if(source == orchestraAddButton) {
            OrchestraPlayersDAO.insertOrchestraPlayer(dbConn, orchestraLastNameField.getText(), orchestraFirstNameField.getText(), orchestraSectionField.getText(),
                    orchestraSectionPrincipalField.getText(), orchestraConcertmasterField.getText());
            this.adminFrame.setVisible(false);
            new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                    ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
        }
        else if(source == choirDeleteButton) {
            ChoirPlayersDAO.deleteChoirPlayer(dbConn, choirDeleteField.getText());
            this.adminFrame.setVisible(false);
            new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                    ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
        }
        else if(source == choirAddButton) {
            ChoirPlayersDAO.insertChoirPlayer(dbConn, choirLastNameField.getText(), choirFirstNameField.getText(), choirSectionField.getText(),
                    choirSectionPrincipalField.getText());
            this.adminFrame.setVisible(false);
            new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                    ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
        }
        else if(source == conductorsDeleteButton) {
            ConductorsDAO.deleteConductor(dbConn, conductorsDeleteField.getText());
            this.adminFrame.setVisible(false);
            new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                    ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
        }
        else if(source == conductorsAddButton) {
            ConductorsDAO.insertConductor(dbConn, conductorsLastNameField.getText(), conductorsFirstNameField.getText(),
                    conductorsDetailsField.getText());
            this.adminFrame.setVisible(false);
            new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                    ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
        }
        else if(source == teamDeleteButton) {
            ManagementMembersDAO.deleteManagementMember(dbConn, teamDeleteField.getText());
            this.adminFrame.setVisible(false);
            new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                    ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
        }
        else if(source == teamAddButton) {
            ManagementMembersDAO.insertManagementMember(dbConn, teamLastNameField.getText(), teamFirstNameField.getText(),
                    teamPositionField.getText());
            this.adminFrame.setVisible(false);
            new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                    ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
        }
        else if(source == usersDeleteButton) {
            UsersDAO.deleteUser(dbConn, usersDeleteField.getText());
            this.adminFrame.setVisible(false);
            new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                    ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
        }
        else if(source == ticketsDeleteButton) {
            TicketsDAO.deleteTicket(dbConn, ticketsDeleteField.getText());
            this.adminFrame.setVisible(false);
            new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                    ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
        }
    }


    public static void main(String[] args) {
        DatabaseConnector dbConn = new DatabaseConnector();
        new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
    }
}