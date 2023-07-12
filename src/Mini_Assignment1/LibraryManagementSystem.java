package Mini_Assignment1;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}

class Library {
    private List<Book> books;
    static Logger logger = Logger.getLogger(Library.class);

    public Library() {
        books = new ArrayList<>();
    }

    /**
     * Adds a book to the library.
     * @param book The book to be added.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes a book from the library.
     * @param book The book to be removed.
     */
    public void removeBook(Book book) {
        books.remove(book);
    }

    /**
     * Displays all the books in the library.
     */
    public void displayBooks() {
        if (books.isEmpty()) {
            logger.info("The library is empty.");
        } else {
            logger.info("Books in the library:");
            for (Book book : books) {
                logger.info("Title: " + book.getTitle());
                logger.info("Author: " + book.getAuthor());
                logger.info("Year: " + book.getYear());
            }
        }
    }
}

public class LibraryManagementSystem {

    static Logger logger = Logger.getLogger(LibraryManagementSystem.class);
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("1984", "George Orwell", 1949);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        logger.info("Books in the library:");
        library.displayBooks();

        library.removeBook(book2);

        logger.info("Updated list of books in the library:");
        library.displayBooks();
    }
}
