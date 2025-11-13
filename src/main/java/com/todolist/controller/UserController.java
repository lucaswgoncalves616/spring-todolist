package com.todolist.controller;


import com.todolist.dto.response.UserResponse;
import com.todolist.entityModel.User;
import com.todolist.repositores.UserRepo;
import com.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @PostMapping(value = "user/signup")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    @PostMapping(value = "user/signin")
    public ResponseEntity<?> userLogin(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.userLogin(user));
    }

    @GetMapping
    public List<User> mostrar() {
        return userRepo.findAll();
    }

    @GetMapping(value = "listar")
    public List<UserResponse> listarUsuarios() {
        UserService userService = new UserService();
        return userService.listarUsuarios();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody User userDetails) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, userDetails));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }

}
