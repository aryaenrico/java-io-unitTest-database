package arya.enrico.recapiounitTestservlet.service;

import arya.enrico.recapiounitTestservlet.model.Todo;

import java.util.List;

public interface TodoList {
    Todo addTodo(String todo);
    List<Todo> getAllTodo();
    String delete(int id);
    Todo update(int id ,String todo);

}
