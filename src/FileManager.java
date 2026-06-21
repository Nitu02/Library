package src;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME= "books.txt";

    public void saveBooks(ArrayList<Book> books){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(Book book:books){
                writer.write(
                    book.getBookId() + "," +
                    book.getBookTitle() + "," +
                    book.getAuthor() + "," +
                    book.isAvailable()+ "," +
                    (book.getIssuedTo() == null ? "null" :book.getIssuedTo().getUserId())
                );
                writer.newLine();
            }
            System.out.println("Books saved successfully!!!");

        }
        catch(IOException e){
            System.out.println("Error in saving Books: " +e.getLocalizedMessage());
        }

    }
    public void saveUsers(ArrayList<User> users){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"))){
            for(User user: users){
                writer.write(user.getUserId() + "," + user.getName());
                writer.newLine();
            }
            System.out.println("User saved successfully!!!!!!!");
        }catch(IOException e){
            System.out.println("Error saving users: "+ e.getMessage());
        }
    }
    //because load book must be added back to its existing place.
    public void loadBooks(Library library,UserManager userManager){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine())!=null){
                //System.out.println(line);
                String[] data = line.split(",");
                int bookId = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                boolean available = Boolean.parseBoolean(data[3]);
                String issuedUserId = data[4];

                Book book = new Book(bookId, title, author);
                book.setAvailability(available);
                if(!issuedUserId.equals("null")){
                    int userId = Integer.parseInt(issuedUserId);

                    User user = userManager.searchUserById(userId);

                    if(user!=null){
                        book.setIssuedTo(user);
                    }
                }
                library.loadBook(book);
            }
        }catch(IOException e){
            System.out.println("Error loading books: "+e.getMessage());
        }

    }
    public void loadUsers( UserManager userManager){
        try(BufferedReader reader = new BufferedReader(new FileReader("users.txt"))){
            String line;
            while((line =reader.readLine())!=null){
                String[] data = line.split(",");
                int userId =Integer.parseInt(data[0]);
                String name = data[1];

                User user = new User(userId, name);
                userManager.loadUser(user);

            }

        }catch(IOException e){
            System.out.println("Error in loading Users "+ e.getMessage());
        }
    }
    
}
