package com.project.eva.service.interfaces;

import com.project.eva.model.Book;

import java.util.List;

public interface BookService extends MainService<Book> {

    Book get(String url);

    Book getByTitle(String title);

    void removeByTitle(String title);

    void remove(String url);


}

