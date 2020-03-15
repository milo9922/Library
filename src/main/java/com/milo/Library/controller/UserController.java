package com.milo.Library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/registry")
    public String registry() {
        return "registerForm";
    }

    @RequestMapping("/login")
    public String login() {
        return "loginForm";
    }
}
