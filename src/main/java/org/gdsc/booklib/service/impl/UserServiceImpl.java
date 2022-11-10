package org.gdsc.booklib.service.impl;

import org.gdsc.booklib.dto.UserDTO;
import org.gdsc.booklib.entities.Users;
import org.gdsc.booklib.repository.UserRepository;
import org.gdsc.booklib.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users addUser(UserDTO user) {
        Users users = new Users(user.getUsername(), user.getEmail(), user.getPassword());
        return userRepository.save(users);
    }

    @Override
    public Users deleteUser(String username) {
        Users users = userRepository.findUsersByUsername(username).orElseThrow();
        userRepository.delete(users);
        return users;
    }

    @Override
    public Users updateUser(UserDTO newUser, String username) {
        Users users = userRepository.findUsersByUsername(username).orElseThrow();
        users.setUsername(newUser.getUsername());
        users.setEmail(newUser.getEmail());
        users.setPassword(newUser.getPassword());
        return users;
    }
}
