package com.milo.Library.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    public boolean isUserLogged(HttpSession session) {
        if (session.getAttribute("isLogged") != null) {
            return (boolean) session.getAttribute("isLogged");
        } else {
            return false;
        }
    }
}
