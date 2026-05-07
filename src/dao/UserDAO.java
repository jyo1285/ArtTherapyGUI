package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;

public class UserDAO {

    public boolean login(
            String username,
            String password
    ) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM users " +
                    "WHERE username=? AND password=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, username);

            pst.setString(2, password);

            ResultSet rs =
                    pst.executeQuery();

            return rs.next();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}