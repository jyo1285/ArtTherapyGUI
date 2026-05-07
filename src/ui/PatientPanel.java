package ui;

import dao.PatientDAO;
import model.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PatientPanel extends JPanel {

    JTextField txtName;
    JTextField txtAge;
    JTextField txtContact;

    JComboBox<String> genderBox;

    JTextArea txtDiagnosis;

    JButton btnSave;

    JTable table;

    DefaultTableModel model;

    public PatientPanel() {

        setLayout(null);

        JLabel heading =
                new JLabel("Patient Management");

        heading.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        heading.setBounds(
                350,
                20,
                400,
                40
        );

        add(heading);

        // NAME

        JLabel lblName =
                new JLabel("Name");

        lblName.setBounds(
                50,
                100,
                100,
                30
        );

        add(lblName);

        txtName =
                new JTextField();

        txtName.setBounds(
                150,
                100,
                200,
                30
        );

        add(txtName);

        // AGE

        JLabel lblAge =
                new JLabel("Age");

        lblAge.setBounds(
                50,
                150,
                100,
                30
        );

        add(lblAge);

        txtAge =
                new JTextField();

        txtAge.setBounds(
                150,
                150,
                200,
                30
        );

        add(txtAge);

        // CONTACT

        JLabel lblContact =
                new JLabel("Contact");

        lblContact.setBounds(
                50,
                200,
                100,
                30
        );

        add(lblContact);

        txtContact =
                new JTextField();

        txtContact.setBounds(
                150,
                200,
                200,
                30
        );

        add(txtContact);

        // GENDER

        JLabel lblGender =
                new JLabel("Gender");

        lblGender.setBounds(
                50,
                250,
                100,
                30
        );

        add(lblGender);

        genderBox =
                new JComboBox<>(
                        new String[]{
                                "Male",
                                "Female",
                                "Other"
                        }
                );

        genderBox.setBounds(
                150,
                250,
                200,
                30
        );

        add(genderBox);

        // DIAGNOSIS

        JLabel lblDiagnosis =
                new JLabel("Diagnosis");

        lblDiagnosis.setBounds(
                50,
                300,
                100,
                30
        );

        add(lblDiagnosis);

        txtDiagnosis =
                new JTextArea();

        JScrollPane diagnosisPane =
                new JScrollPane(
                        txtDiagnosis
                );

        diagnosisPane.setBounds(
                150,
                300,
                200,
                80
        );

        add(diagnosisPane);

        // BUTTON

        btnSave =
                new JButton(
                        "Add Patient"
                );

        btnSave.setBounds(
                150,
                420,
                200,
                40
        );

        add(btnSave);

        // TABLE

        model =
                new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Gender");
        model.addColumn("Contact");
        model.addColumn("Diagnosis");

        table =
                new JTable(model);

        JScrollPane tablePane =
                new JScrollPane(table);

        tablePane.setBounds(
                420,
                100,
                600,
                360
        );

        add(tablePane);

        loadPatients();

        // SAVE BUTTON ACTION

        btnSave.addActionListener(e -> {

            Patient patient =
                    new Patient(
                            txtName.getText(),
                            Integer.parseInt(
                                    txtAge.getText()
                            ),
                            genderBox
                                    .getSelectedItem()
                                    .toString(),
                            txtContact.getText(),
                            txtDiagnosis.getText()
                    );

            PatientDAO dao =
                    new PatientDAO();

            boolean saved =
                    dao.addPatient(patient);

            if (saved) {

                JOptionPane.showMessageDialog(
                        this,
                        "Patient Added"
                );

                clearFields();

                loadPatients();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Error"
                );
            }
        });
    }

    // LOAD TABLE

    private void loadPatients() {

        model.setRowCount(0);

        PatientDAO dao =
                new PatientDAO();

        ArrayList<Patient> list =
                dao.getAllPatients();

        for (Patient p : list) {

            model.addRow(
                    new Object[]{
                            p.getId(),
                            p.getName(),
                            p.getAge(),
                            p.getGender(),
                            p.getContact(),
                            p.getDiagnosis()
                    }
            );
        }
    }

    // CLEAR FIELDS

    private void clearFields() {

        txtName.setText("");
        txtAge.setText("");
        txtContact.setText("");
        txtDiagnosis.setText("");
    }
}