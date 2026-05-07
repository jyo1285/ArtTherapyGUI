package dao;

import database.DBConnection;
import model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDAO {

    public boolean addPatient(
            Patient patient
    ) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO patients(name,age,gender,contact,diagnosis) VALUES(?,?,?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, patient.getName());
            pst.setInt(2, patient.getAge());
            pst.setString(3, patient.getGender());
            pst.setString(4, patient.getContact());
            pst.setString(5, patient.getDiagnosis());

            int rows =
                    pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    public void viewPatients() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM patients";

            PreparedStatement pst =
                    con.prepareStatement(query);

            ResultSet rs =
                    pst.executeQuery();

            System.out.println("\n===== PATIENT LIST =====\n");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("gender") + " | " +
                        rs.getString("contact") + " | " +
                        rs.getString("diagnosis")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}