package org.comicbookret.controller;

import org.comicbookret.dto.ComicBook;

import java.util.List;

public interface ComicBookController {

    List<ComicBook> findAll();      //comicbook 목록 가져오기

    String create(ComicBook comicBook); //comicbook 등록
    String update(ComicBook comicBook); //comicbook 수정
    String delete(ComicBook comicBook); //comicbook 삭제
    ComicBook selectOne(String title);  //title로 comicbook 찾기
}
