package Logic_and_GUI;

import DAO.PlacesDAO;
import DAO.UsersDAO;
import DatabaseConnection.DatabaseConnector;
import Models.Concert;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUserGUI implements ActionListener {

    private DatabaseConnector dbConn;
    private Concert selectedConcert;

    private JFrame userLoginFrame;
    private JPanel userLoginPanel;
    private JLabel userLoginTitle;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginUserGUI(DatabaseConnector dbConn, Concert selectedConcert) {

        //database conector
        this.dbConn = dbConn;
        //if the login is for seasonticket, then we do not need the selected concert, so it will be null
        this.selectedConcert = selectedConcert;

        //title label
        userLoginTitle = new JLabel("Autentificare utilizator:");
        userLoginTitle.setBounds(15, 10, 400, 30);
        Font f = new Font("Comic sans MS", Font.BOLD, 16);
        userLoginTitle.setFont(f);
        userLoginTitle.setHorizontalAlignment(JLabel.CENTER);
        userLoginTitle.setForeground(Color.DARK_GRAY);

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
        userLoginPanel = new JPanel();
        userLoginPanel.setLayout(null);
        userLoginPanel.setVisible(true);
        userLoginPanel.setBackground(new Color(240, 240, 240));
        userLoginPanel.add(userLoginTitle);
        userLoginPanel.add(usernameLabel);
        userLoginPanel.add(usernameTextField);
        userLoginPanel.add(passwordLabel);
        userLoginPanel.add(passwordField);
        userLoginPanel.add(loginButton);

        //frame
        userLoginFrame = new JFrame();
        userLoginFrame.setBounds(400, 200, 450, 230);
        userLoginFrame.setTitle("Filarmonica de stat Transilvania Cluj-Napoca");
        userLoginFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        userLoginFrame.setResizable(false);
        userLoginFrame.setLayout(null);
        userLoginFrame.setContentPane(userLoginPanel);
        userLoginFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String username = "";
        String password = "";
        if(source == loginButton) {
            username = usernameTextField.getText();
            password = String.valueOf(passwordField.getPassword());
            User foundUser = UsersDAO.selectUser(dbConn, username, password);
            if(foundUser == null) {
                JOptionPane.showMessageDialog(null, "Nume de utilizator sau parolă incorecte!",
                        "Avertisment", JOptionPane.WARNING_MESSAGE);
            }
            else {
                this.userLoginFrame.setVisible(false);
                //if selected concert is null, it means the current operation is season ticket reserving,
                //so we need the available places for a season ticket
                if(selectedConcert == null) {
                    if(foundUser.getSeasonTicket() == null) {
                        new ReserveSeasonTicketGUI(dbConn, PlacesDAO.selectAvailablePlaces(dbConn), foundUser);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Aveți deja abonament!",
                                "Avertisment", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else {
                    new ReserveTicketGUI(dbConn, selectedConcert, foundUser);
                }
            }
        }
    }
}