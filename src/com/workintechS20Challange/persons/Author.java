package com.workintechS20Challange.persons;

import com.workintechS20Challange.charityStores.Book;
import com.workintechS20Challange.charityStores.BookData;
import com.workintechS20Challange.persons.enums.PersonStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author extends Persons{

    private List<Book> donatedBooks;
    public int  authorId;
    public Author(String name,int authorID) {
        super(name);
        this.authorId=authorID;
        setPersonStatus(PersonStatus.AUTHOR);
    }


    public Author(String name, int IDNo, String phoneNum, boolean canBorrow, Double accountMoney, int authorId) {
        super(name, IDNo, phoneNum, canBorrow, accountMoney);
        this.authorId = authorId;
        donatedBooks = new ArrayList<>();
    }

    public int getAuthorId() {
        return authorId;
    }
    public void donateBook(BookData bookDonation, Book book) {
        bookDonation.addAuthorBook(book);
        donatedBooks.add(book);
        setPersonStatus(PersonStatus.DONATOR);
        System.out.println(getName() + " has donated the book: " + book.getBookName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        if (!super.equals(o)) return false;
        return getAuthorId() == author.getAuthorId() && Objects.equals(donatedBooks, author.donatedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), donatedBooks, getAuthorId());
    }

    @Override
    public String toString() {
        return "Author{" +
                "AuthorName=" + getName()  +
                ", authorId=" + getAuthorId() +
                '}';
    }
}
