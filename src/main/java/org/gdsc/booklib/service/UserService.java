package org.gdsc.booklib.service;

import org.gdsc.booklib.dto.UserDTO;
import org.gdsc.booklib.entities.Users;

import java.util.List;

public interface UserService {

    List<Users> getAllUsers();
    Users addUser(UserDTO user);
    Users deleteUser(String username);
    Users updateUser(UserDTO newUser, String username);
}
