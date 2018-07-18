package com.project.eva.model;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

import static com.project.eva.util.validator.ObjectValidator.isNotEmpty;
import static com.project.eva.util.validator.ObjectValidator.isNotNull;


@Entity
@Table(name = "books")
public class Book extends Model {

    private static final long serialVersionUID = 1L;


    @Column(name = "title", nullable = false)
    private String title = "";

    @Column(name = "url", nullable = false)
    private String url = "";

    @Column(name = "author")
    private String author = "";

    @Column(name = "description")
    private String description = "";

    @Transient
    private MultipartFile bookImage;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL)
    private Collection<Chapter> chapters = new HashSet<>();

    protected Book() {
    }

    @Override
    public String toString() {
        return "Book{" + super.toString() +
                ", title: " + this.title +
                ", url: " + this.url +
                ", author: " + this.author +
                ", description: " + this.description +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        boolean result = super.equals(object);
        if (result) {
            final Book other = (Book) object;
            result = this.title.equalsIgnoreCase(other.title) &&
                    this.url.equalsIgnoreCase(other.url);
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = this.title.hashCode();
        result = 31 * result + this.url.hashCode();
        result = 31 * result + this.author.hashCode();
        result = 31 * result + this.description.hashCode();

        return result;
    }

    public void addChapter(final Chapter chapter) {
        if (isNotNull(chapter)) {
            this.chapters.add(chapter);
        }
    }

    public void addChapters(final Collection<Chapter> chapters) {
        if (isNotEmpty(chapters)) {
            this.chapters.addAll(chapters);
        }
    }

    public void removeChapter(final Chapter chapter) {
        if (isNotNull(chapter)) {
            this.chapters.remove(chapter);
        }
    }

    public void removeChapters(final Collection<Chapter> chapters) {
        if (isNotEmpty(chapters)) {
            this.chapters.removeAll(chapters);
        }
    }

    public void clearChapters() {
        this.chapters.clear();
    }


    public Collection<Chapter> getChapters() {
        return getUnmodifiableList(this.chapters);
    }


    public void setChapters(final Collection<Chapter> chapters) {
        clearChapters();
        addChapters(chapters);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = isNotEmpty(title) ? title : "";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = isNotEmpty(url) ? url : "";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(final String description) {
        this.description = description;
    }


    public MultipartFile getBookImage() {
        return bookImage;
    }

    public void setBookImage(final MultipartFile bookImage) {
        this.bookImage = bookImage;
    }

    public static BookBuilder getBuilder() {
        return new BookBuilder();
    }
}
