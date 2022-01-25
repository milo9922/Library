package com.milo.Library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.*;
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
    @NotEmpty
    private String title;
    @NotEmpty
    private String author;
    private int pagesNum;
    private int addedBy;
    @NotNull
    private Date addDate;
    private int borrowedBy;
    private Date borrowDate;
    private Blob borrowQrCode;
    private Date returnDate;
    private int numberOfBorrows;

}
