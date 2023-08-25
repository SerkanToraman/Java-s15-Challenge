package com.workintechS20Challange.charityStores;

import com.workintechS20Challange.persons.Author;

import java.util.List;
import java.util.Scanner;

public class Creators {
    public static Book createABook(Author author){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();

        System.out.print("Enter  SingleBook ID: ");
        double singleBookId = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();

        System.out.print("Enter book genre: ");

        String bookGenre = scanner.nextLine();



        Book book = new Book(bookId, singleBookId, bookTitle, author, bookGenre);
        return book;

    }
    public static void editBook(Book book, List<Author> existingAuthors){

        Scanner scanner = new Scanner(System.in);

        System.out.print("What would you like to edit in the Book? (i.e. BookId,singleBookId,bookTitle,Author,genre)");
        String changeRequest = scanner.nextLine();

            switch(changeRequest){
                case "BookId":
                    System.out.print("Enter new Book ID: ");
                    int newBookId = scanner.nextInt();
                    scanner.nextLine();
                    book.setBookId(newBookId);
                    break;
                case "singleBookId":
                    System.out.print("Enter new SingleBook ID: ");
                    int newSingleBookId = scanner.nextInt();
                    book.setSingleBookId(newSingleBookId);
                    break;
                case "bookTitle":
                    System.out.print("Enter new Book Title: ");
                    String newBookTitle = scanner.nextLine();
                    book.setBookName(newBookTitle);
                    break;
                case "Author":
                    System.out.print("Enter the Author: ");
                    String authorName = scanner.nextLine();

                    Author selectedAuthor = null;
                    for (Author existingAuthor : existingAuthors) {
                        if (existingAuthor.getName().equalsIgnoreCase(authorName)) {
                            selectedAuthor = existingAuthor;
                            break;
                        }
                    }

                    if (selectedAuthor != null) {
                        book.setAuthor(selectedAuthor);
                        System.out.println("Author updated: " + selectedAuthor.getName());
                    } else {
                        System.out.println("Author not found.");
                    }
                    break;
                case "genre":
                    System.out.print("Enter new Genre: ");
                    String newGenre = scanner.nextLine();
                    book.setGenre(newGenre);
                    break;
                default:
                    System.out.println("Invalid change request.");

            }
                System.out.println("Updated Book: " + book);

    }

}
