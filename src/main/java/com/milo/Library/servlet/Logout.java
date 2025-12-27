package com.milo.Library.servlet;

import com.milo.Library.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/user/", name = "Logout")
public class Logout extends HttpServlet {

    private static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if (new UserService().isUserLogged(session)) {
            session.setAttribute("isLogged", false);
            session.setAttribute("user", "");
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logout(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logout(request, response);
    }
}
