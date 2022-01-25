package com.milo.Library.servlet;

import com.milo.Library.repository.BookDao;
import com.milo.Library.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/books/", name = "ReturnBook")
public class ReturnBook extends HttpServlet {

    private static void returnBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!new UserService().isUserLogged(request.getSession())) {
            response.sendRedirect("http://localhost:8081/user/signin");
        } else {
            new BookDao().returnBook(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect("/books/borrowed");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        returnBook(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        returnBook(request, response);
    }
}
