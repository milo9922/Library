package com.milo.Library.repository;

import com.milo.Library.entity.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class UserDao {

    int x;

    public void registerUser(User user) {
        try {
            String url = "jdbc:mysql://remotemysql.com:3306/3Q84ulcsc7";
            String dbUsername = "3Q84ulcsc7";
            Connection conn = DriverManager.getConnection(url, dbUsername, "zumqXjeFMY");
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
            String url = "jdbc:mysql://remotemysql.com:3306/3Q84ulcsc7";
            String dbUsername = "3Q84ulcsc7";
            Connection conn = DriverManager.getConnection(url, dbUsername, "zumqXjeFMY");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TB_USER");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String usernameDb = rs.getString("Login");
                String emailDb = rs.getString("Email");
                if (user.getUsername().equals(usernameDb) || user.getEmail().equals(emailDb)) {
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
            String url = "jdbc:mysql://remotemysql.com:3306/3Q84ulcsc7";
            String dbUsername = "3Q84ulcsc7";
            Connection conn = DriverManager.getConnection(url, dbUsername, "zumqXjeFMY");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TB_USER");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String usernameDb = rs.getString("Login");
                String passwordDb = rs.getString("Password");
                if (login.equals(usernameDb) && BCrypt.hashpw(password, BCrypt.gensalt()).equals(passwordDb)) {
                    return true;
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
