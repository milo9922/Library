package com.milo.Library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Book {

    private int bookId;
    private String title;
    private String author;
    private int pagesNum;
    private int addedBy;
    private Date addDate;
    private int borrowedBy;
    private Date borrowDate;
    private Date returnDate;
    private int numberOfBorrows;


    public Book(String title, String author, int pagesNum, int addedBy, Date addDate, int borrowedBy, Date borrowDate, Date returnDate, int numberOfBorrows) {
        this.title = title;
        this.author = author;
        this.pagesNum = pagesNum;
        this.addedBy = addedBy;
        this.addDate = addDate;
        this.borrowedBy = borrowedBy;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.numberOfBorrows = numberOfBorrows;
    }

}
