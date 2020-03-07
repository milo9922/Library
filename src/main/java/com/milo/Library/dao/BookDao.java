package com.milo.Library.dao;

import com.milo.Library.entity.Book;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.*;

@Repository
public class BookDao {

    String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7326292";
    String username = "sql7326292";
    String password = "xMj4Da1xbR";

    private void insertBook(Book book) {

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            String query = "INSERT INTO TB_BOOK " + "VALUES (" +
                    book.getId() + "," +
                    "\'" + book.getTitle() + "\'" +
                    "\'" + book.getAuthor() + "\'" +
                    "\'" + book.getPagesNum() + "\'" +
                    "\'" + book.getUserId() + "\'" + ")";

            statement.executeUpdate(query);
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM TB_BOOK";

            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                int id = rs.getInt("BookID");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                int pagesNum = rs.getInt("PagesNum");
                int userId = rs.getInt("UserID");

                books.add(new Book(id, title, author, pagesNum, userId));
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }


}
