package com.milo.Library.servlet;

import com.milo.Library.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/", name = "Logout")
public class Logout extends HttpServlet {

    private static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (new UserService().checkIfUserIsLogged(session)) {
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
