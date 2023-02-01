package org.comicbookret.repository;

import org.comicbookret.dto.ServiceDB;
import org.comicbookret.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository<User> {

    private ServiceDB db = ServiceDB.getInstance();

    @Override
    public ArrayList findAll() {
        return (ArrayList) db.getDB().get("User");
    }

    @Override
    public void create(User user) {
        db.create(user);
    }

    @Override
    public void delete(User user) {
        db.delete(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User selectOne(User user) {
        return db.selectOne(user);
    }

}
