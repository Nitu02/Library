package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        System.out.println("========================== Library Management System ================================");

        while(true){
            System.out.println("\n ============= Menu ========================= \n ");
            System.out.println("1. Add Book");
            System.out.println("2. View Book");
            System.out.println("3.  Search Book by Id");
            System.out.println("4.  Search Book by title");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Remove  Book");
            System.out.println("8. Exiting!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            System.out.println("Enter your Choice: ");
            int choice = sc.nextInt();

            if(choice ==8){
                break;

            }
            switch(choice){
                case 1:{
                    System.out.println("Enter the Book Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Book Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter the Book Author Name: ");
                    String author = sc.nextLine();

                    Book book = new Book(id,name,author);
                    // book.setAvailability(true);
                    library.addBook(book);

                    break;

                }
                case 2:{
                    System.out.println("Books in Library: ");
                    library.viewBooks();
                    break;
                }
                case 3:{
                    System.out.println("Enter the Id: ");
                    int id = sc.nextInt();
                    library.searchBookById(id);
                    break;
                }
                case 4:{
                    System.out.println("Enter the Book Title: ");
                    sc.nextLine();
                    String title = sc.nextLine();
                    library.searchBookByTitle(title);
                    break;
                }
                case 5:{
                    System.out.println("Enter the Id of Book You want to Isssue: ");
                    int id = sc.nextInt();
                    library.issueBook(id);
                    break;

                }
                case 6:{
                    System.out.println("Enter the Id ofBook You want to Return: ");
                    int id= sc.nextInt();
                    library.returnBook(id);
                    break;
                }
                case 7:{
                    System.out.println("Enter the Id of Book that you want to Remove from Library: ");
                    int id = sc.nextInt();
                    library.deletedBookById(id);
                    break;
                }
                default:
                    System.out.println("Invalid Choice!!!!!!!!!!!!!!!!!");
                    break;

            }
                

        }
        sc.close();

    }
    
}
