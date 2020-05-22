package com.milo.Library.servlet;

import com.milo.Library.repository.BookDao;
import com.milo.Library.repository.UserDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/books/", name = "borrow")
public class BorrowBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        borrowBook(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        borrowBook(request, response);
    }

    private void borrowBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new BookDao()
                .borrowBook(
                        Integer.parseInt(request.getParameter("id")),
                        new UserDao().getUserIdByName((String) request.getSession().getAttribute("user"))
                );
        response.sendRedirect("/books/toBorrow");
    }

}
