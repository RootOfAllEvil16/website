package com.project.eva.service.impl;

import com.project.eva.model.Book;
import com.project.eva.repository.BookRepository;
import com.project.eva.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.project.eva.util.validator.ObjectValidator.isEmpty;
import static com.project.eva.util.validator.ObjectValidator.isNotEmpty;
import static com.project.eva.util.validator.ObjectValidator.isNull;

@Service
@ComponentScan(basePackages = "com.project.eva.repository")
public final class BookServiceImpl extends MainServiceImpl<Book> implements BookService {

    private final BookRepository repository;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public BookServiceImpl(final BookRepository repository) {
        super(repository);
        this.repository = repository;
    }


    @Override
    @Transactional(readOnly = true)
    public Book get(final String url) throws IllegalArgumentException, NullPointerException {
        if (isEmpty(url)) {
            throw new IllegalArgumentException("No book URL!");
        }
        final Book book = this.repository.findByUrl(url);
        if (isNull(book)) {
            throw new NullPointerException("Can't find book by url " + url + "!");
        }
        return book;
    }

    @Override
    @Transactional(readOnly = true)
    public Book getByTitle(final String title) throws IllegalArgumentException, NullPointerException {
        if (isEmpty(title)) {
            throw new IllegalArgumentException("No book title!");
        }
        final Book book = this.repository.findByTitle(title);
        if (isNull(book)) {
            throw new NullPointerException("Can`t find book by title" + title + "!");
        }
        return book;
    }

    @Override
    @Transactional
    public void remove(final String url) {
        if (isNotEmpty(url)) {
            this.repository.deleteByUrl(url);
        }
    }
    @Override
    @Transactional
    public void removeByTitle(final String title){
        if (isNotEmpty(title)){
            this.repository.deleteByTitle(title);
        }
    }
}

