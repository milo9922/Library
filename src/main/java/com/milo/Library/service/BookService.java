package com.milo.Library.service;

import com.milo.Library.dao.BookDao;
import com.milo.Library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public Collection<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
