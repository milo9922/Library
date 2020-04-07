package com.milo.Library.service;

import com.milo.Library.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean checkIfUserIsLogged(HttpSession session) {
        if (session.getAttribute("isLogged") != null) {
            return (boolean) session.getAttribute("isLogged");
        } else {
            return false;
        }
    }
}
