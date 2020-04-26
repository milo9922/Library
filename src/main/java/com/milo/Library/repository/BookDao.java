package com.milo.Library.repository;

import com.milo.Library.entity.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookDao {

    int x;

    public void insertBook(String title, String author, int pages) {
        Connection conn = null;
        String message = null;

        try {
            conn = new DbConnection().getConnection();
            String sql = "INSERT INTO TB_BOOK(Title, Author, PagesNum) VALUES (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, pages);

            int row = statement.executeUpdate();
            if (row > 0) {
                message = "Upload to database succeed!";
            } else {
                message = "Error! Upload failed!";
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

    }

    // TODO Zaimplementować usuwanie książek dostępne tylko dla adminów i dodającego daną książkę
    public int removeBook(int bookId) {
        try {
            Connection conn = new DbConnection().getConnection();
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
            Connection conn = new DbConnection().getConnection();
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM TB_BOOK";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int bookId = rs.getInt("BookID");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                int pagesNum = rs.getInt("PagesNum");
                int userId = rs.getInt("UserID");
                Date addDate = rs.getDate("AddDate");
                Blob contentPdf = rs.getBlob("ContentPdf");
                if (onlyBorrowed) {
                    if (userId == 0) {
                        books.add(new Book(bookId, title, author, pagesNum, userId, addDate, contentPdf));
                    }

                } else {
                    books.add(new Book(bookId, title, author, pagesNum, userId, addDate, contentPdf));
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
            Connection conn = new DbConnection().getConnection();
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
            Connection conn = new DbConnection().getConnection();
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
