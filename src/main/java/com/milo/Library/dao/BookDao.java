package com.milo.Library.dao;

import com.milo.Library.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookDao {

    private static Map<Integer, Book> books;

    static {

        books = new HashMap<Integer, Book>() {
            {
                put(1, new Book(1, "Abc", "Abc", 50));
                put(2, new Book(2, "Def", "koko", 30));
                put(3, new Book(3, "Aasd", "pokpok", 75));
            }
        };
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}
