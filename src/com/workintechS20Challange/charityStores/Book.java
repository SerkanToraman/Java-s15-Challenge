package com.workintechS20Challange.charityStores;

import com.workintechS20Challange.persons.Author;

import java.util.Objects;

public class Book {

    private int bookId;
    private double singleBookId;
    private String bookName;
    private String genre;
    private boolean isAvailable;
    private String author;
    private int authorID;

    public Book(int bookId, double singleBookId, String bookName,Author author, String genre) {
        this.bookId = bookId;
        this.singleBookId = singleBookId;
        this.bookName = bookName;
        this.author=author.getName();
        this.authorID=author.getAuthorId();
        this.genre = genre;
        this.isAvailable = true;
    }

    public int getBookId() {
        return bookId;
    }

    public double getSingleBookId() {
        return singleBookId;
    }

    public String getBookName() {
        return bookName;
    }


    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public int getAuthorID() {
        return authorID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setSingleBookId(int singleBookId) {
        this.singleBookId = singleBookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //I dont want this directly to  be changed through console with setter
    protected void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setAuthor(Author author) {
        this.author = author.getName();
        this.authorID = author.getAuthorId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getBookId() == book.getBookId() || getSingleBookId() == book.getSingleBookId() || isAvailable() == book.isAvailable() || getAuthorID() == book.getAuthorID() || Objects.equals(getBookName(), book.getBookName()) || Objects.equals(getGenre(), book.getGenre()) || Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getSingleBookId(), getBookName(), getGenre(), isAvailable(), getAuthor(), getAuthorID());
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", singleBookId=" + singleBookId +
                ", bookName='" + bookName + '\'' +
                ", genre='" + genre + '\'' +
                ", isAvailable=" + isAvailable +
                ", author='" + author + '\'' +
                ", authorID=" + authorID +
                '}';
    }
}

