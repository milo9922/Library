package com.milo.Library.servlet;

import com.milo.Library.repository.UserDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/", name = "Login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        login(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        login(request, response);
    }

    private static void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDao userDao = new UserDao();
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");
        HttpSession session = request.getSession();

        if (userDao.checkLoginAndPassword(uname, pass)) {
            session.setAttribute("loginError", false);
            session.setAttribute("isLogged", true);
            session.setAttribute("user", uname);
            response.sendRedirect("/");
        } else {
            session.setAttribute("loginError", true);
            session.setAttribute("isLogged", false);
            response.sendRedirect("/user/signin");
        }
    }
}
