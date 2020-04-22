package com.milo.Library.servlet;

import com.milo.Library.repository.DbConnection;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/books/", name = "AddBook")
@MultipartConfig(maxFileSize = 100000000)
public class AddBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        InputStream inputStream = null;

        Part filePart = request.getPart("contentPdf");
        if (filePart != null) {
            inputStream = filePart.getInputStream();
        } else {
            System.out.println("File part is null!!!");
        }

        Connection conn = null;
        String message = null;

        try {
            conn = new DbConnection().getConnection();
            String sql = "INSERT INTO TB_BOOK(Title, Author, PagesNum, ContentPdf) VALUES (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, request.getParameter("title"));
            statement.setString(2, request.getParameter("author"));
            statement.setInt(3, Integer.parseInt(request.getParameter("pages")));

            if (inputStream != null) {
                statement.setBlob(4, inputStream);
            }

            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File upload to database succeed!";
            } else {
                message = "Error! File upload failed!";
            }
        } catch (SQLException ex) {
            System.out.println(message);
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        response.sendRedirect("/books/showAll");

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
