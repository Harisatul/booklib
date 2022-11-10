package org.gdsc.booklib.repository;

import org.gdsc.booklib.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findUsersByUsername(String username);

}
