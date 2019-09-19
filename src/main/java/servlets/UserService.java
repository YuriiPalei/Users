package servlets;

import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private String userName = "root";
    private String password = "781245";
    private String connectionUrl = "jdbc:mysql://localhost:3306/Users";

    public UserService() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection con = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = con.createStatement()) {
            statement.executeUpdate("create table if not exists Users(id mediumint not null auto_increment, " +
                                            "name VARCHAR(30) not null, age tinyint not null, primary key(id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAllUsers() throws ClassNotFoundException {
        List<User> userList = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection con = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery("select * from Users");
            while (rs.next()) {
                User user = new User(rs.getString("name"), rs.getInt("age"));
                user.setId(rs.getInt("id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public User findUser(int id) throws ClassNotFoundException {
        User user = null;
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection con = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery("select * from Users where id = '" + id + "'");
            while (rs.next()) {
                user = new User(rs.getString("name"), rs.getInt("age"));
                user.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void saveUser(User u) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection con = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = con.createStatement()) {
            statement.executeUpdate("insert into Users set id = '" + u.getId() + "', name = '" + u.getName() +
                                                                                "', age = '" + u.getAge() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User u) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection con = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = con.createStatement()) {
            statement.executeUpdate("update Users set name = '" + u.getName() + "', age = '" + u.getAge() +
                                                                                "' where id = '" + u.getId() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User u) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection con = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = con.createStatement()) {
            statement.executeUpdate("delete from Users where id = '" + u.getId() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
