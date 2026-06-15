package src;

public class Book{  
    private int bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookId, String title, String author){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.available=true;
    }

    public int getBookId(){
        return bookId;
    }
    public String getBookTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public boolean isAvailable(){
        return available;
    }

    public void setAvailability(boolean available){
        this.available=available;
    }

    @Override
    public String toString(){
        return "Book Id: " + bookId + ", Tittle: "+ title +", Author: "+ author+ ", Availability: " + available;
    }


}