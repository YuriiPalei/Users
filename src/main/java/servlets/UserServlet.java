package servlets;

import models.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/")
public class UserServlet extends HttpServlet {
    private UserService service;
    {
        try {
            service = new UserService();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = null;
        try {
            users = service.findAllUsers();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        req.setAttribute("users", users);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/userList.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));

        User user;
        try {
            user = new User(name, age);
            service.saveUser(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/users");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        User user = null;
        try {
            user = service.findUser(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        user.setName(req.getParameter("name"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        try {
            service.updateUser(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/users");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        try {
            service.deleteUser(service.findUser(id));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/CrudApp_war/users");
    }
}
