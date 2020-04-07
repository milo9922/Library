package com.milo.Library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private int bookId;
    private String title;
    private String author;
    private int pagesNum;
    private int userId;
    private Date borrowDate;
    private Date returnDate;

    public Book(String title, String author, int pagesNum, Date borrowDate, Date returnDate) {
        this.title = title;
        this.author = author;
        this.pagesNum = pagesNum;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // TODO: Dodać treść książki na bazę danych i udostępnić ją na stronie po wypożyczeniu
}
