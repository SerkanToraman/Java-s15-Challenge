package com.workintechS20Challange.persons;

import com.workintechS20Challange.charityStores.Book;
import com.workintechS20Challange.charityStores.BookData;
import com.workintechS20Challange.charityStores.BookTransaction;
import com.workintechS20Challange.persons.enums.PersonStatus;

import java.util.ArrayList;
import java.util.List;

public class Donator extends Persons{

    private List<Book> donatedBooks;

    public Donator(String name, int IDNo, String phoneNum, boolean isAMember, Double accountMoney) {
        super(name, IDNo, phoneNum, isAMember, accountMoney);
        donatedBooks = new ArrayList<>();
    }


    public void donateBook(BookData bookDonation, Book book) {
            bookDonation.addAuthorBook(book);
            donatedBooks.add(book);
            setPersonStatus(PersonStatus.DONATOR);
            System.out.println(getName() + " has donated the book: " + book.getBookName());
    }

    public void borrowBook(BookTransaction bookTransaction, Book book) {
        if(this.IsBorrowAllowed()) {
            if(checkAccount(this)) {
                if(bookTransaction.borrowBookTransaction(this, book)){
                    subtractMoney(this);
                };
            }else{
                System.out.println(this.getName()+ " : You have not enough account balance");
            }
        }else{
            System.out.println(this.getName()+ ", please apply for being a member");
        }
    }
    public void returnBook(BookTransaction bookTransaction,Book book) {
        bookTransaction.returnBookTransaction(this,book);
        addMoney(this);
    }

}
