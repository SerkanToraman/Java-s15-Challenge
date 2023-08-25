package com.workintechS20Challange.charityStores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookFilter {
    public static List<Book> filterByGenre(Map<String, List<Book>> allBooks, String genre) {
        List<Book> filteredBooks = new ArrayList<>();
        for (List<Book> bookList : allBooks.values()) {
            for (Book book : bookList) {
                if (book.getGenre().equalsIgnoreCase(genre)) {
                    filteredBooks.add(book);
                }
            }
        }
        return filteredBooks;
    }
    public static List<Book> filterByBookName(Map<String, List<Book>> allBooks, String bookName) {
        List<Book> filteredBooks = new ArrayList<>();

        for (List<Book> bookList : allBooks.values()) {
            for (Book book : bookList) {
                if (book.getBookName().equalsIgnoreCase(bookName)) {
                    filteredBooks.add(book);
                }
            }
        }
        return filteredBooks;
    }

    public static List<Book> filterByBookId(Map<String, List<Book>> allBooks, int bookId) {
        List<Book> filteredBooks = new ArrayList<>();
        for (List<Book> bookList : allBooks.values()) {
            for (Book book : bookList) {
                if (book.getBookId()==bookId) {
                    filteredBooks.add(book);
                }
            }
        }
        return filteredBooks;
    }
    public static List<Book> filterByAvailability(Map<String, List<Book>> allBooks, boolean isAvailable) {
        List<Book> filteredBooks = new ArrayList<>();
        for (List<Book> bookList : allBooks.values()) {
            for (Book book : bookList) {
                if (book.isAvailable()==isAvailable) {
                    filteredBooks.add(book);
                }
            }
        }
        return filteredBooks;
    }
    public static List<Book> filterByAuthor(Map<String, List<Book>> allBooks, String author) {
        List<Book> filteredBooks = new ArrayList<>();
        for (List<Book> bookList : allBooks.values()) {
            for (Book book : bookList) {
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    filteredBooks.add(book);
                }
            }
        }
        return filteredBooks;
    }
    public List<Book> filterByCriteria(Map<String, List<Book>> allBooks, String criteria, Object value) {
        switch (criteria) {
            case "genre":
                return BookFilter.filterByGenre(allBooks, (String) value);
            case "bookName":
                return BookFilter.filterByBookName(allBooks, (String) value);
            case "author":
                return BookFilter.filterByAuthor(allBooks, (String) value);
            case "bookId":
                return BookFilter.filterByBookId(allBooks, (int) value);
            case "availability":
                return BookFilter.filterByAvailability(allBooks, (boolean) value);
            default:
                System.out.println("Invalid filtering criteria: " + criteria);
                return new ArrayList<>(); // Return an empty list for invalid criteria
        }


    }

}
