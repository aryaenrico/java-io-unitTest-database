package arya.enrico.recapiounitTestservlet.web;

import arya.enrico.recapiounitTestservlet.injection.Injection;
import arya.enrico.recapiounitTestservlet.model.Todo;
import arya.enrico.recapiounitTestservlet.service.TodoList;
import arya.enrico.recapiounitTestservlet.service.TodoListImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/todo")
public class TodoWeb extends HttpServlet {
    TodoList todos = new TodoListImpl(Injection.createTodo());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String todo = req.getParameter("todo");

        Todo reeult = todos.addTodo(todo);
        resp.getWriter().println(reeult.getId() + "" + reeult.getTodo());
        resp.getWriter().println("berhsil dibuat");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (var data : todos.getAllTodo()) {
            resp.getWriter().println(data.getTodo());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            int result = todos.delete(id);
            if (result > 0) {
                resp.getWriter().println("Data berhasil Dihapus");
            } else {
                resp.getWriter().println("Data gagal dihapus");
            }
        } catch (NumberFormatException e) {
            resp.getWriter().println("Harap masukan data id dengan menggunakan format angka");
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String newTodo = req.getParameter("todo");
            Todo result = todos.update(id, newTodo);
            if (result.getTodo() != null) {
                resp.getWriter().println("Data berhasil Diubah");
            } else {
                resp.getWriter().println("Data gagal Diubah");
            }
        } catch (NumberFormatException exception) {
            resp.getWriter().println("Harap masukan data id dengan menggunakan format angka");
        }

    }

}
