package arya.enrico.recapiounitTestservlet.repository;

import arya.enrico.recapiounitTestservlet.model.Todo;

import java.nio.file.Path;
import java.util.List;

public interface Repository {
    List<Todo> getAllTodo();
    Todo updateTodo(int id, String todo);
    int deleteTodo(int id);
    int createTodo(String todo);
    Todo check(int id);
    int prosesBacth(Path file);
}
