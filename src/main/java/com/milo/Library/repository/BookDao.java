package com.milo.Library.repository;

import com.milo.Library.entity.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookDao {

    private final String DB_URL = "jdbc:mysql://remotemysql.com:3306/3Q84ulcsc7";
    private final String DB_USER = "3Q84ulcsc7";
    int x;

    public BookDao() {
    }

    public void insertBook(Book book) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, "zumqXjeFMY");
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

    public int removeBook(int bookId) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, "zumqXjeFMY");
            PreparedStatement ps = conn.prepareStatement("DELETE FROM TB_BOOK WHERE BookID = ?");
            ps.setInt(1, bookId);
            setX(ps.executeUpdate());
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getX();
    }

    public List<Book> getAllBooks() {
        List<Book> books = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, "zumqXjeFMY");
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM TB_BOOK";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int bookId = rs.getInt("BookID");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                int pagesNum = rs.getInt("PagesNum");
                int userId = rs.getInt("UserID");
                Date borrowDate = rs.getDate("BorrowDate");

                books.add(new Book(bookId, title, author, pagesNum, userId, borrowDate));
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
