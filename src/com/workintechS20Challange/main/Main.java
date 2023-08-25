package com.workintechS20Challange.main;

import com.workintechS20Challange.charityStores.Book;
//import com.workintechS20Challange.charityStores.BookData;
import com.workintechS20Challange.charityStores.BookData;
import com.workintechS20Challange.charityStores.BookTransaction;
import com.workintechS20Challange.charityStores.BooksComparator;
import com.workintechS20Challange.persons.*;

import java.util.ArrayList;
import java.util.List;

import static com.workintechS20Challange.charityStores.Creators.createABook;
import static com.workintechS20Challange.charityStores.Creators.editBook;

public class Main {
    public static void main(String[] args) {

        BookData bookData = new BookData();
        BookTransaction bookTransaction = new BookTransaction(bookData);
        BooksComparator booksComparator =new BooksComparator();
        List<Author> authorList = new ArrayList<>();




        //////////Create Persons and Authors
        Persons personSerkanToraman = new Member ("Serkan Toraman",2414,"05421111111",false, 150.0);
        Persons personMineToraman = new Member("Mine Toraman",2414,"05421111342111",false, 150.0);
        Persons personAsudeToraman = new Member("Asude Toraman",242314,"0542111134221",false, 150.0);
        Persons personMusacanOzic = new Member("Musacan Ozic",2423314,"05421211134221",false, 330.0);
        System.out.println("-----------------------------");
        System.out.println(personMusacanOzic);
        Persons personSerkannToraman = new Author("Serkan Toraman",1);
        authorList.add((Author) personSerkannToraman);
        Persons personAytacSahin = new Author("Aytaç Şahin",2);
        authorList.add((Author) personAytacSahin);
        Persons personDogancanKinik = new Author("Dogancan Kınık",324432,"0542212923",false,100.00,3);
        authorList.add((Author) personDogancanKinik);
        System.out.println("-----------------------------");
        System.out.println(personDogancanKinik);


        //////////Create books 2 versions call create book Static method or directly create from the class
//        Book book1 = createABook((Author)personAytacSahin);
        Book book1 =new Book(1,1.1,"The Journay of a JAVA developer",(Author)personSerkannToraman,"Tech");
        Book book2 =new Book(2,1.2,"The Journay of a JAVA developer",(Author)personSerkannToraman,"Tech");
        Book book3 =new Book(3,1,"My backens Story",(Author)personAytacSahin,"Tech");
        Book book4 =new Book(4,4.1,"Javanın Püf Noktaları",(Author)personAytacSahin,"Tech");
        Book book5 =new Book(5,4.2,"Javanın Püf Noktaları",(Author)personAytacSahin,"Tech");
        Book book6 =new Book(6,6,"Java Eğitimi",(Author)personDogancanKinik,"Tech");
        Book book7 =new Book(7,7,"Java ve Oyun Sektörü",(Author)personDogancanKinik,"Tech");
        System.out.println("-----------------------------");
        System.out.println(book7);
//        editBook(book1,authorList);

        /////////Convert Person into charity member so that member can have the authorith to manage the system
        Persons charityEmployeeSerkanToraman = personSerkanToraman.becomeCharityMember();
        //////// Charithmember allows the Members to donate
        Persons donatorMineToraman = ((CharityEmployee) charityEmployeeSerkanToraman).makeDonator(personMineToraman,bookTransaction);
        ////////Donator can donate book
        ((Donator)donatorMineToraman).donateBook(bookData,book1);
        ((Donator)donatorMineToraman).donateBook(bookData,book2);
        ((Donator)donatorMineToraman).donateBook(bookData,book3);
        ((Donator)donatorMineToraman).donateBook(bookData,book4);
        ((Donator)donatorMineToraman).donateBook(bookData,book5);
        ((Donator)donatorMineToraman).donateBook(bookData,book6);
        ((Donator)donatorMineToraman).donateBook(bookData,book7);


        ///////
//        System.out.println(bookData.toStringFiltered("genre", "Tech"));
//        System.out.println(bookData);
//        bookData.sortBy("bookName");
//        System.out.println(bookData);
//        ((CharityEmployee) charityEmployeeSerkanToraman).removeBookfromList(bookData,book7);
//        System.out.println(bookData);





//
//        ((Member)personMusacanOzic).borrowBook(bookTransaction,book3);
//        System.out.println("1book3-----------------------------");
        System.out.println(personMusacanOzic);
        ((CharityEmployee)charityEmployeeSerkanToraman).approveBorrow(personMusacanOzic);
        //Intend to borrow book 6 but the user couldnt borrow it as it is not donated as a result no in the book list
        ((Member) personMusacanOzic).borrowBook(bookTransaction,book1);
        System.out.println("1.Borrow-----------------------------");
        System.out.println(personMusacanOzic);
//        System.out.println("isAvailablefalse-----------------------------");
//        System.out.println(bookData);
//        System.out.println("-----------------------------");
//        ((Member) personMusacanOzic).borrowBook(bookTransaction,book1);
//        System.out.println("Failed Borrow-----------------------------");
//        System.out.println(personMusacanOzic);
        ((CharityEmployee)charityEmployeeSerkanToraman).approveBorrow(personAsudeToraman);
        ((Member)personAsudeToraman).borrowBook(bookTransaction,book2);
        ((Member) personMusacanOzic).borrowBook(bookTransaction,book4);
        ((CharityEmployee)charityEmployeeSerkanToraman).disApproveBorrow(personMusacanOzic);
        ((Member) personMusacanOzic).borrowBook(bookTransaction,book5);
        ((CharityEmployee)charityEmployeeSerkanToraman).approveBorrow(personMusacanOzic);
        ((Member) personMusacanOzic).borrowBook(bookTransaction,book5);
        ((Member) personMusacanOzic).borrowBook(bookTransaction,book6);
        System.out.println("Total 4 borrows-----------------------------");
//       ((Member) personMusacanOzic).borrowBook(bookTransaction,book7);

//        //// Filtration according to borrow
//        System.out.println("-----------------------------");
//        System.out.println(personMusacanOzic);
//        System.out.println("-----------------------------");
//        System.out.println(bookTransaction);
//        System.out.println("-----------------------------");
        System.out.println(bookTransaction.getBorrowedBooksbyId("Musacan Ozic"));


        ////// Make a person a donator, the borrowed books also transferred, bookborrow size blocakage
        Persons donatorMusacanOzic = ((CharityEmployee) charityEmployeeSerkanToraman).makeDonator(personMusacanOzic,bookTransaction);
        ((Donator)donatorMineToraman).donateBook(bookData,book7);
        System.out.println("-----------------------------");
        System.out.println(donatorMusacanOzic);
        ((Donator)donatorMusacanOzic).returnBook(bookTransaction,book1);
        System.out.println(bookTransaction.getBorrowedBooksbyId("Musacan Ozic"));
        System.out.println(donatorMusacanOzic);
        System.out.println("-----------------------------");
        System.out.println(book1);
        ((Member)personAsudeToraman).returnBook(bookTransaction,book2);
        //transfer again
        ((Member)personAsudeToraman).returnBook(bookTransaction,book2);

        System.out.println(bookTransaction.getBorrowedBooksbyId("Musacan Ozic"));
        System.out.println(donatorMusacanOzic);
        ((Donator)donatorMusacanOzic).borrowBook(bookTransaction,book7);
        System.out.println(donatorMusacanOzic);
        donatorMusacanOzic.setAccountMoney(320.0);
        ((Donator)donatorMusacanOzic).borrowBook(bookTransaction,book2);
        System.out.println(bookTransaction.getBorrowedBooksbyId("Musacan Ozic"));
        ((Donator)donatorMusacanOzic).borrowBook(bookTransaction,book1);








    }
}