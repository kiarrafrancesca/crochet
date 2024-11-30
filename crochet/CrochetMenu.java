package crochet;

import java.util.InputMismatchException;
import java.util.Scanner;
import user.UserManager;

public class CrochetMenu {
    private Scanner input = new Scanner(System.in);
    private UserManager userManager = new UserManager("userData.txt");
    private AboutCrochet aboutCrochet = new AboutCrochet();
    
    public void crochetMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("===================================");
            System.out.println("|          Crochet Menu           |");
            System.out.println("===================================");
            System.out.println("          1. User Menu");
            System.out.println("        2. About Crochet");
            System.out.println("          3. Suggester");
            System.out.println("           4. Pattern");
            System.out.println("-----------------------------------");
            System.out.println("           5. Log Out");
            System.out.println("===================================");
            System.out.print("  > Enter your choice (1-5): ");
            int choice = 0;

            try {
                choice = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter a valid choice from the menu.");
                input.next();
                continue;
            }

            switch(choice) {
                case 1:
                    break;
                case 2:
                    userManager.clearScreen();
                    aboutCrochet.displayMenu();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Please enter a valid choice from the menu.");
            }
            input.nextLine();
        }
        input.close();
    }
}