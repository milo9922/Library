package com.milo.Library.servlet;

import com.milo.Library.repository.BookDao;
import lombok.SneakyThrows;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/books/", name = "AddBook")
@MultipartConfig(maxFileSize = 100000000)
public class AddBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new BookDao().insertBook(
                request.getParameter("title"),
                request.getParameter("author"),
                Integer.parseInt(request.getParameter("pages")));

        response.sendRedirect("/books/showAll");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        addBook(request, response);
    }

}
