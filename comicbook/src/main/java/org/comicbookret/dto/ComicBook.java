package org.comicbookret.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ComicBook {

    private int bookNumber;
    private String title;
    private String author;

    public ComicBook(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
