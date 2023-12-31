package arya.enrico.recapiounitTestservlet.service;

import arya.enrico.recapiounitTestservlet.model.Todo;

import java.nio.file.Path;
import java.util.List;

public interface TodoList {
    Todo addTodo(String todo);
    List<Todo> getAllTodo();
    int delete(int id);
    Todo update(int id ,String todo);
    Todo check(int id);
    int batchTodo(Path file);

}
