package com.milo.Library.service;

import com.milo.Library.entity.Book;
import com.milo.Library.repository.BookDao;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    public List<Book> getLatestBooks(int howMany) {
        List<Book> latestBooks = new BookDao().getAllBooks(false);
        latestBooks.sort((Comparator.comparing(Book::getAddDate).reversed()));
        return latestBooks.stream().limit(howMany).collect(Collectors.toList());
    }

    public List<Book> getMostOftenBorrowedBooks(int howMany) {
        List<Book> latestBooks = new BookDao().getAllBooks(false);
        latestBooks.sort((Comparator.comparing(Book::getNumberOfBorrows).reversed()));
        return latestBooks.stream().limit(howMany).collect(Collectors.toList());
    }
}
