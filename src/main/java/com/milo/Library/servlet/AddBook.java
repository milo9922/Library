package com.milo.Library.servlet;

import com.milo.Library.repository.BookDao;
import com.milo.Library.repository.UserDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;


@WebServlet(urlPatterns = "/books/", name = "AddBook")
public class AddBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new BookDao().insertBook(
                request.getParameter("title"),
                request.getParameter("author"),
                Integer.parseInt(request.getParameter("pages")),
                new UserDao().getUserIdByName((String) request.getSession().getAttribute("user")));

        response.sendRedirect("/books/showAll");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        addBook(request, response);
    }

}
