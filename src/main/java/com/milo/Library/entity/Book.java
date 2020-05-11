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

}
