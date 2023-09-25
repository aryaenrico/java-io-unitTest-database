package arya.enrico.recapiounitTestservlet;

import arya.enrico.recapiounitTestservlet.connection.Connections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ConnectionTest {
    @Test
    @DisplayName("success create a connection to database")
    public void createConnection() throws SQLException {

        Assertions.assertThrows(SQLException.class,()->{
            Connections.getConnection();
        });

    }
}
