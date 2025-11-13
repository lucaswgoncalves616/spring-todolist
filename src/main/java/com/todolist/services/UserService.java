package com.todolist.services;

import com.todolist.dto.response.UserResponse;
import com.todolist.entityModel.User;
import com.todolist.exception.ResourceNotFoundException;
import com.todolist.repositores.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserService() {

    }

    public UserResponse saveUser(User user) {
        User createdUser = new User(user.getName(), user.getEmail(), user.getPassword());
        userRepo.save(createdUser);

        return new UserResponse(createdUser);
    }

    public String userLogin(User user){
        User findUser = userRepo.findByEmail(user.getEmail());
        if (findUser == null){
            return "User Not found";
        } else {
            if (findUser.getPassword().equals(user.getPassword())) {
                return "Ok";
            } else {
                return "Incorrect password";
            }
        }
    }

    public List<UserResponse> listarUsuarios() {
        List<User> usuarios = userRepo.findAll();
        List<UserResponse> listaDeUsuarios = new ArrayList<>();
        for (User usuario : usuarios) {
            listaDeUsuarios.add(new UserResponse(usuario));
        }

        return listaDeUsuarios;
    }

    public UserResponse updateUser(long id, User userDetails) {
        User updateUser = userRepo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateUser.setName(userDetails.getName());
        updateUser.setEmail(userDetails.getEmail());

        userRepo.save(updateUser);

        return new UserResponse(updateUser);
    }

    public String deleteUser(long id){
        User deleteUser = userRepo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("User not found with id" + id));

        userRepo.deleteById(id);
        return "User deleted successfully!";
    }
}
