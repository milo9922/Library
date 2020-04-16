package com.milo.Library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    @GetMapping("/showAll")
    public String showBooks() {
        return "allBooks";
    }

    @GetMapping("/add")
    public String libraryPage() {
        return "addBookForm";
    }

    @PostMapping("/addBook")
    public String addBook() {
        return "AddBook";
    }

    @GetMapping("/borrowList")
    public String borrowBookList() {
        return "availableBooksList";
    }

    @PostMapping("/BorrowBook{id}")
    public String borrowBook() {
        return "BorrowBook";
    }

    @GetMapping("/borrowed")
    public String borrowedBooks() {
        return "borrowedBooksList";
    }

    @PostMapping("/ReturnBook{id}")
    public String returnBook() {
        return "ReturnBook";
    }
}
