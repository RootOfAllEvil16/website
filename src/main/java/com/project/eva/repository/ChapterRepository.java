package com.project.eva.repository;

import com.project.eva.model.Chapter;

import java.util.Collection;

public interface ChapterRepository extends MainRepository<Chapter> {

    Chapter findByUrl(String url);

    Chapter findByChapterNumber(String chapterNumber);

    Chapter findByChapterTitle(String chapterTitle);

    void deleteByUrl(String url);

    void deleteByChapterNumber(String chapterNumber);

    void deleteByChapterTitle(String chapterTitle);

    void deleteByBookUrl(String url);

    void deleteByBookId(long id);

    Collection<Chapter> findByBookId(long id);

    Collection<Chapter> findByBookUrl(String url);
}

