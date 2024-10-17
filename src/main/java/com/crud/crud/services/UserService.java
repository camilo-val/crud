package com.crud.crud.services;

import java.util.List;
import java.util.Optional;

import com.crud.crud.models.User;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    User save (User user);
    Optional<User> delete(User user);
}
