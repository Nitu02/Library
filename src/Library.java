package src;

import java.util.ArrayList;
public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
        System.out.println("Book Added to Library Successfully!!!!!!!!!!");
    }
    public void viewBooks(){
        if(books.isEmpty()){
            System.out.println("Libraray is Empty right now!!!!!");
        }
        else{
            for( Book book : books){
                System.out.println(book);

            }
        }
    }
    
    public void searchBookById(int BookId){
        for(Book book:books){
            if(book.getBookId()==BookId){
                System.out.println("Book Found");
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book Not Found");

    }
    public void deletedBookById(int BookId){
        for(Book book:books){
            if(book.getBookId()==BookId){
                books.remove(book);
                System.out.println("Book Deleted Successfully!!!!!!!!");
                return;
            }
        }
        System.out.println("Book Not Found");
    }
    public void issueBook(int BookId){
        for(Book book:books){
            if(book.getBookId()==BookId){
                if(book.isAvailable()==true){
                    book.setAvailability(false);
                    System.out.println("Book Issued Successfully");
                    return;
                }
                else{
                    System.out.println("Book Already issued");
                }
                return;              
            }
        }
        System.out.println("Book Not Found");
    }
    public void returnBook(int BookId){
        for(Book book:books){
            if(book.isAvailable()==false){
                book.setAvailability(true);
                System.out.println("Book Return Successfully!!!!!!!!!!!!!!!!");
            }
            else{
                System.out.println("Book was not Issued.");
            }
            return;
        }
        System.out.println("Book Not Found");
    }
    public void searchBookByTitle(String title){
        for(Book book :books){
            if(book.getBookTitle().equalsIgnoreCase(title)){
                System.out.println("Book Found");
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book with that title not Found");
    }
    
}
