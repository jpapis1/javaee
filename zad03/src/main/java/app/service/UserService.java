package app.service;

import app.domain.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserService {
    public static ArrayList<User> usersList = new ArrayList<>();
    public static void addUser(User user) {
        usersList.add(user);
    }
    public static boolean userExists(String user) {
        for(int i  = 0;i<usersList.size();i++) {
            if(user.equals(usersList.get(i).getName())) {
                return true;
            }
        }
        return false;
    }
    public static User getUser(String username) {
        for(int i  = 0;i<usersList.size();i++) {
            if(username.equals(usersList.get(i).getName())) {
                return usersList.get(i);
            }
        }
        return null;
    }
}
