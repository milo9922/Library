package com.milo.Library.controller;

import com.milo.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllBooks() {
        return bookService.getAllBooks(true).toString();
    }

    @RequestMapping(value = "/showAll")
    public String showBooks() {
        return "allBooks";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String libraryPage() {
        return "addBookForm";
    }

    @RequestMapping(value = "/addBook")
    public String addBook() {
        return "AddBook";
    }

    @RequestMapping(value = "/borrowList")
    public String borrowBookList() {
        return "borrowBookList";
    }

    @RequestMapping(value = "/BorrowBook{id}")
    public String borrowBook(@RequestParam int id) {
        return "BorrowBook";
    }

    @RequestMapping(value = "/borrowed")
    public String borrowedBooks() {
        return "borrowedBooksList";
    }

    @RequestMapping(value = "/ReturnBook{id}")
    public String returnBook(@RequestParam int id) {
        return "ReturnBook";
    }
}
