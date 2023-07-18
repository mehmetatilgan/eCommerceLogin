package org.example.business.concretes;

import org.example.business.abstracts.UserService;
import org.example.dataAccess.abstracts.UserDao;
import org.example.dataAccess.concretes.HibernateUserDao;
import org.example.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserManager implements UserService {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> passwords = new ArrayList<>();

    private UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {

        if ((user.getPassword().length()) < 6){
            System.out.println("Password must be at least 6 characters.");
            return;
        }
        else if (!isEmailValid(user.getEmail())) {
            System.out.println("Please enter your email address correctly.");
            return;
        }
        else if (user.getName().length() < 2 || user.getLastName().length() < 2) {
            System.out.println("Your name and surname must be at least 2 characters.");
            return;
        }
        else if (passwords.contains(user.getEmail())){
            System.out.println("This email is already in use");
            return;
        }
        System.out.println("Confirmation email has been sent. Click to register");
        System.out.println("Did you cilicked(Y/N): ");
        String answer = scanner.nextLine();
        if (!answer.equalsIgnoreCase("Y")){
            System.out.println("Your registration has been canceled.");
            return;
        }
        System.out.println("Your registration has been completed successfully.");
        passwords.add(user.getEmail());
        this.userDao.add(user);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    public boolean isEmailValid(String email) {
        String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }
}
