package com.todolist.dto.response;

import com.todolist.entityModel.User;

public class UserResponse {
    private int id;
    private String name;
    private String email;

    public UserResponse(User user){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
