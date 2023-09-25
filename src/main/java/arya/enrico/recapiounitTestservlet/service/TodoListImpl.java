package arya.enrico.recapiounitTestservlet.service;

import arya.enrico.recapiounitTestservlet.model.Todo;
import arya.enrico.recapiounitTestservlet.repository.Repository;

import java.util.List;

public class TodoListImpl implements TodoList {
    private Repository repository;

    public TodoListImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Todo addTodo(String todo) {
        if (todo == null) {
            throw new IllegalArgumentException("Todo tidak noleh kosong ");
        }
        var id = repository.createTodo(todo);
        return new Todo(id, todo);
    }

    @Override
    public List<Todo> getAllTodo() {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public Todo update(int id, String todo) {
        return null;
    }
}
