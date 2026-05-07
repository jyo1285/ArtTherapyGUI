
package dao;

import database.DBConnection;
import model.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SessionDAO {

    // ADD SESSION

    public boolean addSession(
            Session session
    ) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO sessions" +
                    "(patient_id,therapist_id," +
                    "session_date,session_time,status)" +
                    "VALUES(?,?,?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(
                    1,
                    session.getPatientId()
            );

            pst.setInt(
                    2,
                    session.getTherapistId()
            );

            pst.setString(
                    3,
                    session.getSessionDate()
            );

            pst.setString(
                    4,
                    session.getSessionTime()
            );

            pst.setString(
                    5,
                    session.getStatus()
            );

            int rows =
                    pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // VIEW ALL SESSIONS

    public void viewSessions() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM sessions";

            PreparedStatement pst =
                    con.prepareStatement(query);

            ResultSet rs =
                    pst.executeQuery();

            System.out.println(
                    "\n===== SESSION LIST =====\n"
            );

            while (rs.next()) {

                System.out.println(

                        "ID: " +
                        rs.getInt("id") +

                        " | Patient ID: " +
                        rs.getInt(
                                "patient_id"
                        ) +

                        " | Therapist ID: " +
                        rs.getInt(
                                "therapist_id"
                        ) +

                        " | Date: " +
                        rs.getString(
                                "session_date"
                        ) +

                        " | Time: " +
                        rs.getString(
                                "session_time"
                        ) +

                        " | Status: " +
                        rs.getString(
                                "status"
                        )
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // DELETE SESSION

    public boolean deleteSession(
            int id
    ) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "DELETE FROM sessions WHERE id=?";

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

    // UPDATE SESSION

    public boolean updateSession(
            Session session
    ) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "UPDATE sessions SET " +
                    "patient_id=?,therapist_id=?," +
                    "session_date=?,session_time=?," +
                    "status=? WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(
                    1,
                    session.getPatientId()
            );

            pst.setInt(
                    2,
                    session.getTherapistId()
            );

            pst.setString(
                    3,
                    session.getSessionDate()
            );

            pst.setString(
                    4,
                    session.getSessionTime()
            );

            pst.setString(
                    5,
                    session.getStatus()
            );

            pst.setInt(
                    6,
                    session.getId()
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