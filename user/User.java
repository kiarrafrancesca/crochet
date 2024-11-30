package user;

import java.util.Scanner;
import crochet.CrochetMenu;

public class User {
    private UserManager userManager = new UserManager("userData.txt");
    private Scanner input = new Scanner(System.in);
    private CrochetMenu crochetMenu = new CrochetMenu();

    public void signUp() {
        userManager.clearScreen();
        System.out.println("========================");
        System.out.println("|        SIGN UP       |");
        System.out.println("========================");
        
        String username;
        while (true) {
            username = userManager.setUsernameInput();
            if (username.equals("0")) {
                userManager.clearScreen();
                return;
            }
            if (!userManager.usernameExists(username)) break;
            System.out.print("Username already exists. Choose a different one.");
        }

        String password = userManager.setPasswordInput();
        userManager.saveUser(username, password);

        userManager.clearScreen();
        System.out.println("Sign-up successful!");
        return;
    }

    public void logIn() {
        userManager.clearScreen();
        System.out.println("========================");
        System.out.println("|         LOG IN       |");
        System.out.println("========================");

        String username = userManager.setUsernameInput();
        if (username.equals("0")) {
            userManager.clearScreen();
            return;
        }

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (userManager.loadUser(username, password)) {
            userManager.clearScreen();
            System.out.println("Login successful!");
            crochetMenu.crochetMenu();
        }
        else {
            userManager.clearScreen();
            System.out.println("Invalid username or password. Please try again.");
        }
    }    
}