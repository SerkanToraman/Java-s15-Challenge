package com.workintechS20Challange.charityStores;

import com.workintechS20Challange.persons.Member;
import com.workintechS20Challange.persons.Persons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookTransaction {

    private Map<Persons, List<Book>> borrowedBooks;
    private BookData bookData;


    public BookTransaction(BookData bookData) {
        this.bookData = bookData;
        borrowedBooks = new HashMap<>();
    }

    public Map<Persons, List<Book>> getBorrowedBooks() {
        return borrowedBooks;
    }

        public String getBorrowedBooksbyId(String username) {
        List<Book> borrowedBooksForUsername = new ArrayList<>();

        for (Map.Entry<Persons, List<Book>> entry : borrowedBooks.entrySet()) {
            Persons person = entry.getKey();
            if (person.getName().equalsIgnoreCase(username)) {
                borrowedBooksForUsername.addAll(entry.getValue());
            }
        }
            StringBuilder result = new StringBuilder();

            result.append("Borrowed books for ").append(username).append(":\n");

            if (borrowedBooksForUsername.isEmpty()) {
                result.append("No books borrowed.\n");
            } else {
                for (int i = 0; i < borrowedBooksForUsername.size(); i++) {
                    Book book = borrowedBooksForUsername.get(i);
                    result.append((i + 1)).append(". ").append(book.getBookName()).append("\n");
                }
            }

            return result.toString();
    }

    public boolean borrowBookTransaction(Persons person, Book book) {
        if (bookData.filterByCriteria("bookId",book.getBookId()).contains(book) && book.isAvailable()) {
            List<Book> borrowerBookList = borrowedBooks.get(person);
            if (borrowerBookList == null) {
                borrowerBookList = new ArrayList<>();
                borrowerBookList.add(book);
                book.setAvailable(false);
                borrowedBooks.put(person, borrowerBookList);
                return true;
            }
            if (borrowerBookList.size() < 5) {
                book.setAvailable(false);
                borrowerBookList.add(book);
                return true;
            } else {
                System.out.println(person.getName() + " has already borrowed 5 books and cannot borrow more.");
                return false;
            }
        }
        else {
            System.out.println("The book " + book.getBookName() + " with ID number " + book.getBookId() + " is not available for borrowing.");
            return false;
        }
    }
    public void returnBookTransaction(Persons person, Book book) {
        List<Book> borrowerBookList = borrowedBooks.get(person);
        if (borrowerBookList != null && borrowerBookList.contains(book)) {
            borrowerBookList.remove(book);
            book.setAvailable(true); // Mark the book as available
        }else {
            System.out.println(person.getName() + " did not borrow this book or it has already been returned.");
        }
    }

    public void transferTheBooks(Persons member,Persons donator) {
        List<Book> memberBorrowedBooks = borrowedBooks.get(member);

        if (memberBorrowedBooks != null && !memberBorrowedBooks.isEmpty()) {
            List<Book> donatorBorrowedBooks = borrowedBooks.getOrDefault(donator, new ArrayList<>());
            donatorBorrowedBooks.addAll(memberBorrowedBooks);

            borrowedBooks.put(donator, donatorBorrowedBooks);
            borrowedBooks.remove(member); // Remove the member from the borrowedBooks map

        }
    }



    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Persons, List<Book>> entry : borrowedBooks.entrySet()) {
            Persons person = entry.getKey();
            List<Book> memberBorrowedBooks = entry.getValue();

            result.append("Member: ").append(person.getName()).append("\n");

            if(memberBorrowedBooks.size()==0){
                result.append("There is no borrowed book \n");
            }else {
                for (Book book : memberBorrowedBooks) {
                    result.append("Borrowed Book id: ").append(book.getBookId()).append(" with the title of ").append(book.getBookName()).append("\n");
                }
            }
        }

        return result.toString();
    }


}
