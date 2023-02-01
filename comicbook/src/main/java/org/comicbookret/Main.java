package org.comicbookret;

import org.comicbookret.app.rentalApp;
import org.comicbookret.dto.ComicBook;
import org.comicbookret.dto.User;

public class Main {
    public static void main(String[] args) {

        rentalApp rent = new rentalApp();
        rent.test();
        rent.start();
    }
}
