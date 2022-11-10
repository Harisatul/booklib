package org.gdsc.booklib.service.impl;

import org.gdsc.booklib.entities.Books;
import org.gdsc.booklib.repository.BookRepository;
import org.gdsc.booklib.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Books addBook(Books book) {
        return bookRepository.save(book);
    }

    @Override
    public Books deleteBook(String bookTittle) {
        Books books = bookRepository.findBooksByBookTittle(bookTittle).orElseThrow();
        bookRepository.delete(books);
        return books;
    }

    @Override
    public Books updateBook(Books newBook, String bookTittle) {
        Books books = bookRepository.findBooksByBookTittle(bookTittle).orElseThrow();
        books.setBookTittle(newBook.getBookTittle());
        books.setAuthor(newBook.getAuthor());
        books.setIsbn(newBook.getIsbn());
        books.setPrice(newBook.getPrice());
        return books;
    }
}
