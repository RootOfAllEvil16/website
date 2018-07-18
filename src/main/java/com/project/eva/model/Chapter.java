package com.project.eva.model;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static com.project.eva.util.validator.ObjectValidator.isNotEmpty;
import static com.project.eva.util.validator.ObjectValidator.isNotNull;


@Entity
@Table(name = "chapters")
public class Chapter extends Model {

    private static final long serialVersionUID = 1L;

    @Column(name = "chapterNumber", nullable = false)
    private String chapterNumber = "";

    @Column(name = "chapterTitle", nullable = false)
    private String chapterTitle;

    @Column(name = "url", nullable = false)
    private String url = "";

    @Column(name = "music")
    private String music = "";

    @Column(name = "text")
    private String text = "";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @Transient
    private MultipartFile chapterImage;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("chapterTitle: ").append(this.chapterTitle)
                .append("\nchapterNumber: ")
                .append(this.chapterNumber)
                .append("\nmusic: ")
                .append(this.music)
                .append("\ntext:")
                .append(this.text);
        if (this.book != null) {
            sb.append("\nBook: ")
                    .append(this.book.getTitle());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        boolean result = super.equals(object);
        if (result) {
            final Chapter chapter = (Chapter) object;
            result = this.chapterNumber.equals(chapter.chapterNumber) &&
                    this.chapterTitle.equals(chapter.chapterTitle) &&
                    this.url.equals(chapter.url) &&
                    this.music.equals(chapter.music) &&
                    this.text.equals(chapter.text);
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = this.chapterNumber.hashCode();
        result = 31 * result + this.chapterTitle.hashCode();
        result = 31 * result + this.url.hashCode();
        result = 31 * result + this.music.hashCode();
        result = 31 * result + this.text.hashCode();

        return result;
    }


    public String getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(final String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(final String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }


    public String getMusic() {
        return music;
    }

    public void setMusic(final String music) {
        this.music = music;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(final Book book) {
        this.book = book;
    }


    public MultipartFile getChapterImage() {
        return chapterImage;
    }

    public void setChapterImage(final MultipartFile chapterImage) {
        this.chapterImage = chapterImage;
    }

    public static ChapterBuilder getBuilder() {
        return new ChapterBuilder();
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

}





