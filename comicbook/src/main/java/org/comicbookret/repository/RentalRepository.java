package org.comicbookret.repository;

import org.comicbookret.dto.Rental;
import org.comicbookret.dto.ServiceDB;

import java.util.ArrayList;
import java.util.List;

public class RentalRepository implements Repository<Rental>{

    private ServiceDB db = ServiceDB.getInstance();
    @Override
    public List<Rental> findAll() {
        return (ArrayList)db.getDB().get("Rental");
    }

    @Override
    public void create(Rental rental) {
        db.create(rental);
    }

    @Override
    public void delete(Rental rental) {
        db.delete(rental);
    }

    @Override
    public void update(Rental rental) {
        db.update(rental);
    }

    @Override
    public Rental selectOne(Rental rental) {
        return db.selectOne(rental);
    }
}
