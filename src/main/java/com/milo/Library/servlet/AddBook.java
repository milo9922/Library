package com.milo.Library.servlet;

import com.milo.Library.entity.Book;
import com.milo.Library.repository.BookDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/books/", name = "AddBook")
public class AddBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addBook(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addBook(request, response);
    }

    private static void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String pagesNum = request.getParameter("pages");
        BookDao bookDao = new BookDao();
        bookDao.insertBook(new Book(title, author, Integer.parseInt(pagesNum), null, null));

        if (bookDao.getX() > 0) {
            response.sendRedirect("/books/showAll");
        } else {
            System.out.println("Nie udało się dodać książki!");
        }
    }
}
