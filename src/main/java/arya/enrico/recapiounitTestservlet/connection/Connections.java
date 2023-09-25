package arya.enrico.recapiounitTestservlet.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
    private static Connection conn;

    static {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:80/java","root","arya");
        return conn;

    }
}
