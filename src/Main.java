package src;

public class Main {
    public static void main(String[] args){

        Library library = new Library();
        Book book1 = new Book( 101, " Java Programming", " Chris Martin ");
        Book book2 = new Book( 102, " Java Programming Part 02", " Chris Martin ");

        library.addBook(book1);
        library.addBook(book2);

        System.out.println("\n  =========== Books in Library ================");
        library.viewBooks();
        library.searchBookById(102);
        library.deletedBookById(102);
        library.searchBookById(102);
        library.viewBooks();
        library.issueBook(102);
        library.issueBook(101);
        library.issueBook(101);
        library.viewBooks();
        library.returnBook(101);
        library.viewBooks();

    }
    
}
