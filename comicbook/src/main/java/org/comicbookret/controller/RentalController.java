package org.comicbookret.controller;

import org.comicbookret.dto.Rental;

import java.util.List;

public interface RentalController {

    List<Rental> findAll();

    void create(Rental rental);

    void delete(Rental rental);

    void update(Rental rental);

    Rental selectOne(String title);


}
