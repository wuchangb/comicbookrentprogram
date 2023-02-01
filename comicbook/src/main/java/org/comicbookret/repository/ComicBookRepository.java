package org.comicbookret.repository;

import org.comicbookret.dto.ComicBook;
import org.comicbookret.dto.ServiceDB;

import java.util.ArrayList;

public class ComicBookRepository implements Repository<ComicBook> {

    private ServiceDB db = ServiceDB.getInstance();

    @Override
    public ArrayList findAll() {
        return (ArrayList) db.getDB().get("ComicBook");
    }

    @Override
    public void create(ComicBook comicBook) {
        db.create(comicBook);
    }

    @Override
    public void delete(ComicBook comicBook) {
        db.delete(comicBook);
    }

    @Override
    public void update(ComicBook comicBook) {
        db.update(comicBook);
    }

    @Override
    public ComicBook selectOne(ComicBook comicBook) {
        return db.selectOne(comicBook);
    }

}
