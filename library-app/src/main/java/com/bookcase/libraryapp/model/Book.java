package com.bookcase.libraryapp.model;

import java.util.Objects;

public class Book {

    private String id;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String description;
    private int pageCount;
    private int progress;

    public Book(String id, String title, String author, String publisher, int year, String description,
                int pageCount, int progress) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.description = description;
        this.pageCount = pageCount;
        this.progress = progress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book mutableBook = (Book) o;
        return year == mutableBook.year && pageCount == mutableBook.pageCount && progress == mutableBook.progress && id.equals(mutableBook.id) && title.equals(mutableBook.title) && author.equals(mutableBook.author) && publisher.equals(mutableBook.publisher) && description.equals(mutableBook.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, publisher, year, description, pageCount, progress);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                ", progress=" + progress +
                '}';
    }
}
