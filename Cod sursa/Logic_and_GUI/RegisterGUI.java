package Logic_and_GUI;

import DAO.UsersDAO;
import DatabaseConnection.DatabaseConnector;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterGUI implements ActionListener {

    private DatabaseConnector dbConn;

    private JFrame registerFrame;
    private JPanel registerPanel;
    private JLabel registerTitle;
    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel passwordLabel2;
    private JTextField lastNameTextField;
    private JTextField firstNameTextField;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;
    private JButton registerButton;

    public RegisterGUI(DatabaseConnector dbConn) {

        //database conector
        this.dbConn = dbConn;

        //title label
        registerTitle = new JLabel("Înregistrare utilizator:");
        registerTitle.setBounds(15, 10, 400, 30);
        Font f = new Font("Comic sans MS", Font.BOLD, 16);
        registerTitle.setFont(f);
        registerTitle.setHorizontalAlignment(JLabel.CENTER);
        registerTitle.setForeground(Color.DARK_GRAY);

        //last name label
        lastNameLabel = new JLabel("Nume: ");
        lastNameLabel.setBounds(85, 60, 100, 30);

        //last name text field
        lastNameTextField = new JTextField();
        lastNameTextField.setBounds(130, 60, 270, 30);

        //first name label
        firstNameLabel = new JLabel("Prenume: ");
        firstNameLabel.setBounds(65, 100, 100, 30);

        //first name text field
        firstNameTextField = new JTextField();
        firstNameTextField.setBounds(130, 100, 270, 30);

        //username label
        usernameLabel = new JLabel("Nume utilizator: ");
        usernameLabel.setBounds(30, 140, 110, 30);

        //username text field
        usernameTextField = new JTextField();
        usernameTextField.setBounds(130, 140, 270, 30);

        //password label
        passwordLabel = new JLabel("Parola: ");
        passwordLabel.setBounds(80, 180, 70, 30);

        //password text field
        passwordField = new JPasswordField();
        passwordField.setBounds(130, 180, 270, 30);


        //second password label
        passwordLabel2 = new JLabel("Confirmare Parola: ");
        passwordLabel2.setBounds(15, 220, 130, 30);

        //second password text field
        passwordField2 = new JPasswordField();
        passwordField2.setBounds(130, 220, 270, 30);


        //login button
        registerButton = new JButton("Înregistrare");
        registerButton.setBounds(160, 265, 130, 30);
        registerButton.addActionListener(this);

        //content panel
        registerPanel = new JPanel();
        registerPanel.setLayout(null);
        registerPanel.setVisible(true);
        registerPanel.setBackground(new Color(240, 240, 240));
        registerPanel.add(registerTitle);
        registerPanel.add(lastNameLabel);
        registerPanel.add(lastNameTextField);
        registerPanel.add(firstNameLabel);
        registerPanel.add(firstNameTextField);
        registerPanel.add(usernameLabel);
        registerPanel.add(usernameTextField);
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordField);
        registerPanel.add(passwordLabel2);
        registerPanel.add(passwordField2);
        registerPanel.add(registerButton);

        //frame
        registerFrame = new JFrame();
        registerFrame.setBounds(400, 200, 450, 350);
        registerFrame.setTitle("Filarmonica de stat Transilvania Cluj-Napoca");
        registerFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        registerFrame.setResizable(false);
        registerFrame.setLayout(null);
        registerFrame.setContentPane(registerPanel);
        registerFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == registerButton) {
            if(String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField2.getPassword()))) {
                UsersDAO.insertUser(dbConn, lastNameTextField.getText(), firstNameTextField.getText(), usernameTextField.getText(),
                        String.valueOf(passwordField.getPassword()));
                this.registerFrame.setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Confirmare parolă nereușită!", "Avertisment",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
