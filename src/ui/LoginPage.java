package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.AuthService;

public class LoginPage extends JFrame
        implements ActionListener {

    JTextField txtUser;

    JPasswordField txtPass;

    JButton btnLogin;

    public LoginPage() {

        setTitle("Login");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);

        JLabel heading =
                new JLabel(
                        "MindCanvas Login"
                );

        heading.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        heading.setBounds(
                100,
                40,
                350,
                40
        );

        add(heading);

        JLabel lblUser =
                new JLabel("Username");

        lblUser.setBounds(
                80,
                120,
                100,
                30
        );

        add(lblUser);

        txtUser = new JTextField();

        txtUser.setBounds(
                180,
                120,
                200,
                30
        );

        add(txtUser);

        JLabel lblPass =
                new JLabel("Password");

        lblPass.setBounds(
                80,
                180,
                100,
                30
        );

        add(lblPass);

        txtPass =
                new JPasswordField();

        txtPass.setBounds(
                180,
                180,
                200,
                30
        );

        add(txtPass);

        btnLogin =
                new JButton("Login");

        btnLogin.setBounds(
                180,
                250,
                200,
                40
        );

        btnLogin.addActionListener(this);

        add(btnLogin);

        setVisible(true);
    }

    @Override
    public void actionPerformed(
            ActionEvent e
    ) {

        String username =
                txtUser.getText();

        String password =
                String.valueOf(
                        txtPass.getPassword()
                );

        AuthService auth =
                new AuthService();

        boolean login =
                auth.login(
                        username,
                        password
                );

        if (login) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login Successful"
            );

            dispose();

            new Dashboard();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Credentials"
            );
        }
    }
}