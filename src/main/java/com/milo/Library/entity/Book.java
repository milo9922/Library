package com.milo.Library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "TB_BOOK")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String title;
    private String author;
    private int pagesNum;
    private int addedBy;
    private Date addDate;
    private int borrowedBy;
    private Date borrowDate;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] borrowQrCode;
    private Date returnDate;
    private int numberOfBorrows;

}
