package com.milo.Library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {

    private String title;
    private String author;
    private int pagesNum;
    private int userId;

    public Book(String title, String author, int pagesNum, int userId) {
        this.title = title;
        this.author = author;
        this.pagesNum = pagesNum;
        this.userId = userId;
    }

}
