package com.praveg.controller;

import com.praveg.entity.User;
import com.praveg.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {

   private final UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws Exception {
    User getUser = userService.getUserById(id);
    return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> getAll = userService.getAllUsers();
        return new ResponseEntity<>(getAll, HttpStatus.OK);
    }


    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody User user,@PathVariable Long id) throws Exception {
        User updatedUser = userService.updateUserById(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws Exception {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
    }
}
