package com.milo.Library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/signup")
    public String signup() {
        return "registerForm";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/register/fail")
    public String registerFail() {
        return "registrationFail";
    }

    @RequestMapping("/signin")
    public String login() {
        return "loginForm";
    }

    @RequestMapping("/showAll")
    public String showUsers() {
        return "allUsers";
    }
}
