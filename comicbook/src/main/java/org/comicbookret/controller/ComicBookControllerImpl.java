package org.comicbookret.controller;

import org.comicbookret.common.CommonCode;
import org.comicbookret.dto.ComicBook;
import org.comicbookret.factory.Factory;
import org.comicbookret.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class ComicBookControllerImpl implements ComicBookController{

    Repository repository = null;

    public ComicBookControllerImpl() {
        repository = Factory.getInstance().create(CommonCode.REPOSITORY_COMICBOOK);
    }

    @Override
    public List<ComicBook> findAll() {
        return repository.findAll();
    }

    @Override
    public String create(ComicBook comicBook) {
        repository.create(comicBook);
        return null;
    }

    @Override
    public String update(ComicBook comicBook) {
        repository.update(comicBook);
        return null;
    }

    @Override
    public String delete(ComicBook comicBook) {
        repository.delete(comicBook);
        return null;
    }

    // 좀더 효율적인 방법이 있을까요?
    @Override
    public ComicBook selectOne(String title) {
        ComicBook temp = null;
        List<ComicBook> list = repository.findAll();
        for (ComicBook c : list) {
            if (c.getTitle().equals(title)) {
                temp = c;
            }
        }
        return temp;
    }
}
