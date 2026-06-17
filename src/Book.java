package src;

public class Book{  
    private int bookId;
    private String title;
    private String author;
    private boolean available;
    private User issuedTo;

    public Book(int bookId, String title, String author){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.available=true;
        this.issuedTo=null;
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
    public User getIssuedTo(){
        return issuedTo;
    }
    public void setIssuedTo(User issuedTo){
        this.issuedTo=issuedTo;
    }

    @Override
    public String toString(){
        return "Book Id: " + bookId + ", Tittle: "+ title +", Author: "+ author+ ", Availability: " + available + ", Issued To: "+ (issuedTo == null ? "None" : issuedTo.getName());
    }

}