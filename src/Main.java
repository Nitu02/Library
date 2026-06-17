package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        UserManager userManager = new UserManager();
        FileManager fileManager = new FileManager();
        fileManager.loadBook(library);
        userManager.addUser(new User(1,"Nitu"));
        userManager.addUser(new User(2,"Riddhi"));
        User user = userManager.searchUserById(1);
        Book book= library.findBookById(101);
        if(user != null && book != null){
            library.issueBookToUser(book, user);
        }


        System.out.println("========================== Library Management System ================================");

        while(true){
            System.out.println("\n ============= Menu ========================= \n ");
            System.out.println("1. Add Book");
            System.out.println("2. View Book");
            System.out.println("3. Search Book by Id");
            System.out.println("4. Search Book by title");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Remove  Book");
            System.out.println("8. Total Books");
            System.out.println("9. Save Book to File");
            System.out.println("\n---------------------User Management-----------------");
            System.out.println("10. Add User");
            System.out.println("11. View Users");
            System.out.println("\n--------------Exit--------------");
            System.out.println("12. Exit");

            System.out.println("Enter your Choice: ");
            int choice = sc.nextInt();

            if(choice ==12){
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

                    Book book1 = new Book(id,name,author);
                    library.addBook(book1);

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
                    System.out.println("Enter the Book Tittle: ");
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
                    library.deleteBookById(id);
                    break;
                }
                case 8:{
                    library.totalBook();
                    break;
                }
                case 9:{
                    fileManager.saveBooks(library.getBooks());
                    break;
                }
                case 10:{
                    System.out.println("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter User Name: ");
                    String name = sc.nextLine();

                    User user1 = new User(userId, name);
                    userManager.addUser(user1);
                    break;
                }
                case 11:{
                    userManager.viewUsers();
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
