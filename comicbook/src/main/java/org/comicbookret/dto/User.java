package org.comicbookret.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private int userId;
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

}
