
package dao;

import database.DBConnection;
import model.Therapist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    // VIEW ALL THERAPISTS

    public void viewTherapists() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM therapists";

            PreparedStatement pst =
                    con.prepareStatement(query);

            ResultSet rs =
                    pst.executeQuery();

            System.out.println(
                    "\n===== THERAPIST LIST =====\n"
            );

            while (rs.next()) {

                System.out.println(

                        "ID: " +
                        rs.getInt("id") +

                        " | Name: " +
                        rs.getString("name") +

                        " | Specialization: " +
                        rs.getString(
                                "specialization"
                        ) +

                        " | Experience: " +
                        rs.getInt(
                                "experience"
                        ) + " Years" +

                        " | Contact: " +
                        rs.getString(
                                "contact"
                        )
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // DELETE THERAPIST

    public boolean deleteTherapist(
            int id
    ) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "DELETE FROM therapists WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1, id);

            int rows =
                    pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // UPDATE THERAPIST

    public boolean updateTherapist(
            Therapist therapist
    ) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "UPDATE therapists SET " +
                    "name=?,specialization=?," +
                    "experience=?,contact=? " +
                    "WHERE id=?";

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

            pst.setInt(
                    5,
                    therapist.getId()
            );

            int rows =
                    pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}
