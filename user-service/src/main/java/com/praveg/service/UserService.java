package com.praveg.service;

import com.praveg.entity.User;
import com.praveg.exception.UserException;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id) throws UserException;
    List<User> getAllUsers();
    User updateUserById(Long id, User user) throws UserException;
    void deleteUserById(Long id) throws UserException;
}
