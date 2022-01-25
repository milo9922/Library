package com.milo.Library.repository;

import com.milo.Library.entity.Book;
import com.milo.Library.service.BookService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional
public class BookDao extends DbConnection {

    private Connection conn;

    public void insertBook(String title, String author, int pages, int userId) {

        try {
            conn = getConnection();
            String sql = "INSERT INTO tb_book(Title, Author, PagesNum, AddedBy, AddDate, NumberOfBorrows) VALUES (?, ?, ?, ?, CURRENT_DATE, 0)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, pages);
            statement.setInt(4, userId);
            int row = statement.executeUpdate();
            String message;

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
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tb_book WHERE BookID = ?");
            ps.setInt(1, bookId);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Book getSingleBookById(int bookId) {
        try {
            conn = getConnection();
            String query = "SELECT * FROM tb_book WHERE BookID = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, bookId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int bookID = rs.getInt("BookID");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                int pagesNum = rs.getInt("PagesNum");
                int addedBy = rs.getInt("AddedBy");
                Date addDate = rs.getDate("AddDate");
                int borrowedBy = rs.getInt("BorrowedBy");
                Date borrowDate = rs.getDate("BorrowDate");
                Blob borrowQrCode = rs.getBlob("BorrowQrCode");
                Date returnDate = rs.getDate("ReturnDate");
                int numberOfBorrows = rs.getInt("NumberOfBorrows");

                conn.close();
                return new Book(bookID, title, author, pagesNum, addedBy, addDate, borrowedBy, borrowDate, borrowQrCode, returnDate, numberOfBorrows);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Book> getAllBooks(boolean onlyAvailable) {
        List<Book> books = new LinkedList<>();
        try {
            conn = getConnection();
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM tb_book";
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
                Blob borrowQrCode = rs.getBlob("BorrowQrCode");
                Date returnDate = rs.getDate("ReturnDate");
                int numberOfBorrows = rs.getInt("NumberOfBorrows");

                if (onlyAvailable) {
                    if (borrowedBy == 0) {
                        books.add(new Book(bookId, title, author, pagesNum, addedBy, addDate, borrowedBy, borrowDate, borrowQrCode, returnDate, numberOfBorrows));
                    }
                } else {
                    books.add(new Book(bookId, title, author, pagesNum, addedBy, addDate, borrowedBy, borrowDate, borrowQrCode, returnDate, numberOfBorrows));
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
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE tb_book SET BorrowedBy = ?, BorrowDate = CURRENT_DATE, BorrowQrCode = ?, ReturnDate = NULL, NumberOfBorrows = NumberOfBorrows + 1 WHERE BookID = ?");
            ps.setInt(1, userId);
            ps.setBlob(2, new BookService().generateBorrowIdQrCodeBis(bookId));
            ps.setInt(3, bookId);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int bookId) {
        try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE tb_book SET BorrowedBy = null, BorrowDate = NULL, ReturnDate = CURRENT_DATE WHERE BookID = ?");
            ps.setInt(1, bookId);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getBookIdByTitle(String title) {
        try {
            conn = getConnection();
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM tb_book";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String titleFromDb = rs.getString("Title");
                if (title.equals(titleFromDb)) {
                    int bookId = rs.getInt("BookID");
                    conn.close();
                    return bookId;
                }
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void createBorrowQrCodePngFileById(int bookId) {
        try {
            conn = getConnection();
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM tb_book";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int bookIdFromDb = rs.getInt("BookID");
                if (bookId == bookIdFromDb) {
                    byte[] qrCodeData = rs.getBytes("BorrowQrCode");
                    ByteArrayInputStream bais = new ByteArrayInputStream(qrCodeData);
                    BufferedImage qrCodeImage = ImageIO.read(bais);
                    ClassLoader classLoader = getClass().getClassLoader();
                    File qrBorrowCode = new File(classLoader.getResource(".").getFile() + "/static/png/borrowQrCode.png");
                    ImageIO.write(qrCodeImage, "png", qrBorrowCode);
                }
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
