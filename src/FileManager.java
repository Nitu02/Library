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
                    book.isAvailable()
                );
                writer.newLine();
            }
            System.out.println("Books saved successfully!!!");

        }
        catch(IOException e){
            System.out.println("Error in saving Books: " +e.getLocalizedMessage());
        }

    }
    //because load book must be added back to its existing place.
    public void loadBook(Library library){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine())!=null){
                //System.out.println(line);
                String[] data = line.split(",");
                int bookId = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                boolean available = Boolean.parseBoolean(data[3]);

                Book book = new Book(bookId, title, author);
                book.setAvailability(available);
                library.loadBook(book);
            }
        }catch(IOException e){
            System.out.println("Error loading books: "+e.getMessage());
        }

    }
    
}
