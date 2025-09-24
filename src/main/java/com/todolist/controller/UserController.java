package com.todolist.controller;


import com.todolist.entityModel.User;
import com.todolist.repositores.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepo user;

    @PostMapping
    public User salvar() {
        User joao = new User("João", "João@gmail.com", "123456");
        return user.save(joao);
    }

    @GetMapping
    public List<User> mostrar() {
        return user.findAll();
    }

}
