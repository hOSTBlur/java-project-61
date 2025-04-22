package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ROUND_COUNT = 3;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static String userName;

    public static void greetUser() {
        System.out.print("May I have your name? ");
        userName = SCANNER.nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    public static void runGame(String[] questions, String[] correctAnswer) {
        int count = 0;
        for (int i = 0; i < ROUND_COUNT; i++) {
            System.out.println("Question: " + questions[i]);
            System.out.print("Your answer: ");
            String userAnswer = SCANNER.nextLine();

            if (userAnswer.equalsIgnoreCase(correctAnswer[i])) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer[i] + "' Let's try again, " + userName);
                break;
            }
        }
        if (count == ROUND_COUNT) {
            System.out.println("Congratulations, " + userName);
        }
        SCANNER.close();
    }
}
