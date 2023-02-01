package org.comicbookret.controller;

import org.comicbookret.common.CommonCode;
import org.comicbookret.dto.User;
import org.comicbookret.factory.Factory;
import org.comicbookret.repository.Repository;

import java.util.List;

public class UserControllerImpl implements UserController{

    Repository repository = null;

    public UserControllerImpl() {
        repository = Factory.getInstance().create(CommonCode.REPOSITORY_USER);
    }
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public String create(User user) {
        repository.create(user);
        return null;
    }

    @Override
    public String update(User user) {
        repository.update(user);
        return null;
    }

    @Override
    public String delete(User user) {
        repository.delete(user);
        return null;
    }

    @Override
    public User selectOne(String name) {
        User temp = null;
        List<User> list = repository.findAll();
        for (User u : list) {
            if (u.getUserName().equals(name)) {
                temp = u;
            }
        }
        return temp;
    }
}
