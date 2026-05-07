package ui;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    JPanel contentPanel;

    public Dashboard() {

        setTitle("MindCanvas Dashboard");

        setSize(1400, 800);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // SIDEBAR

        JPanel sidebar = new JPanel();

        sidebar.setPreferredSize(
                new Dimension(240, 800)
        );

        sidebar.setBackground(
                new Color(20, 20, 40)
        );

        sidebar.setLayout(
                new GridLayout(10, 1, 10, 20)
        );

        // TITLE

        JLabel logo = new JLabel(
                "MindCanvas",
                SwingConstants.CENTER
        );

        logo.setForeground(Color.WHITE);

        logo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        sidebar.add(logo);

        // BUTTONS

        JButton btnDashboard =
                createButton("Dashboard");

        JButton btnPatients =
                createButton("Patients");

        JButton btnTherapists =
                createButton("Therapists");

        JButton btnSessions =
                createButton("Sessions");

        JButton btnLogout =
                createButton("Logout");

        sidebar.add(btnDashboard);
        sidebar.add(btnPatients);
        sidebar.add(btnTherapists);
        sidebar.add(btnSessions);
        sidebar.add(btnLogout);

        add(sidebar, BorderLayout.WEST);

        // MAIN PANEL

        contentPanel = new JPanel();

        contentPanel.setBackground(
                new Color(245, 245, 245)
        );

        contentPanel.setLayout(
                new GridLayout(2, 2, 30, 30)
        );

        showDashboardCards();

        add(contentPanel, BorderLayout.CENTER);

        // DASHBOARD BUTTON

        btnDashboard.addActionListener(e -> {

            contentPanel.removeAll();

            contentPanel.setLayout(
                    new GridLayout(2, 2, 30, 30)
            );

            showDashboardCards();

            contentPanel.revalidate();

            contentPanel.repaint();
        });

        // PATIENT BUTTON

        btnPatients.addActionListener(e -> {

            contentPanel.removeAll();

            contentPanel.setLayout(
                    new BorderLayout()
            );

            contentPanel.add(
                    new PatientPanel()
            );

            contentPanel.revalidate();

            contentPanel.repaint();
        });

        // THERAPIST BUTTON

        btnTherapists.addActionListener(e -> {

            contentPanel.removeAll();

            contentPanel.setLayout(
                    new BorderLayout()
            );

            contentPanel.add(
                    new TherapistPanel()
            );

            contentPanel.revalidate();

            contentPanel.repaint();
        });

        // SESSION BUTTON

        btnSessions.addActionListener(e -> {

            contentPanel.removeAll();

            contentPanel.setLayout(
                    new BorderLayout()
            );

            contentPanel.add(
                    new SessionPanel()
            );

            contentPanel.revalidate();

            contentPanel.repaint();
        });

        // LOGOUT

        btnLogout.addActionListener(e -> {

            dispose();

            new LoginPage();
        });

        setVisible(true);
    }

    // DASHBOARD CARDS

    private void showDashboardCards() {

        contentPanel.add(
                createCard(
                        "Patients",
                        "120"
                )
        );

        contentPanel.add(
                createCard(
                        "Therapists",
                        "15"
                )
        );

        contentPanel.add(
                createCard(
                        "Sessions",
                        "55"
                )
        );

        contentPanel.add(
                createCard(
                        "Revenue",
                        "₹50000"
                )
        );
    }

    // SIDEBAR BUTTON DESIGN

    private JButton createButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setFocusPainted(false);

        button.setBackground(
                new Color(45, 45, 70)
        );

        button.setForeground(Color.WHITE);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        return button;
    }

    // DASHBOARD CARD DESIGN

    private JPanel createCard(
            String title,
            String value
    ) {

        JPanel panel =
                new JPanel();

        panel.setBackground(Color.WHITE);

        panel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(220,220,220),
                        2
                )
        );

        panel.setLayout(
                new BorderLayout()
        );

        JLabel lblTitle =
                new JLabel(
                        title,
                        SwingConstants.CENTER
                );

        lblTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );

        JLabel lblValue =
                new JLabel(
                        value,
                        SwingConstants.CENTER
                );

        lblValue.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        40
                )
        );

        lblValue.setForeground(
                new Color(70,130,180)
        );

        panel.add(
                lblTitle,
                BorderLayout.NORTH
        );

        panel.add(
                lblValue,
                BorderLayout.CENTER
        );

        return panel;
    }
}