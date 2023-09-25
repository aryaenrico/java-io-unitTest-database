
package arya.enrico.recapiounitTestservlet;
import arya.enrico.recapiounitTestservlet.connection.Connections;
import arya.enrico.recapiounitTestservlet.repository.RepositoryImpl;
import arya.enrico.recapiounitTestservlet.service.TodoListImpl;
import org.junit.jupiter.api.*;
import org.springframework.test.context.jdbc.Sql;

import java.sql.Connection;
import java.sql.SQLException;

public class TodoListTest {
    TodoListImpl todoList ;
    Connection connection;
    @BeforeEach
    void setUp() throws SQLException {
        connection = Connections.getConnection();
        RepositoryImpl repository = new RepositoryImpl(connection);
        todoList = new TodoListImpl(repository);
    }
    @AfterEach
    void tearDown(){
        try {
            connection.close();
        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }

    }

    @Test
    @DisplayName("test when add todo list")
    public void addTodo(){
        var data = todoList.addTodo("arya");
        Assertions.assertNotNull(data.getId());
        Assertions.assertNotEquals(0,data.getId());
        Assertions.assertNotNull(data.getTodo());
    }
}
