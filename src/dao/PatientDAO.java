package dao;

import database.DBConnection;
import model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PatientDAO {

    // ADD PATIENT

    public boolean addPatient(
            Patient patient
    ) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO patients" +
                    "(name,age,gender,contact,diagnosis)" +
                    "VALUES(?,?,?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(
                    1,
                    patient.getName()
            );

            pst.setInt(
                    2,
                    patient.getAge()
            );

            pst.setString(
                    3,
                    patient.getGender()
            );

            pst.setString(
                    4,
                    patient.getContact()
            );

            pst.setString(
                    5,
                    patient.getDiagnosis()
            );

            int rows =
                    pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // GET ALL PATIENTS

    public ArrayList<Patient> getAllPatients() {

        ArrayList<Patient> list =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM patients";

            PreparedStatement pst =
                    con.prepareStatement(query);

            ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                Patient p =
                        new Patient();

                p.setId(
                        rs.getInt("id")
                );

                p.setName(
                        rs.getString("name")
                );

                p.setAge(
                        rs.getInt("age")
                );

                p.setGender(
                        rs.getString("gender")
                );

                p.setContact(
                        rs.getString("contact")
                );

                p.setDiagnosis(
                        rs.getString("diagnosis")
                );

                list.add(p);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}