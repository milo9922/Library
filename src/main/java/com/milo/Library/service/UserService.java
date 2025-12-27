package com.milo.Library.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

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
