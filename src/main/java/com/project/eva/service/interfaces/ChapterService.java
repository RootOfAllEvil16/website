package com.project.eva.service.interfaces;

import com.project.eva.model.Chapter;

import java.util.Collection;

public interface ChapterService extends MainService<Chapter> {

    Chapter getByUrl(String url);

    Chapter getByChapterNumber(String chapterNumber);

    Chapter getByChapterTitle(String chapterTitle);

    Collection<Chapter> getByBookUrl(String url);

    Collection<Chapter> getByBookId(long id);

    void removeByUrl(String url);

    void removeByChapterNumber(String chapterNumber);

    void removeByChapterTitle(String chapterTitle);

    void removeByBookUrl(String url);

    void removeByBookId(long id);
}

