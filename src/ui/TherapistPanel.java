package ui;

import dao.TherapistDAO;
import model.Therapist;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TherapistPanel extends JPanel {

    JTextField txtName;
    JTextField txtSpecialization;
    JTextField txtExperience;
    JTextField txtContact;

    JButton btnSave;

    JTable table;

    DefaultTableModel model;

    public TherapistPanel() {

        setPreferredSize(
                new Dimension(1100, 700)
        );

        setLayout(null);

        // HEADING

        JLabel heading =
                new JLabel(
                        "Therapist Management"
                );

        heading.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
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
                120,
                30
        );

        add(lblName);

        txtName =
                new JTextField();

        txtName.setBounds(
                180,
                100,
                220,
                35
        );

        add(txtName);

        // SPECIALIZATION

        JLabel lblSpecialization =
                new JLabel(
                        "Specialization"
                );

        lblSpecialization.setBounds(
                50,
                160,
                120,
                30
        );

        add(lblSpecialization);

        txtSpecialization =
                new JTextField();

        txtSpecialization.setBounds(
                180,
                160,
                220,
                35
        );

        add(txtSpecialization);

        // EXPERIENCE

        JLabel lblExperience =
                new JLabel(
                        "Experience"
                );

        lblExperience.setBounds(
                50,
                220,
                120,
                30
        );

        add(lblExperience);

        txtExperience =
                new JTextField();

        txtExperience.setBounds(
                180,
                220,
                220,
                35
        );

        add(txtExperience);

        // CONTACT

        JLabel lblContact =
                new JLabel("Contact");

        lblContact.setBounds(
                50,
                280,
                120,
                30
        );

        add(lblContact);

        txtContact =
                new JTextField();

        txtContact.setBounds(
                180,
                280,
                220,
                35
        );

        add(txtContact);

        // BUTTON

        btnSave =
                new JButton(
                        "Add Therapist"
                );

        btnSave.setBounds(
                180,
                360,
                220,
                45
        );

        btnSave.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        add(btnSave);

        // TABLE

        model =
                new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Specialization");
        model.addColumn("Experience");
        model.addColumn("Contact");

        table =
                new JTable(model);

        table.setRowHeight(25);

        JScrollPane pane =
                new JScrollPane(table);

        pane.setBounds(
                460,
                100,
                580,
                400
        );

        add(pane);

        loadTherapists();

        // BUTTON ACTION

        btnSave.addActionListener(e -> {

            try {

                String name =
                        txtName.getText().trim();

                String specialization =
                        txtSpecialization
                                .getText()
                                .trim();

                String expText =
                        txtExperience
                                .getText()
                                .trim();

                String contact =
                        txtContact
                                .getText()
                                .trim();

                // VALIDATION

                if (name.isEmpty()
                        || specialization.isEmpty()
                        || expText.isEmpty()
                        || contact.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Fill all fields"
                    );

                    return;
                }

                int experience =
                        Integer.parseInt(expText);

                Therapist therapist =
                        new Therapist(
                                name,
                                specialization,
                                experience,
                                contact
                        );

                TherapistDAO dao =
                        new TherapistDAO();

                boolean saved =
                        dao.addTherapist(
                                therapist
                        );

                if (saved) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Therapist Added Successfully"
                    );

                    clearFields();

                    loadTherapists();

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Database Error"
                    );
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Experience must be number"
                );

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Error: " + ex.getMessage()
                );
            }
        });
    }

    // LOAD DATA

    private void loadTherapists() {

        model.setRowCount(0);

        TherapistDAO dao =
                new TherapistDAO();

        ArrayList<Therapist> list =
                dao.getAllTherapists();

        for (Therapist t : list) {

            model.addRow(
                    new Object[]{
                            t.getId(),
                            t.getName(),
                            t.getSpecialization(),
                            t.getExperience(),
                            t.getContact()
                    }
            );
        }
    }

    // CLEAR FIELDS

    private void clearFields() {

        txtName.setText("");

        txtSpecialization.setText("");

        txtExperience.setText("");

        txtContact.setText("");
    }
}