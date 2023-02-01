package org.comicbookret.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceDB {

    private static ServiceDB instance;

    private static Map<String, ArrayList> db = new HashMap<>();
    private static int COMICBOOK_ID=1;
    private static int USER_ID=1;
    private static int RENTAL_ID=1;

    static {
        db.put("ComicBook", new ArrayList<ComicBook>());
        db.put("User", new ArrayList<User>());
        db.put("Rental", new ArrayList<Rental>());
    }

    private ServiceDB() {
    }

    public static ServiceDB getInstance() {
        if (instance == null) {
            instance = new ServiceDB();
        }
        return instance;
    }

    public Map getDB() {
        return this.db;
    }

    public void create(ComicBook comicBook) {
        comicBook.setBookNumber(COMICBOOK_ID++);
        db.get("ComicBook").add(comicBook);
    }
    public void create(User user) {
        user.setUserId(USER_ID++);
        db.get("User").add(user);
    }
    public void create(Rental rental) {
        rental.setRentId(RENTAL_ID++);
        db.get("Rental").add(rental);
    }

    public void delete(ComicBook comicBook) {
        db.get("ComicBook").remove(comicBook);
    }
    public void delete(User user) {
        db.get("User").remove(user);
    }
    public void delete(Rental rental) {
        db.get("Rental").remove(rental);
    }

    public void update(ComicBook comicBook) {
        ArrayList<ComicBook> list = db.get("ComicBook");
        for (ComicBook c : list) {
            if (c.getBookNumber() == comicBook.getBookNumber()) {
                c.setBookNumber(comicBook.getBookNumber());
                c.setTitle(comicBook.getTitle());
                c.setAuthor(comicBook.getAuthor());
            }
        }
    }
    public void update(User user) {
        ArrayList<User> list = db.get("User");
        for (User u : list) {
            if (u.getUserId() == user.getUserId()) {
                u.setUserName(user.getUserName());
            }
        }
    }
    public void update(Rental rental) {
        ArrayList<Rental> list = db.get("Rental");
        for (Rental r : list) {
            if (r.getRentId() == rental.getRentId()) {
                r.setRentId(rental.getRentId());
            }
        }
    }

    public ComicBook selectOne(ComicBook comicBook) {
        if (db.get("ComicBook").contains(comicBook)) {
            return comicBook;
        } else return null;
    }
    public User selectOne(User user) {
        if (db.get("User").contains(user)) {
            return user;
        } else return null;
    }
    public Rental selectOne(Rental rental) {
        if (db.get("Rental").contains(rental)) {
            return rental;
        } else return null;
    }

}
