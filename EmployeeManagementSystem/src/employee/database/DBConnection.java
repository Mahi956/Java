package employee.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/employee_db";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}