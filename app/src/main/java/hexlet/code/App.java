package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.\n1 - Greet\n2 - Even\n3 - Exit");
        int userChoice = Integer.parseInt(scanner.nextLine());
        switch (userChoice) {
            case 1:
                System.out.println("Welcome to the Brian Game!");
                System.out.print("May I have your name? ");
                String userName = scanner.nextLine();
                System.out.println("Hello, " + userName + "!");
                break;
            case 2:
                Even.isEven();
                //break;
            case 0:
                break;
            default:
                System.out.println("Incorrect choice, please try again");
        }

        //Cli.askUserName();
    }
}
