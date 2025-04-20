package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                0 - Exit""");
        System.out.print("Your choice: ");
        int userChoice = Integer.parseInt(scanner.nextLine());
        System.out.println();
        switch (userChoice) {
            case 1:
                Engine.greetUser();
                break;
            case 2:
                Even.startGame();
            case 3:
                Calc.startGame();
            case 4:
                GCD.startGame();
            case 5:
                Progression.startGame();
            case 0:
                break;
            default:
                System.out.println("Incorrect choice, please try again");
                break;
        }

        scanner.close();
    }
}
