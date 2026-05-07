package ui;

import dao.SessionDAO;
import model.Session;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class SessionPanel extends JPanel {

    JTextField txtPatientId;

    JTextField txtTherapistId;

    JTextField txtDate;

    JTextField txtTime;

    JComboBox<String> statusBox;

    JButton btnSave;

    JTable table;

    DefaultTableModel model;

    public SessionPanel() {

        setLayout(null);

        JLabel heading =
                new JLabel(
                        "Session Management"
                );

        heading.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        heading.setBounds(
                330,
                20,
                400,
                40
        );

        add(heading);

        // PATIENT ID

        JLabel lblPatient =
                new JLabel(
                        "Patient ID"
                );

        lblPatient.setBounds(
                50,
                100,
                100,
                30
        );

        add(lblPatient);

        txtPatientId =
                new JTextField();

        txtPatientId.setBounds(
                180,
                100,
                200,
                30
        );

        add(txtPatientId);

        // THERAPIST ID

        JLabel lblTherapist =
                new JLabel(
                        "Therapist ID"
                );

        lblTherapist.setBounds(
                50,
                150,
                100,
                30
        );

        add(lblTherapist);

        txtTherapistId =
                new JTextField();

        txtTherapistId.setBounds(
                180,
                150,
                200,
                30
        );

        add(txtTherapistId);

        // DATE

        JLabel lblDate =
                new JLabel(
                        "Session Date"
                );

        lblDate.setBounds(
                50,
                200,
                100,
                30
        );

        add(lblDate);

        txtDate =
                new JTextField();

        txtDate.setBounds(
                180,
                200,
                200,
                30
        );

        add(txtDate);

        // TIME

        JLabel lblTime =
                new JLabel(
                        "Session Time"
                );

        lblTime.setBounds(
                50,
                250,
                100,
                30
        );

        add(lblTime);

        txtTime =
                new JTextField();

        txtTime.setBounds(
                180,
                250,
                200,
                30
        );

        add(txtTime);

        // STATUS

        JLabel lblStatus =
                new JLabel("Status");

        lblStatus.setBounds(
                50,
                300,
                100,
                30
        );

        add(lblStatus);

        statusBox =
                new JComboBox<>(
                        new String[]{
                                "Pending",
                                "Completed",
                                "Cancelled"
                        }
                );

        statusBox.setBounds(
                180,
                300,
                200,
                30
        );

        add(statusBox);

        // BUTTON

        btnSave =
                new JButton(
                        "Book Session"
                );

        btnSave.setBounds(
                180,
                380,
                200,
                40
        );

        add(btnSave);

        // TABLE

        model =
                new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Patient ID");
        model.addColumn("Therapist ID");
        model.addColumn("Date");
        model.addColumn("Time");
        model.addColumn("Status");

        table =
                new JTable(model);

        JScrollPane pane =
                new JScrollPane(table);

        pane.setBounds(
                450,
                100,
                520,
                350
        );

        add(pane);

        loadSessions();

        // BUTTON ACTION

        btnSave.addActionListener(e -> {

            Session session =
                    new Session(
                            Integer.parseInt(
                                    txtPatientId.getText()
                            ),

                            Integer.parseInt(
                                    txtTherapistId.getText()
                            ),

                            txtDate.getText(),

                            txtTime.getText(),

                            statusBox
                                    .getSelectedItem()
                                    .toString()
                    );

            SessionDAO dao =
                    new SessionDAO();

            boolean saved =
                    dao.addSession(
                            session
                    );

            if (saved) {

                JOptionPane.showMessageDialog(
                        this,
                        "Session Booked"
                );

                clearFields();

                loadSessions();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Error"
                );
            }
        });
    }

    // LOAD DATA

    private void loadSessions() {

        model.setRowCount(0);

        SessionDAO dao =
                new SessionDAO();

        ArrayList<Session> list =
                dao.getAllSessions();

        for (Session s : list) {

            model.addRow(
                    new Object[]{
                            s.getId(),
                            s.getPatientId(),
                            s.getTherapistId(),
                            s.getSessionDate(),
                            s.getSessionTime(),
                            s.getStatus()
                    }
            );
        }
    }

    // CLEAR FIELDS

    private void clearFields() {

        txtPatientId.setText("");

        txtTherapistId.setText("");

        txtDate.setText("");

        txtTime.setText("");
    }
}