package com.milo.Library.servlet;

import com.milo.Library.entity.User;
import com.milo.Library.repository.UserDao;
import com.milo.Library.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/user/", name = "Register")
public class Register extends HttpServlet {

    private static void register(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (!new UserService().isUserLogged(request.getSession())) {
                UserDao userDao = new UserDao();
                User user = new User(request.getParameter("username"), request.getParameter("email"), request.getParameter("password"), false);

                if (userDao.checkIfUserIsNew(user)) {
                    userDao.registerUser(user);
                    if (userDao.getX() > 0) {
                        response.sendRedirect("/user/signin");
                    } else {
                        response.sendRedirect("http://localhost:8081/user/register/fail");
                    }
                } else {
                    response.sendRedirect("http://localhost:8081/user/register/fail");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        register(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        register(request, response);
    }
}
