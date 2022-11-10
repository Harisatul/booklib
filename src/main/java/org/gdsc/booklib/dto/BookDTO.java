package org.gdsc.booklib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class BookDTO {

    private String bookTittle;

    private String author;

    private Integer price;

    private String isbn;

    public BookDTO(String bookTittle, String author, Integer price, String isbn) {
        this.bookTittle = bookTittle;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }
}
