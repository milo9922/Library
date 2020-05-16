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

    @GetMapping("/latest")
    public String latestBooks() {
        return "latestBooks";
    }

    @GetMapping("/add")
    public String libraryPage() {
        return "addBookForm";
    }

    @PostMapping("/addBook")
    public String addBook() {
        return "AddBook";
    }

    @RequestMapping("/remove{id}")
    public String removeBook() {
        return "RemoveBook";
    }

    @GetMapping("/available")
    public String borrowBookList() {
        return "availableBooks";
    }

    @RequestMapping("/borrow{id}")
    public String borrowBook() {
        return "BorrowBook";
    }

    @GetMapping("/borrowed")
    public String borrowedBooks() {
        return "borrowedBooks";
    }

    @GetMapping("/top")
    public String mostOftenBorrowed() {
        return "topBorrowed";
    }

    @RequestMapping("/return{id}")
    public String returnBook() {
        return "ReturnBook";
    }
}
