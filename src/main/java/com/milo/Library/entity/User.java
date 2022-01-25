package com.milo.Library.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "TB_USER")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @NotEmpty
    private String login;
    @NotEmpty
    private String password;
    @Email
    @NotEmpty
    private String email;
    private boolean isAdmin;

    public User(String login, String email, String password, boolean isAdmin) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(int userId, String login, String email) {
        this.userId = userId;
        this.login = login;
        this.email = email;
    }

    public User() {
    }
}
