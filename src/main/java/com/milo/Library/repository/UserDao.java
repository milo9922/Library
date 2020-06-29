package com.milo.Library.repository;

import com.milo.Library.entity.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional
public class UserDao extends DbConnection {

    private Connection conn;
    private int x;

    public void registerUser(User user) {
        try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO TB_USER(Login, Password, Email) VALUES (?,?,?)");
            ps.setString(1, user.getLogin());
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
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TB_USER");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String usernameDb = rs.getString("Login");
                String emailDb = rs.getString("Email");
                if (user.getLogin().equals(usernameDb) || user.getEmail().equals(emailDb)) {
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
            conn = getConnection();
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
            conn = getConnection();
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
            conn = getConnection();
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

    public String getUserNameById(int userId) {
        try {
            conn = getConnection();
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM TB_USER";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int userIdFromDb = rs.getInt("UserID");
                String login = rs.getString("Login");
                if (userId == userIdFromDb) {
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

    public boolean getIsUserAdmin(int userId) {
        try {
            conn = getConnection();
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM TB_USER";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int userIdFromDb = rs.getInt("UserID");
                boolean isAdmin = rs.getBoolean("IsAdmin");
                if (userId == userIdFromDb) {
                    conn.close();
                    return isAdmin;
                }
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
