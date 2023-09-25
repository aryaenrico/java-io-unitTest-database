package arya.enrico.recapiounitTestservlet.model;

public class Todo {
    private int id;
    private String todo;
    public Todo(){

    }
    public Todo(String todo){
        this.todo = todo;
    }

    public Todo(int id, String todo){
        this.id =id;
        this.todo = todo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }



}
