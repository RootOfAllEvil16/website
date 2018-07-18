package com.project.eva.model;

import com.googlecode.htmlcompressor.compressor.Compressor;
import com.project.eva.util.compressor.HtmlCompressor;
import com.project.eva.util.translator.Translator;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.HashSet;

import static com.project.eva.util.validator.ObjectValidator.isNotEmpty;
import static com.project.eva.util.validator.ObjectValidator.isNotNull;

public final class BookBuilder extends ModelBuilder<Book, BookBuilder> {

    private String title;

    private String url;

    private String author;

    private String description;


    private Collection<Chapter> chapters;


    BookBuilder() {
        this.chapters = new HashSet<>();
    }


    @Override
    public Book build() {
        final Book book = new Book();
        super.build(book);
        book.setTitle(getTitle());
        book.setUrl(getUrl());
        book.setAuthor(getAuthor());
        book.setDescription(getDescription());
        book.setChapters(getChapters());
        return book;
    }

    public BookBuilder addTitle(final String title) {
        this.title = title;
        return this;
    }

    public BookBuilder addUrl(final String url) {
        this.url = url;
        return this;
    }

    public BookBuilder addAuthor(final String author) {
        this.author = author;
        return this;
    }

    public BookBuilder addDescription(final String description) {
        this.description = description;
        return this;
    }


    public BookBuilder addChapters(final Collection<Chapter> chapters) {
        if (isNotEmpty(chapters)) {
            chapters.forEach(this::addChapter);
        }
        return this;
    }

    public BookBuilder addChapter(final Chapter chapter) {
        if (isNotNull(chapter)) {
            this.chapters.add(chapter);
        }
        return this;
    }

    public BookBuilder clearChapters() {
        this.chapters.clear();
        return this;
    }

    private String getTitle() {
        return isNotEmpty(this.title) ? this.title : "";
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
        final String title = getTitle();
        if (isNotEmpty(title)) {
            url = Translator.fromCyrillicToLatin(title) + "_" + generateRandomString();
        } else {
            url = "";
        }
        return url;
    }

    private String getAuthor() {
        return isNotEmpty(this.author) ? this.author : "";
    }


    private String getDescription() {
        final String description;
        if (isNotEmpty(this.description)) {
            final Compressor compressor = new HtmlCompressor();
            description = compressor.compress(this.description);
        } else {
            description = "";
        }
        return description;
    }



    private Collection<Chapter> getChapters() {
        return this.chapters;
    }
}

