package com.workintechS20Challange.charityStores;

import java.util.*;

public class BookData {
    private Map<String, List<Book>> allBooks;
    private String currentSortCriterion;

    public BookData() {
        allBooks = new HashMap<>();
        currentSortCriterion = "author";
    }

    public void addAuthorBook(Book book) {
        List<Book> bookList = allBooks.get(book.getAuthor());
        if (bookList == null) {
            bookList = new ArrayList<>();
            allBooks.put(book.getAuthor(), bookList);
        }
        bookList.add(book);
    }
    public void removeAuthorBook(Book book) {
        List<Book> bookList = allBooks.get(book.getAuthor());
        if (bookList != null) {
            bookList.remove(book);
            if (bookList.isEmpty()) {
                allBooks.remove(book.getAuthor());
            }
        }
    }
    public void sortBy(String sortBy) {
        currentSortCriterion = sortBy;
        Comparator<Book> comparator = BooksComparator.getComparator(currentSortCriterion);
        if (comparator != null) {
            for (List<Book> bookList : allBooks.values()) {
                Collections.sort(bookList, comparator);
            }
        }
    }
    public List<Book> filterByCriteria(String criteria, Object value) {
        BookFilter bookFilter = new BookFilter();
        return bookFilter.filterByCriteria(allBooks, criteria, value);
    }

    public String toStringFiltered(String criteria, Object value) {
        List<Book> filteredBooks = filterByCriteria(criteria, value);
        StringBuilder result = new StringBuilder();

        for (Book book : filteredBooks) {
            result.append(book).append("\n");
        }

        return result.toString();
    }

    public String toString() {
    StringBuilder result = new StringBuilder();

    for (Map.Entry<String, List<Book>> entry : allBooks.entrySet()) {
        String authorName = entry.getKey();
        List<Book> books = entry.getValue();
        result.append("Author: ").append(authorName).append("\n");

        if (!books.isEmpty()) {
            for (Book book : books) {
                result.append(book).append("\n");
            }
        }
    }
    return result.toString();
    }


}
