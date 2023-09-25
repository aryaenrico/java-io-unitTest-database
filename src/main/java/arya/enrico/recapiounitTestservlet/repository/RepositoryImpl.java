package arya.enrico.recapiounitTestservlet.repository;

import arya.enrico.recapiounitTestservlet.model.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RepositoryImpl implements Repository{
    private Connection connection;
    public RepositoryImpl(Connection connection){
        this.connection =connection;
    }
    @Override
    public List<Todo> getAllTodo() {
        return null;
    }

    @Override
    public Todo updateTodo(int id, String todo) {
        return null;
    }

    @Override
    public int deleteTodo(int id) {
        return 0;
    }

    @Override
    public int createTodo(String todo)  {
        String sql ="INSERT INTO todo (list_todo) value (?)";
        int result=0;

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,todo);
            statement.executeUpdate();
            var resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
               result = resultSet.getInt(1);
            }

        }catch (SQLException exception){
            System.out.println(exception.getMessage());
        }

        return  result;



    }
}
