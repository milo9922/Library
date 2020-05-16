package com.milo.Library.repository;

import com.milo.Library.entity.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookDao {

    public void insertBook(String title, String author, int pages, int userId) {
        Connection conn = null;
        String message;

        try {
            conn = new DbConnection().getConnection();
            String sql = "INSERT INTO TB_BOOK(Title, Author, PagesNum, AddedBy, AddDate, NumberOfBorrows) VALUES (?, ?, ?, ?, CURRENT_DATE, 0)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, pages);
            statement.setInt(4, userId);

            int row = statement.executeUpdate();
            if (row > 0) {
                message = "Upload to database succeed!";
            } else {
                message = "Error! Upload failed!";
            }
            System.out.println(message);

        } catch (SQLException ex) {
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

    public void removeBook(int bookId) {
        try {
            Connection conn = new DbConnection().getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM TB_BOOK WHERE BookID = ?");
            ps.setInt(1, bookId);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks(boolean onlyAvailable) {
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
                int addedBy = rs.getInt("AddedBy");
                Date addDate = rs.getDate("AddDate");
                int borrowedBy = rs.getInt("BorrowedBy");
                Date borrowDate = rs.getDate("BorrowDate");
                Date returnDate = rs.getDate("ReturnDate");
                int numberOfBorrows = rs.getInt("NumberOfBorrows");

                if (onlyAvailable) {
                    if (borrowedBy == 0) {
                        books.add(new Book(bookId, title, author, pagesNum, addedBy, addDate, borrowedBy, borrowDate, returnDate, numberOfBorrows));
                    }
                } else {
                    books.add(new Book(bookId, title, author, pagesNum, addedBy, addDate, borrowedBy, borrowDate, returnDate, numberOfBorrows));
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
            PreparedStatement ps = conn.prepareStatement("UPDATE TB_BOOK SET BorrowedBy = ?, BorrowDate = CURRENT_DATE, ReturnDate = NULL, NumberOfBorrows = NumberOfBorrows + 1 WHERE BookID = ?");
            ps.setInt(1, userId);
            ps.setInt(2, bookId);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int bookId) {
        try {
            Connection conn = new DbConnection().getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE TB_BOOK SET BorrowedBy = null, BorrowDate = NULL, ReturnDate = CURRENT_DATE WHERE BookID = ?");
            ps.setInt(1, bookId);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
