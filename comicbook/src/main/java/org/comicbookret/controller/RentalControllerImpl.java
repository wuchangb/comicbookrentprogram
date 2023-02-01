package org.comicbookret.controller;

import org.comicbookret.common.CommonCode;
import org.comicbookret.dto.Rental;
import org.comicbookret.factory.Factory;
import org.comicbookret.repository.Repository;

import java.util.List;

public class RentalControllerImpl implements RentalController{

    Repository repository = null;

    public RentalControllerImpl() {
        repository = Factory.getInstance().create(CommonCode.REPOSITORY_RENTAL);
    }

    @Override
    public List<Rental> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Rental rental) {
        repository.create(rental);
    }

    @Override
    public void delete(Rental rental) {
        repository.delete(rental);
    }

    @Override
    public void update(Rental rental) {
        repository.update(rental);
    }

    @Override
    public Rental selectOne(String rentBookTitle) {
        Rental temp = null;
        try {
            List<Rental> list = repository.findAll();
            for (Rental r : list) {
                if (r.getRentBookTitle().equals(rentBookTitle)) {
                    temp = r;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("대여항목이 없습니다.");;
        }
        return temp;
    }
}
