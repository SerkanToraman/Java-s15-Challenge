package com.workintechS20Challange.persons;

import com.workintechS20Challange.charityStores.Book;
import com.workintechS20Challange.charityStores.BookData;
import com.workintechS20Challange.charityStores.BookTransaction;
import com.workintechS20Challange.persons.enums.PersonStatus;

import java.util.List;
import java.util.Scanner;

public class CharityEmployee extends Persons{

    protected CharityEmployee(String name, int IDNo, String phoneNum, boolean isAMember, Double accountMoney) {
        super(name, IDNo, phoneNum, isAMember, accountMoney);
        setPersonStatus(PersonStatus.CHARITYEMPLOYEE);
    }

    public Persons makeDonator(Persons member, BookTransaction bookTransaction) {
        if (member.getPersonStatus() != PersonStatus.DONATOR) {
            Persons donator = new Donator(
                    member.getName(),
                    member.getIDNo(),
                    member.getPhoneNum(),
                    member.IsBorrowAllowed(),
                    member.getAccountMoney()
            );
            donator.setPersonStatus(PersonStatus.DONATOR);
            donator.setBorrowAllowed(true);
            bookTransaction.transferTheBooks(member,donator);

            return donator;
        } else {
            System.out.println(getName() + " is already a donator.");
            return this;
        }
    }

    public void approveBorrow(Persons person) {
        if (getPersonStatus() == PersonStatus.CHARITYEMPLOYEE) {
            person.setBorrowAllowed(true);
            System.out.println(person.getName() + " borrow is approved.");
        } else {
            System.out.println("You don't have permission to approve membership.");
        }
    }
    public void disApproveBorrow(Persons person) {
        if (getPersonStatus() == PersonStatus.CHARITYEMPLOYEE) {
            person.setBorrowAllowed(false);
            System.out.println(person.getName() + " borrow is cancelled.");
        } else {
            System.out.println("You don't have permission to approve membership.");
        }
    }

    public void removeBookfromList(BookData bookData, Book book){
        bookData.removeAuthorBook(book);
    }

}
