package com.todolist.controller;


import com.todolist.entityModel.User;
import com.todolist.exception.ResourceNotFoundException;
import com.todolist.repositores.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    UserRepo User;

    @PostMapping
    public User salvar() {
        User newUser = new User("Gabriela", "gabriela@gmail.com", "gabilinda");
        return User.save(newUser);
    }

    @GetMapping
    public List<User> mostrar() {
        return User.findAll();
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userDetails) {
        User updateUser = User.findById(id).orElseThrow(()
                        -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateUser.setNome(userDetails.getNome());
        updateUser.setEmail(userDetails.getEmail());
        updateUser.setSenha(userDetails.getSenha());

        User.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

}
