package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static void greetUser() {
        System.out.println("Welcome to the Brain Game!");
        System.out.print("May I have your name? ");
        String userName = SCANNER.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
    public static void main(String[] args) {

        System.out.println("/Welcome to the Brain Games!/");
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""");
        System.out.print("Your choice: ");
        String userChoice = SCANNER.nextLine();
        System.out.println();
        switch (userChoice) {
            case "1":
                greetUser();
                break;
            case "2":
                Even.startGame();
                break;
            case "3":
                Calc.startGame();
                break;
            case "4":
                GCD.startGame();
                break;
            case "5":
                Progression.startGame();
                break;
            case "6":
                Prime.startGame();
                break;
            case "0":
                break;
            default:
                System.out.println("Incorrect choice, please try again");
                break;
        }

        SCANNER.close();
    }
}
