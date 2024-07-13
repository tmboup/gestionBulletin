package sn.oumar.gestionBulletin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/hospital_meet";
    private static final String USER = "talla";
    private static final String PASSWORD = "Passer123";

    private Connection connexion;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }



}
