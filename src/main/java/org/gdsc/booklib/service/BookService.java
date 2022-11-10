package org.gdsc.booklib.service;

import org.gdsc.booklib.entities.Books;
import org.gdsc.booklib.entities.Users;

import java.util.List;

public interface BookService {

    List<Books> getAllBooks();
    Books addBook(Books book);
    Books deleteBook(String bookTittle);
    Books updateBook(Books newBook, String bookTittle);

}
