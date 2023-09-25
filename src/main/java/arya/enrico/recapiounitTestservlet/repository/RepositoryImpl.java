package arya.enrico.recapiounitTestservlet.repository;

import arya.enrico.recapiounitTestservlet.model.Todo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {
    private Connection connection;


    public RepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Todo> getAllTodo() {
        String sql = "SELECT * FROM todo";
        List<Todo> todos = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                todos.add(new Todo(result.getInt(1), result.getString(2)));
            }


            connection.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return todos;
    }

    @Override
    public Todo updateTodo(int id, String todo) {
        Todo result = new Todo();
        String sql = "UPDATE todo set list_todo = ?  WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, todo);
            statement.setInt(2, id);
            statement.executeUpdate();
            result = check(id);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return result;

    }

    @Override
    public int deleteTodo(int id) {
        String sql = "DELETE FROM todo WHERE todo.id = ?";
        int result = 0;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            result = statement.executeUpdate();


        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return result;

    }

    @Override
    public int createTodo(String todo) {
        String sql = "INSERT INTO todo (list_todo) value (?)";
        int result = 0;

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, todo);
            statement.executeUpdate();
            var resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return result;


    }

    @Override
    public Todo check(int id) {
        Todo result = new Todo();
        String sql = "SELECT id,list_todo FROM todo WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result.setId(resultSet.getInt(1));
                result.setTodo(resultSet.getString(2));
            }

        } catch (SQLException excetion) {
            System.out.println(excetion.getMessage());
        }
        return result;
    }

    public int prosesBacth(Path file) {

        String sql = "INSERT INTO todo (list_todo) value (?) ";
        String todo;
        int[] temp;
        int result=0;
        try (BufferedReader reader = Files.newBufferedReader(file);
            PreparedStatement statement  = connection.prepareStatement(sql)
        ) {
            while ((todo = reader.readLine())!= null){
                statement.clearParameters();
                statement.setString(1,todo);
                statement.addBatch();
            }

            temp = statement.executeBatch();
            result = temp.length;


        } catch (IOException | SQLException  e) {
            System.out.println(e.getMessage());
        }
        return result;

    }
}
