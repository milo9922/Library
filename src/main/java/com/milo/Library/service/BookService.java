package com.milo.Library.service;

import com.milo.Library.entity.Book;
import com.milo.Library.repository.BookDao;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.util.Collection;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public Collection<Book> getAllBooks(boolean onlyBorrowed) {
        return bookDao.getAllBooks(onlyBorrowed);
    }

    @SneakyThrows
    public void blobToPdf(Blob blobFile) {
        File outputFile = new File("/book.pdf");
        FileOutputStream fout = new FileOutputStream(outputFile);
        IOUtils.copy(blobFile.getBinaryStream(), fout);
        fout.close();
    }
}
