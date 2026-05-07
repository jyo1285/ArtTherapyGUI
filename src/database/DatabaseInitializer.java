package database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS users(" +
                            "id INT PRIMARY KEY AUTO_INCREMENT," +
                            "username VARCHAR(100)," +
                            "password VARCHAR(100)," +
                            "role VARCHAR(50))"
            );

            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS patients(" +
                            "id INT PRIMARY KEY AUTO_INCREMENT," +
                            "name VARCHAR(100)," +
                            "age INT," +
                            "gender VARCHAR(20)," +
                            "contact VARCHAR(20)," +
                            "diagnosis TEXT)"
            );

            System.out.println(
                    "Tables Created Successfully"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}