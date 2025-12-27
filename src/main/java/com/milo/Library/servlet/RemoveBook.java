package com.milo.Library.servlet;

import com.milo.Library.repository.BookDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/books/", name = "remove")
public class RemoveBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static void removeBook(HttpServletRequest request) {
        new BookDao().removeBook(Integer.parseInt(request.getParameter("id")));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        removeBook(request);
        response.sendRedirect("/books/showAll");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
