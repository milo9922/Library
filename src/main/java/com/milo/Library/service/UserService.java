package com.milo.Library.service;

import com.milo.Library.entity.User;
import com.milo.Library.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public boolean checkUsernameAndPassword(String username, String password) {
        return userDao.checkLoginAndPassword(username, password);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
