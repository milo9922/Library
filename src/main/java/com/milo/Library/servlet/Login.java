package com.milo.Library.servlet;

import com.milo.Library.repository.UserDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/user/", name = "Login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname = request.getParameter("username");
        HttpSession session = request.getSession();

        if (isUserLogged(request)) {
            response.sendRedirect("/");
        } else {
            if (new UserDao().checkLoginAndPassword(uname, request.getParameter("password"))) {
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

    private static boolean isUserLogged(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session.getAttribute("isLogged") != null) {
            return (boolean) session.getAttribute("isLogged");
        } else {
            return false;
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        login(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        login(request, response);
    }
}
