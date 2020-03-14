package com.milo.Library.controller;

import com.milo.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllBooks() {
        return bookService.getAllBooks().toString();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String libraryPage() {
        return "addBookForm";
    }

    @GetMapping(value = "/showAll")
    public String showBooks() {
        return "allBooks";
    }

    @RequestMapping(value = "/addBook")
    public String addBook() {
        return "addBook";
    }
}
