package src;

import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> users = new ArrayList<>();
    
    public void addUser(User user){
        for(User u : users){
            if(u.getUserId()==user.getUserId()){
                System.out.println("User ID already exists!");
                return;
            }
        }
        users.add(user);
        System.out.println("User added Successfully!!!!!!!!!");
    }
    public ArrayList<User> getUsers(){
        return users;
    }
    public void loadUser(User user){
        users.add(user);
    }
    public void viewUsers(){
        if(users.isEmpty()){
            System.out.println("No users Found!");
            return;
        }
        for(User user :users){
            System.out.println(user);
        }
    }
    public User searchUserById(int id){
        for(User user :users){
            if(user.getUserId()==id){
                return user;
            }
        }
        return null;
    }
    
}
