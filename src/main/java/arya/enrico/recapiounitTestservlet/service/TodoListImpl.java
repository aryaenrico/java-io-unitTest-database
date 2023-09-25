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
        if (todo == null || todo.isBlank() || todo.isEmpty()) {
            throw new IllegalArgumentException("Todo tidak noleh kosong ");
        }
        var id = repository.createTodo(todo);
        return new Todo(id, todo);
    }

    @Override
    public List<Todo> getAllTodo() {

        return repository.getAllTodo();

    }

    @Override
    public int delete(int id) {
        Todo todo = check(id);
        if (todo.getTodo() ==  null){
            throw new IllegalArgumentException("data tersebut tidak ada");
        }else{
           return  repository.deleteTodo(id);
        }
    }

    @Override
    public Todo update(int id, String todo) {
        Todo result = check(id);
        if (result.getTodo() ==  null){
            throw new IllegalArgumentException("data tersebut tidak ada");
        }else{
            return repository.updateTodo(id,todo);
        }
    }

    @Override
    public Todo check(int id) {
       return  repository.check(id);


    }
}
