package com.workintechS20Challange.charityStores;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BooksComparator {
    public static class compareByAuthor implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.getAuthor().compareTo(book2.getAuthor());
        }
    }
    public static class compareByGenre implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.getGenre().compareTo(book2.getGenre());
        }
    }

    public static class compareByBookName implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.getBookName().compareTo(book2.getBookName());
        }
    }

    public static Comparator<Book> getComparator(String sortBy) {
        switch (sortBy) {
            case "author":
                return new compareByAuthor();
            case "genre":
                return new compareByGenre();
            case "bookName":
                return new compareByBookName();
            default:
                System.out.println("Invalid sorting option: " + sortBy);
                return null;
        }
    }


}
