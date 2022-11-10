package org.gdsc.booklib.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Books extends BaseEntity{

    @Column(name = "book_tittle")
    private String bookTittle;

    private String author;

    private Integer price;

    private String isbn;


}
