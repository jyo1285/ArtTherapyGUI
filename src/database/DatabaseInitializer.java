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

            // USERS TABLE

            st.executeUpdate(

                    "CREATE TABLE IF NOT EXISTS users(" +

                            "id INT PRIMARY KEY AUTO_INCREMENT," +

                            "username VARCHAR(100)," +

                            "password VARCHAR(100)," +

                            "role VARCHAR(50))"
            );

            // PATIENTS TABLE

            st.executeUpdate(

                    "CREATE TABLE IF NOT EXISTS patients(" +

                            "id INT PRIMARY KEY AUTO_INCREMENT," +

                            "name VARCHAR(100)," +

                            "age INT," +

                            "gender VARCHAR(20)," +

                            "contact VARCHAR(20)," +

                            "diagnosis TEXT)"
            );

            // THERAPISTS TABLE

            st.executeUpdate(

                    "CREATE TABLE IF NOT EXISTS therapists(" +

                            "id INT PRIMARY KEY AUTO_INCREMENT," +

                            "name VARCHAR(100)," +

                            "specialization VARCHAR(100)," +

                            "experience INT," +

                            "contact VARCHAR(20))"
            );

            // SESSIONS TABLE

            st.executeUpdate(

                    "CREATE TABLE IF NOT EXISTS sessions(" +

                            "id INT PRIMARY KEY AUTO_INCREMENT," +

                            "patient_id INT," +

                            "therapist_id INT," +

                            "session_date VARCHAR(30)," +

                            "session_time VARCHAR(30)," +

                            "status VARCHAR(50))"
            );

            System.out.println(
                    "Database Initialized Successfully"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}