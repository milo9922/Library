package com.milo.Library.dao;

import com.milo.Library.entity.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookDao {

    String url = "jdbc:mysql://remotemysql.com:3306/3Q84ulcsc7";
    String username = "3Q84ulcsc7";
    String password = "zumqXjeFMY";

    int x;

    public BookDao() throws SQLException {
    }

    public void insertBook(Book book) {

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO TB_BOOK(Title, Author,PagesNum) VALUES (?,?,?)");
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPagesNum());
            setX(ps.executeUpdate());
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

            while (rs.next()) {
                int bookId = rs.getInt("BookID");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                int pagesNum = rs.getInt("PagesNum");
                int userId = rs.getInt("UserID");

                books.add(new Book(bookId, title, author, pagesNum, userId));
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
