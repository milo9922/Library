package com.milo.Library.servlet;

import com.milo.Library.entity.Book;
import com.milo.Library.repository.BookDao;
import com.milo.Library.repository.UserDao;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;


@WebServlet(urlPatterns = "/books/", name = "AddBook")
public class AddBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @SneakyThrows
    private static void addBook(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        BookDao bookDao = new BookDao();
        int addedByUser = new UserDao().getUserIdByName((String) request.getSession().getAttribute("user"));
        String pagesNum = request.getParameter("pages");
        Blob contentPdf = new SerialBlob(request.getParameter("contentPdf").getBytes());

        bookDao.insertBook(new Book(title, author, Integer.parseInt(pagesNum), addedByUser, contentPdf));

        if (bookDao.getX() > 0) {
            response.sendRedirect("/books/showAll");
        } else {
            System.out.println("Nie udało się dodać książki!");
        }
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        addBook(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        addBook(request, response);
    }

}
