package com.project.eva.model;

import com.project.eva.util.generator.Generator;
import com.project.eva.util.generator.StringGenerator;
import com.project.eva.util.translator.Translator;

import java.util.Collection;
import java.util.HashSet;

import static com.project.eva.util.validator.ObjectValidator.isNotEmpty;
import static com.project.eva.util.validator.ObjectValidator.isNotNull;

public final class ChapterBuilder extends ModelBuilder<Chapter, ChapterBuilder> {

   /* private static final char[] CODE_PATTERN = "1234567890".toCharArray();

    private static final int CODE_LENGTH = 1;*/

    private String chapterNumber = "";

    private String chapterTitle = "";

    private String url = "";

    private String music = "";

    private String text ="";

    private Book book;


    ChapterBuilder() {

    }

    @Override
    public Chapter build() {
        final Chapter chapter = new Chapter();
        chapter.setChapterNumber(getChapterNumber());
        chapter.setChapterTitle(getChapterTitle());
        chapter.setUrl(getUrl());
        chapter.setBook(getBook());
        chapter.setMusic(getMusic());
        chapter.setText(getText());
        return chapter;
    }

    public ChapterBuilder addChapterNumber(final String chapterNumber) {
        this.chapterNumber = chapterNumber;
        return this;
    }

    public ChapterBuilder addChapterTitle(final String chapterTitle) {
        this.chapterTitle = chapterTitle;
        return this;
    }

    public ChapterBuilder addUrl(final String url) {
        this.url = url;
        return this;
    }
public ChapterBuilder addMusic(final String music){
        this.music = music;
        return this;
}
public ChapterBuilder addText(final String text){
        this.text = text;
        return this;
}
    public ChapterBuilder addBook(final Book book) {
        this.book = book;
        return this;
    }




    private String getChapterNumber() {
        return isNotEmpty(this.chapterNumber) ? this.chapterNumber : "";
    }

    private String getChapterTitle() {
        return isNotEmpty(this.chapterTitle) ? this.chapterTitle : "";
    }

    protected String getUrl() {
        final String url;
        if (isNotEmpty(this.url)) {
            url = this.url;
        } else {
            url = generateUrl();
        }
        return url;
    }

    private String generateUrl() {
        final String url;
        final String chapterTitle = getChapterTitle();
        if (isNotEmpty(chapterTitle)) {
            url = Translator.fromCyrillicToLatin(chapterTitle) + "_" + generateRandomString();
        } else {
            url = "";
        }
        return url;
    }

private String getMusic(){
        return isNotEmpty(this.music)? this.music: "";
}

private String getText(){return isNotEmpty(this.text)? this.text: "";}

    private Book getBook() {
        final Book book;
        if (isNotNull(this.book)) {
            book = this.book;
        } else {
            final Builder<Book> bookBuilder = Book.getBuilder();
            book = bookBuilder.build();
        }
        return book;
    }




}
