
package arya.enrico.recapiounitTestservlet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoListTest {
    TodoListImpl todoList ;
    @BeforeEach
    void setUp() {
        todoList = new TodoListImpl();
    }

    @Test
    public void addTodo(){
        var data = todoList.addTodo("arya");
        Assertions.assertNotNull(data.getId());
        Assertions.assertNotNull(data.getTodo());
    }
}
