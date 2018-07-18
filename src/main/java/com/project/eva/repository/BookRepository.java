package com.project.eva.repository;

import com.project.eva.model.Book;

import java.util.List;

public interface BookRepository extends MainRepository<Book> {

    Book findByUrl(String url);

    Book findByTitle(String title);

    void deleteByTitle(String title);

    void deleteByUrl(String url);


}
