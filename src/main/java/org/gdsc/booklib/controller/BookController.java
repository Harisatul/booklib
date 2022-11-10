package org.gdsc.booklib.controller;

import org.gdsc.booklib.dto.UserDTO;
import org.gdsc.booklib.entities.Books;
import org.gdsc.booklib.entities.Users;
import org.gdsc.booklib.payload.ApiResponse;
import org.gdsc.booklib.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/gdsc/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/addbook")
    public ResponseEntity<ApiResponse> addBook(@RequestBody Books book){
        Books books = bookService.addBook(book);
        ApiResponse apiResponse = new ApiResponse(
                TRUE,
                "successfully added book data with tittle " + book.getBookTittle(),
                books);
        return new ResponseEntity<>(apiResponse, CREATED);
    }

    @GetMapping("/getallbooks")
    public ResponseEntity<ApiResponse> getAllBooks(){
        List<Books> allBooks = bookService.getAllBooks();
        ApiResponse apiResponse = new ApiResponse(TRUE, "successfully fetch books data ", allBooks);
        return new ResponseEntity<>(apiResponse, OK);
    }

    @DeleteMapping("/deletebook/{booktittle}")
    public ResponseEntity<ApiResponse> deleteBook(@PathVariable(name = "booktittle") String bookTittle){
        Books books = bookService.deleteBook(bookTittle);
        ApiResponse apiResponse = new ApiResponse(TRUE, "successfully delete book data with book tittle :  " + bookTittle, books);
        return new ResponseEntity<>(apiResponse, OK);
    }

    @PostMapping("/updatebook/{booktittle}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody Books books, @PathVariable(name = "booktittle") String bookTittle){
        Books updateBooks = bookService.updateBook(books, bookTittle);
        ApiResponse apiResponse = new ApiResponse(TRUE, "successfully updated book data with book tittle " + bookTittle, updateBooks);
        return new ResponseEntity<>(apiResponse, OK);
    }

}
