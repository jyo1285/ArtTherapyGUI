package dao;

import database.DBConnection;
import model.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    // GET ALL SESSIONS

    public ArrayList<Session>
    getAllSessions() {

        ArrayList<Session> list =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM sessions";

            PreparedStatement pst =
                    con.prepareStatement(query);

            ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                Session s =
                        new Session();

                s.setId(
                        rs.getInt("id")
                );

                s.setPatientId(
                        rs.getInt(
                                "patient_id"
                        )
                );

                s.setTherapistId(
                        rs.getInt(
                                "therapist_id"
                        )
                );

                s.setSessionDate(
                        rs.getString(
                                "session_date"
                        )
                );

                s.setSessionTime(
                        rs.getString(
                                "session_time"
                        )
                );

                s.setStatus(
                        rs.getString(
                                "status"
                        )
                );

                list.add(s);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}