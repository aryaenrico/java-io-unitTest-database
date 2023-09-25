
package arya.enrico.recapiounitTestservlet;

import arya.enrico.recapiounitTestservlet.connection.Connections;
import arya.enrico.recapiounitTestservlet.model.Todo;
import arya.enrico.recapiounitTestservlet.repository.RepositoryImpl;
import arya.enrico.recapiounitTestservlet.service.TodoListImpl;
import org.junit.jupiter.api.*;
import org.springframework.test.context.jdbc.Sql;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoListTest {
    TodoListImpl todoList;
    Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        connection = Connections.getConnection();
        RepositoryImpl repository = new RepositoryImpl(connection);
        todoList = new TodoListImpl(repository);
    }

    @AfterEach
    void tearDown() {
        try {
            connection.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

    }

    @Test
    @DisplayName("test when add todo list")
    public void addTodo() {
        var data = todoList.addTodo("arya");
        Assertions.assertNotNull(data.getId());
        Assertions.assertNotEquals(0, data.getId());
        Assertions.assertNotNull(data.getTodo());
    }

    @Test
    @DisplayName("add empty todo list")
    public void addTodo1() {

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            var data = todoList.addTodo(null);
        });
    }



    @Test
    @DisplayName("test get all todoList")
    public void getAllTodo() {
        List<Todo> todos = new ArrayList<>();
        todos = todoList.getAllTodo();
        Assertions.assertNotNull(todos);
        Assertions.assertNotEquals(0, todos.size());
    }

    @Test
    @DisplayName("test get all todo when data is emtpy")
    public void getAllTodo1() {
        List<Todo> todos = new ArrayList<>();
        todos = todoList.getAllTodo();
        Assertions.assertEquals(0, todos.size());
    }

    @Test
    @DisplayName("when delete todo that doesnt exist ")
    public void deleteTodo(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            todoList.delete(1000);
        });
    }

    @Test
    @DisplayName("success delete todo")
    public void deleteTodo1(){
       Assertions.assertEquals(1,todoList.delete(12));
    }

    @Test
    @DisplayName("failed when update todo")
    public void updateTodo(){
        String todo = "kerjaan baru";

       Assertions.assertThrows(IllegalArgumentException.class,()->{
           todoList.update(14,todo);
       });
    }

    @Test
    @DisplayName("success update todo")
    public void updateTodo1(){
        String todo = "kerjaan baru";
        Todo dump = new Todo(13,todo);
        Todo actual =todoList.update(13,todo);
        Assertions.assertEquals(dump.getTodo() ,actual.getTodo());
        Assertions.assertEquals(dump.getId() ,actual.getId());
    }

    @Test
    @DisplayName("add todo with batch ")
    public void addTodoWithBatch(){
        Path path = Path.of("src/main/resources/todo.txt");
        System.out.println(path.getParent());
        var result = todoList.batchTodo(path);
        Assertions.assertNotEquals(0,result);
        Assertions.assertEquals(3,result);
    }



}
