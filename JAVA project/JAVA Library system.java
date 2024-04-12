public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean availability;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.availability = true;
    }

    // Getters and setters
    // Display book details method
}

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // Similarly implement searchByAuthor() and displayAvailableBooks()
}

public class Member {
    private String name;
    private int memberID;
    private List<Book> borrowedBooks;

    public Member(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailability(false);
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println("Sorry, " + book.getTitle() + " is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailability(true);
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println("You haven't borrowed " + book.getTitle() + ".");
        }
    }

    // Display borrowed books method
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Creating books
        Book book1 = new Book("Java Programming", "John Doe", "123456789");
        Book book2 = new Book("Python Basics", "Jane Smith", "987654321");

        // Creating library
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);

        // Creating member
        Member member = new Member("Alice", 101);

        // Testing borrow and return functionality
        member.borrowBook(book1);
        member.borrowBook(book2);

        member.returnBook(book1);
    }
}
