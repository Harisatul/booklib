package org.gdsc.booklib.repository;

import org.gdsc.booklib.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

    Optional<Books> findBooksByBookTittle(String bookTittle);

}
