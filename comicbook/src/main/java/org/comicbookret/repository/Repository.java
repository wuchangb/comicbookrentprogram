package org.comicbookret.repository;

import java.util.List;

public interface Repository<T> {

    public List<T> findAll();

    public void create(T parameter);

    public void delete(T parameter);
    public void update(T parameter);

    public T selectOne(T parameter);

}
