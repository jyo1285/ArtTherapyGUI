package dao;

import database.DBConnection;
import model.Therapist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TherapistDAO {

    // ADD THERAPIST

    public boolean addTherapist(
            Therapist therapist
    ) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO therapists" +
                    "(name,specialization,experience,contact)" +
                    "VALUES(?,?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(
                    1,
                    therapist.getName()
            );

            pst.setString(
                    2,
                    therapist.getSpecialization()
            );

            pst.setInt(
                    3,
                    therapist.getExperience()
            );

            pst.setString(
                    4,
                    therapist.getContact()
            );

            int rows =
                    pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // GET ALL THERAPISTS

    public ArrayList<Therapist>
    getAllTherapists() {

        ArrayList<Therapist> list =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM therapists";

            PreparedStatement pst =
                    con.prepareStatement(query);

            ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                Therapist t =
                        new Therapist();

                t.setId(
                        rs.getInt("id")
                );

                t.setName(
                        rs.getString("name")
                );

                t.setSpecialization(
                        rs.getString(
                                "specialization"
                        )
                );

                t.setExperience(
                        rs.getInt(
                                "experience"
                        )
                );

                t.setContact(
                        rs.getString(
                                "contact"
                        )
                );

                list.add(t);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}