package org.gdsc.booklib.service.impl;

import org.gdsc.booklib.entities.Books;
import org.gdsc.booklib.entities.Users;
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
    public List<Users> getAllBooks() {
        return null;
    }

    @Override
    public Users addBook(Books book) {
        return null;
    }

    @Override
    public Users deleteBook(String bookTittle) {
        return null;
    }

    @Override
    public Users updateBook(Books newBook, String bookTittle) {
        return null;
    }
}
