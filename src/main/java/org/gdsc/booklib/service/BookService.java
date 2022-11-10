package org.gdsc.booklib.service;

import org.gdsc.booklib.entities.Books;
import org.gdsc.booklib.entities.Users;

import java.util.List;

public interface BookService {

    List<Users> getAllBooks();
    Users addBook(Books book);
    Users deleteBook(String bookTittle);
    Users updateBook(Books newBook, String bookTittle);

}
