package src;

import java.util.ArrayList;
public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book){
        for(Book b :books){
            if(b.getBookId()==book.getBookId()){
                System.out.println("Book Id already Exists!!!!!!!!!!!!!!!!!");
                return;
            }
        }
        books.add(book);
        System.out.println("Book Added to Library Successfully!!!!!!!!!!");
    }
    public void loadBook(Book book){
        // to tell that book are loaded in existing place.
        // System.out.println("Book Loaded Successfully");  
        books.add(book);
    }

    // This will allow the File Manager to read the Books from Library
    public ArrayList<Book> getBooks(){
        return books;
    }
    public void totalBook(){
        System.out.println("Total Books in Library are: "+ books.size());
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
    public void deleteBookById(int BookId){
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
    public Book findBookById(int bookId){
        for(Book book:books){
            if(book.getBookId()==bookId){
                return book;
            }
        }
        return null;
    }

    public void issueBookToUser(Book book, User user){
        if(!book.isAvailable()){
            System.out.println("Book Already Issued!!!!!!!!!");
            return;
        }
        book.setAvailability(false);
        book.setIssuedTo(user);
        System.out.println("Book Issued To "+ user.getName());
    }
    public void issueBookToUser(int bookId, int userId,UserManager userManager){
        Book book = findBookById(bookId);
        if(book == null){
            System.out.println("Book Not Found");
            return;
        }
        User user = userManager.searchUserById(userId);
        if(user == null){
            System.out.println("User not Found");
            return;
        }
        if(!book.isAvailable()){
            System.out.println("Book Already Issued!!!!!!!!");
            return;
        }
        book.setAvailability(false);
        book.setIssuedTo(user);

        System.out.println("Book issued To: "+ user.getName());
    }
    
}
