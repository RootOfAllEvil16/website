package com.project.eva.service.impl;

import com.project.eva.model.Chapter;
import com.project.eva.repository.ChapterRepository;
import com.project.eva.service.interfaces.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.project.eva.util.validator.ObjectValidator.isEmpty;
import static com.project.eva.util.validator.ObjectValidator.isNotEmpty;
import static com.project.eva.util.validator.ObjectValidator.isNull;

@Service
@ComponentScan(basePackages = "com.project.eva.repository")
public final class ChapterServiceImpl extends MainServiceImpl<Chapter> implements ChapterService {

    private final ChapterRepository repository;


    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public ChapterServiceImpl(final ChapterRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Chapter getByUrl(final String url) throws IllegalArgumentException, NullPointerException {
        if (isEmpty(url)) {
            throw new IllegalArgumentException("No product URL!");
        }
        final Chapter chapter = this.repository.findByUrl(url);
        if (isNull(chapter)) {
            throw new NullPointerException("Can't find product by url " + url + "!");
        }
        return chapter;
    }

    @Override
    @Transactional(readOnly = true)
    public Chapter getByChapterNumber(final String chapterNumber) throws IllegalArgumentException, NullPointerException {
        if (isEmpty(chapterNumber)) {
            throw new IllegalArgumentException("No chapter number!");
        }
        final Chapter chapter = this.repository.findByChapterNumber(chapterNumber);
        if (isNull(chapter)) {
            throw new NullPointerException("Can't find chapter by number " + chapterNumber + "!");
        }
        return chapter;
    }

    @Override
    @Transactional(readOnly = true)
    public Chapter getByChapterTitle(final String chapterTitle) throws IllegalArgumentException, NullPointerException {
        if (isEmpty(chapterTitle)) {
            throw new IllegalArgumentException("No chapter title found!");
        }
        final Chapter chapter = this.repository.findByChapterTitle(chapterTitle);
        if (isNull(chapter)) {
            throw new NullPointerException("Can't find chapter by title " + chapterTitle + "!");
        }
        return chapter;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Chapter> getByBookUrl(final String url)
            throws IllegalArgumentException {
        if (isEmpty(url)) {
            throw new IllegalArgumentException("No book URL!");
        }
        return this.repository.findByBookUrl(url);
    }


    @Override
    @Transactional(readOnly = true)
    public Collection<Chapter> getByBookId(final long id) {
        return this.repository.findByBookId(id);
    }


    @Override
    @Transactional
    public void removeByUrl(final String url) {
        if (isNotEmpty(url)) {
            this.repository.deleteByUrl(url);
        }
    }

    @Override
    @Transactional
    public void removeByChapterNumber(final String chapterNumber) {
        if (isNotEmpty(chapterNumber)) {
            this.repository.deleteByChapterNumber(chapterNumber);
        }
    }

    @Override
    @Transactional
    public void removeByChapterTitle(final String chapterTitle) {
        if (isNotEmpty(chapterTitle)) {
            this.repository.deleteByChapterTitle(chapterTitle);
        }
    }

    @Override
    @Transactional
    public void removeByBookUrl(final String url) {
        if (isNotEmpty(url)) {
            this.repository.deleteByBookUrl(url);
        }
    }


    @Override
    @Transactional
    public void removeByBookId(final long id) throws NullPointerException {
        this.repository.deleteByBookId(id);
    }

}

