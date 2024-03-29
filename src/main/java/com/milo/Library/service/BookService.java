package com.milo.Library.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.milo.Library.entity.Book;
import com.milo.Library.repository.BookDao;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    public List<Book> getLatestBooks(int howMany) {
        List<Book> latestBooks = new BookDao().getAllBooks(false);
        latestBooks.sort((Comparator.comparing(Book::getAddDate).reversed()));
        if (howMany < latestBooks.size()) {
            return latestBooks.stream().limit(howMany).collect(Collectors.toList());
        } else {
            return latestBooks;
        }
    }

    public List<Book> getMostOftenBorrowedBooks(int howMany) {
        List<Book> latestBooks = new BookDao().getAllBooks(false);
        latestBooks.sort((Comparator.comparing(Book::getNumberOfBorrows).reversed()));
        return latestBooks.stream().limit(howMany).collect(Collectors.toList());
    }

    public ByteArrayInputStream generateBorrowIdQrCodeBis(int bookId) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        String uuid = UUID.randomUUID().toString();
        String bookID = String.valueOf(bookId);
        BitMatrix bitMatrix = qrCodeWriter.encode(bookID, BarcodeFormat.QR_CODE, 250, 250);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        return new ByteArrayInputStream(pngOutputStream.toByteArray());
    }

}
