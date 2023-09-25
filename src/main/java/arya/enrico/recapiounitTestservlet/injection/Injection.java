package arya.enrico.recapiounitTestservlet.injection;


import arya.enrico.recapiounitTestservlet.connection.Connections;
import arya.enrico.recapiounitTestservlet.repository.Repository;
import arya.enrico.recapiounitTestservlet.repository.RepositoryImpl;


import java.sql.SQLException;

public class Injection {
    private  static RepositoryImpl repository;
    public static Repository createTodo(){
        try{
            repository = new RepositoryImpl(Connections.getConnection());
        } catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return repository;

    }


}
