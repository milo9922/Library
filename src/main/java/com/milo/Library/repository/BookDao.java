package com.milo.Library.repository;

import com.milo.Library.entity.Book;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
@NoArgsConstructor
public class BookDao {

    private final String DB_URL = "jdbc:mysql://remotemysql.com:3306/3Q84ulcsc7";
    private final String DB_USER = "3Q84ulcsc7";
    int x;

    public void insertBook(Book book) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, "zumqXjeFMY");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO TB_BOOK(Title, Author,PagesNum,AddDate) VALUES (?,?,?,CURRENT_DATE)");
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPagesNum());
            setX(ps.executeUpdate());
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // TODO Implement removeBook function only for admin
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

    public List<Book> getAllBooks(boolean onlyBorrowed) {
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
                Date returnDate = rs.getDate("ReturnDate");
                if (onlyBorrowed) {
                    if (userId == 0) {
                        books.add(new Book(bookId, title, author, pagesNum, userId, borrowDate, returnDate));
                    }

                } else {
                    books.add(new Book(bookId, title, author, pagesNum, userId, borrowDate, returnDate));
                }

            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public void borrowBook(int bookId, int userId) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, "zumqXjeFMY");
            PreparedStatement ps = conn.prepareStatement("UPDATE TB_BOOK SET UserID = ?, BorrowDate = CURRENT_DATE, ReturnDate = null WHERE BookID = ?");
            ps.setInt(1, userId);
            ps.setInt(2, bookId);
            setX(ps.executeUpdate());
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int bookId) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, "zumqXjeFMY");
            PreparedStatement ps = conn.prepareStatement("UPDATE TB_BOOK SET UserID = null, ReturnDate = CURRENT_DATE WHERE BookID = ?");
            ps.setInt(1, bookId);
            setX(ps.executeUpdate());
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
