package com.todolist.repositores;

import com.todolist.entityModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
