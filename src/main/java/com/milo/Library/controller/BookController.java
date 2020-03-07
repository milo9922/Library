package com.milo.Library.controller;

import com.milo.Library.entity.Book;
import com.milo.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllBooks() {
        return bookService.getAllBooks().toString();
    }

    @GetMapping(value = "/add")
    public String libraryPage() {
        return "addBook";
    }

    @GetMapping(value = "/show")
    public String showBooks() {
        return "books";
    }
}
