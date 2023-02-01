package org.comicbookret.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class Rental {

    private int rentId;
    private String rentBookTitle;

    public Rental(String rentBookTitle) {
        this.rentBookTitle = rentBookTitle;
    }
}
