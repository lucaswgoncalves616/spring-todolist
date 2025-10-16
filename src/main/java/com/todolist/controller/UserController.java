package com.todolist.controller;


import com.todolist.entityModel.User;
import com.todolist.exception.ResourceNotFoundException;
import com.todolist.repositores.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @PostMapping(value = "user/signup")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User createdUser = new User(user.getName(), user.getEmail(), user.getPassword());
        userRepo.save(createdUser);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping(value = "user/signin")
    public ResponseEntity<?> userLogin(@RequestBody User user){
        User findUser = userRepo.findByEmail(user.getEmail());
        if (findUser == null){
            return ResponseEntity.ok("User Not found");
        } else {
            if (findUser.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok("Ok");
            } else {
                return ResponseEntity.ok("Incorrect password");
            }
        }

    }

    @GetMapping
    public List<User> mostrar() {
        return userRepo.findAll();
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userDetails) {
        User updateUser = userRepo.findById(id).orElseThrow(()
                        -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateUser.setName(userDetails.getName());
        updateUser.setEmail(userDetails.getEmail());

        userRepo.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        User deleteUser = userRepo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("User not found with id" + id));

        userRepo.deleteById(id);
        return ResponseEntity.ok("User deleted successfully!");
    }

}
