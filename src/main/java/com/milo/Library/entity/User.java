package com.milo.Library.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TB_USER")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String login;
    private String password;
    //FIXME validate email before saving in db (removed @Email annotation)
    private String email;
    private boolean isAdmin;

    public User() {
    }

    public User(int userId, String login, String email) {
        this.userId = userId;
        this.login = login;
        this.email = email;
    }

    public User(String login, String email, String password, boolean isAdmin) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

}
