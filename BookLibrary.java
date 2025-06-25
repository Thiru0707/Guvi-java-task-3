package task3;


class Book {
    private int ID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int ID, String title, String author, boolean isAvailable) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    
    public int getBookID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

  
    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}


class Library {
    private Book[] books;
    private int numBooks;

   
    public Library() {
        books = new Book[100];
        numBooks = 0;
    }

    
    public void addBook(Book book) {
        if (numBooks < books.length) {
            books[numBooks++] = book;
            System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor());
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public boolean removeBook(int bookID) {
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getBookID() == bookID) {
                for (int j = i; j < numBooks - 1; j++) {
                    books[j] = books[j + 1];
                }
                numBooks--;
                System.out.println("Book removed: " + books[i].getTitle() + " by " + books[i].getAuthor());
                return true;
            }
        }
        System.out.println("Book not found.");
        return false;
    }

    
    public Book searchBook(int bookID) {
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getBookID() == bookID) {
                return books[i];
            }
        }
        System.out.println("Book not found.");
        return null;
    }

  
    public void displayBooks() {
        if (numBooks == 0) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (int i = 0; i < numBooks; i++) {
                System.out.println("Book ID: " + books[i].getBookID() + ", Title: " + books[i].getTitle() + ", Author: " + books[i].getAuthor() + ", Available: " + books[i].isAvailable());
            }
        }
    }
}


public class BookLibrary {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book(1, "Ponniyin selvan", "Kalki", true));
        library.addBook(new Book(2, "Vandhiyathevan Vaal", "Vikraman", true));
        library.addBook(new Book(3, "Parthiban Kanavu", "kalki ", true));
        library.addBook(new Book(4, "One piece", "Oda ", true));

        System.out.println();

        
        library.displayBooks();

        System.out.println(); 

        
        Book book = library.searchBook(2);
        if (book != null) {
            System.out.println("Found book: " + book.getTitle() + " by " + book.getAuthor());
        }
        System.out.println();

        library.removeBook(4);
        System.out.println();

        library.displayBooks();
    }
}