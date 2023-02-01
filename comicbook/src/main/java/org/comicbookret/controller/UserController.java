package org.comicbookret.controller;

import org.comicbookret.dto.User;

import java.util.List;

public interface UserController {

    List<User> findAll();

    String create(User user);
    String update(User user);
    String delete(User user);
    User selectOne(String name);
}
