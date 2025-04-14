package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Even {
    public static void isEven() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        var count = 0; // Переменная для сч та верных ответов

        System.out.println("Welcome to the Brian Game!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'");

        for (var i = 0; i < 3;) {
            var questNum = random.nextInt(100);

            System.out.println("Question: " + questNum);
            String userAnswer = scanner.nextLine();
            System.out.println("Your answer: " + userAnswer);

            if (questNum % 2 == 0) {
                if (userAnswer.equals("yes")) {
                    System.out.println("Correct!");
                    count++;
                    i++;
                    continue;
                } else {
                    System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.\n"
                            + "Let's try again, " + userName);
                    break;
                }
            } else {
                if (userAnswer.equals("no")) {
                    System.out.println("Correct!");
                    count++;
                    i++;
                    continue;
                } else {
                    System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.\n"
                            + "Let's try again, " + userName);
                    break;
                }
            }
        }

        if (count == 0) {
            System.out.println("Congratulations, " + userName);
        }

        scanner.close();
    }
}
