package org.comicbookret.factory;

import org.comicbookret.common.CommonCode;
import org.comicbookret.controller.*;
import org.comicbookret.repository.ComicBookRepository;
import org.comicbookret.repository.RentalRepository;
import org.comicbookret.repository.Repository;
import org.comicbookret.repository.UserRepository;

public class Factory {

    private static Factory instance;

    private Factory() {
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public Repository<?> create(int type) {
        Repository repository = null;
        if (type == CommonCode.REPOSITORY_COMICBOOK) {
            repository = new ComicBookRepository();
        } else if (type == CommonCode.REPOSITORY_USER) {
            repository = new UserRepository();
        } else {
            repository = new RentalRepository();
        }
        return repository;
    }

    public ComicBookController createComicBookController() {
        return new ComicBookControllerImpl();
    }

    public UserController createUserController() {
        return new UserControllerImpl();
    }

    public RentalController createRentalController() {
        return new RentalControllerImpl();
    }

}
