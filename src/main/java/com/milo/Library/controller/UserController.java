package com.milo.Library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/signup")
    public String signup() {
        return "registerForm";
    }

    @PostMapping("/Register")
    public String register() {
        return "Register";
    }

    @GetMapping("/register/fail")
    public String registerFail() {
        return "registrationFail";
    }

    @GetMapping("/signin")
    public String signin() {
        return "loginForm";
    }

    @GetMapping("/showAll")
    public String showUsers() {
        return "allUsers";
    }

    @PostMapping("/Login")
    public String login() {
        return "Login";
    }

    @PostMapping("/Logout")
    public String logout() {
        return "Logout";
    }

}
