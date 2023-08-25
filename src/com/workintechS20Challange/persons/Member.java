package com.workintechS20Challange.persons;

import com.workintechS20Challange.charityStores.Book;
import com.workintechS20Challange.charityStores.BookTransaction;
import com.workintechS20Challange.persons.enums.PersonStatus;

public class Member extends Persons {


    public Member(String name, int IDNo, String phoneNum, boolean borrowAllowed, Double accountMoney) {
        super(name, IDNo, phoneNum, borrowAllowed, accountMoney);
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







