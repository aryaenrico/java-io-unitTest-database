package arya.enrico.recapiounitTestservlet;

import arya.enrico.recapiounitTestservlet.model.Todo;

import java.util.List;

public class TodoListImpl implements TodoList{

    @Override
    public Todo addTodo(String todo) {
        Todo result = new Todo(1,todo);
        return result;
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
