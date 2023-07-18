package org.example;


import org.example.business.abstracts.UserService;
import org.example.business.concretes.UserManager;
import org.example.dataAccess.concretes.HibernateUserDao;
import org.example.entities.concretes.User;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserManager(new HibernateUserDao());
        User user = new User("asad","bdasd","atlmeh@gmail.com","123456");
        userService.add(user);
        User user1 = new User("asaasd","bdasfsdafd","sdfdsafdsaf@com.com","123fdag456");
        userService.add(user);
    }
}