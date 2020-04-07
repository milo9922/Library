package com.milo.Library.repository;

import com.milo.Library.entity.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UserDao {

    private final String DB_URL = "jdbc:mysql://remotemysql.com:3306/3Q84ulcsc7";
    private final String DB_USERNAME = "3Q84ulcsc7";
    int x;

    public void registerUser(User user) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, "zumqXjeFMY");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO TB_USER(Login, Password, Email) VALUES (?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            ps.setString(3, user.getEmail());
            setX(ps.executeUpdate());
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkIfUserIsNew(User user) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, "zumqXjeFMY");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TB_USER");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String usernameDb = rs.getString("Login");
                String emailDb = rs.getString("Email");
                if (user.getUsername().equals(usernameDb) || user.getEmail().equals(emailDb)) {
                    conn.close();
                    return false;
                }
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean checkLoginAndPassword(String login, String password) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, "zumqXjeFMY");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TB_USER");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String usernameDb = rs.getString("Login");
                String passwordDb = rs.getString("Password");
                if (login.equals(usernameDb) && BCrypt.checkpw(password, passwordDb)) {
                    conn.close();
                    return true;
                }
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> getAllUsers() {
        List<User> users = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, "zumqXjeFMY");
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM TB_USER";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int userId = rs.getInt("UserID");
                String login = rs.getString("Login");
                String email = rs.getString("Email");

                users.add(new User(userId, login, email));
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public int getUserIdByName(String username) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, "zumqXjeFMY");
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM TB_USER";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int userId = rs.getInt("UserID");
                String login = rs.getString("Login");
                if (login.equals(username)) {
                    conn.close();
                    return userId;
                }
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public String getUserNameById(int id) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, "zumqXjeFMY");
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM TB_USER";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int userId = rs.getInt("UserID");
                String login = rs.getString("Login");
                if (id == userId) {
                    conn.close();
                    return login;
                }
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
