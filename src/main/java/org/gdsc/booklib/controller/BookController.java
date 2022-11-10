package org.gdsc.booklib.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.gdsc.booklib.dto.BookDTO;
import org.gdsc.booklib.dto.UserDTO;
import org.gdsc.booklib.entities.Books;
import org.gdsc.booklib.entities.Users;
import org.gdsc.booklib.payload.ApiResponse;
import org.gdsc.booklib.service.BookService;
import org.springframework.http.MediaType;
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

    @Operation(
            tags = {"Books"},
            operationId = "addBook",
            summary = "add book data",
            description = "to add book data.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This is the request body for added Book data request.",
                    content = @Content(schema = @Schema(implementation = BookDTO.class))),
            responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(
                            schema = @Schema(implementation = ApiResponse.class, type = "String"),mediaType = MediaType.APPLICATION_JSON_VALUE),
                    description = "Success Response."),
            }

    )
    @PostMapping("/addbook")
    public ResponseEntity<ApiResponse> addBook(@RequestBody BookDTO book){
        Books books = bookService.addBook(book);
        ApiResponse apiResponse = new ApiResponse(
                TRUE,
                "successfully added book data with tittle " + book.getBookTittle(),
                books);
        return new ResponseEntity<>(apiResponse, CREATED);
    }

    @GetMapping("/getallbooks")
    @Operation(
            tags = {"Books"},
            operationId = "getAllBook",
            summary = "get all book data",
            description = "to fetch all books data",
            responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(
                            schema = @Schema(implementation = ApiResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE),
                    description = "Success Response."),
            }

    )
    public ResponseEntity<ApiResponse> getAllBooks(){
        List<Books> allBooks = bookService.getAllBooks();
        ApiResponse apiResponse = new ApiResponse(TRUE, "successfully fetch books data ", allBooks);
        return new ResponseEntity<>(apiResponse, OK);
    }

    @Operation(
            tags = {"Books"},
            operationId = "deleteBook",
            summary = "delete book data by book Tittle",
            description = "to delete book data",
            parameters = {
                    @Parameter(name = "booktittle", description = "this is book tittle.",
                            example = "Filosofi teras",schema = @Schema(type = "string"), required = false)},
            responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(
                            schema = @Schema(implementation = ApiResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE),
                    description = "Success Response."),
            }

    )
    @DeleteMapping("/deletebook/{booktittle}")
    public ResponseEntity<ApiResponse> deleteBook(@PathVariable(name = "booktittle") String bookTittle){
        Books books = bookService.deleteBook(bookTittle);
        ApiResponse apiResponse = new ApiResponse(TRUE, "successfully delete book data with book tittle :  " + bookTittle, books);
        return new ResponseEntity<>(apiResponse, OK);
    }

    @PostMapping("/updatebook/{booktittle}")
    @Operation(
            tags = {"Books"},
            operationId = "updateBook",
            summary = "update book data",
            description = "to update book data. booktittle required as path of endpoint",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This is the request body for update Book data request.",
                    content = @Content(schema = @Schema(implementation = Users.class))),
            parameters = {
                    @Parameter(name = "booktittle", description = "this is booktittle.",
                            example = "Filosofi Teras",schema = @Schema(type = "string"), required = false)},
            responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(
                            schema = @Schema(implementation = ApiResponse.class, type = "String"),mediaType = MediaType.APPLICATION_JSON_VALUE),
                    description = "Success Response."),
            }

    )
    public ResponseEntity<ApiResponse> updateUser(@RequestBody BookDTO books, @PathVariable(name = "booktittle") String bookTittle){
        Books updateBooks = bookService.updateBook(books, bookTittle);
        ApiResponse apiResponse = new ApiResponse(TRUE, "successfully updated book data with book tittle " + bookTittle, updateBooks);
        return new ResponseEntity<>(apiResponse, OK);
    }

}
