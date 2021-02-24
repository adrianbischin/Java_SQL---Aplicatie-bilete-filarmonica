package Logic_and_GUI;

import DAO.*;
import DatabaseConnection.DatabaseConnector;
import Models.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAdminGUI implements ActionListener {

    private DatabaseConnector dbConn;

    private JFrame adminLoginFrame;
    private JPanel adminLoginPanel;
    private JLabel adminLoginTitle;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginAdminGUI(DatabaseConnector dbConn) {

        //database conector
        this.dbConn = dbConn;

        //title label
        adminLoginTitle = new JLabel("Autentificare administrator:");
        adminLoginTitle.setBounds(15, 10, 400, 30);
        Font f = new Font("Comic sans MS", Font.BOLD, 16);
        adminLoginTitle.setFont(f);
        adminLoginTitle.setHorizontalAlignment(JLabel.CENTER);
        adminLoginTitle.setForeground(Color.DARK_GRAY);

        //username label
        usernameLabel = new JLabel("Nume utilizator: ");
        usernameLabel.setBounds(30, 60, 100, 30);

        //username text field
        usernameTextField = new JTextField();
        usernameTextField.setBounds(130, 60, 270, 30);

        //password label
        passwordLabel = new JLabel("Parola: ");
        passwordLabel.setBounds(80, 100, 70, 30);

        //password text field
        passwordField = new JPasswordField();
        passwordField.setBounds(130, 100, 270, 30);

        //login button
        loginButton = new JButton("Autentificare");
        loginButton.setBounds(270, 145, 130, 30);
        loginButton.addActionListener(this);

        //content panel
        adminLoginPanel = new JPanel();
        adminLoginPanel.setLayout(null);
        adminLoginPanel.setVisible(true);
        adminLoginPanel.setBackground(new Color(240, 240, 240));
        adminLoginPanel.add(adminLoginTitle);
        adminLoginPanel.add(usernameLabel);
        adminLoginPanel.add(usernameTextField);
        adminLoginPanel.add(passwordLabel);
        adminLoginPanel.add(passwordField);
        adminLoginPanel.add(loginButton);

        //frame
        adminLoginFrame = new JFrame();
        adminLoginFrame.setBounds(400, 200, 450, 230);
        adminLoginFrame.setTitle("Filarmonica de stat Transilvania Cluj-Napoca");
        adminLoginFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        adminLoginFrame.setResizable(false);
        adminLoginFrame.setLayout(null);
        adminLoginFrame.setContentPane(adminLoginPanel);
        adminLoginFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String username = "";
        String password = "";
        if(source == loginButton) {
            username = usernameTextField.getText();
            password = String.valueOf(passwordField.getPassword());
            Administrator foundAdmin = AdministratorsDAO.selectAdministrator(dbConn, username, password);
            if(foundAdmin == null) {
                JOptionPane.showMessageDialog(null, "Nume de utilizator sau parolă incorecte!",
                        "Avertisment", JOptionPane.WARNING_MESSAGE);
            }
            else {
                this.adminLoginFrame.setVisible(false);
                new AdministratorGUI(dbConn, ConcertsDAO.selectAll(dbConn), OrchestraPlayersDAO.selectAll(dbConn), ChoirPlayersDAO.selectAll(dbConn),
                        ConductorsDAO.selectAll(dbConn), ManagementMembersDAO.selectAll(dbConn), UsersDAO.selectAll(dbConn), TicketsDAO.selectAll(dbConn));
            }
        }
    }
}