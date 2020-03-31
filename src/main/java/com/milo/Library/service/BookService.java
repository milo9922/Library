package com.milo.Library.service;

import com.milo.Library.entity.Book;
import com.milo.Library.repository.BookDao;
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

    public void deleteBook(int id) {
        bookDao.removeBook(id);
    }
}
