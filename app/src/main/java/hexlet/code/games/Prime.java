package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    public static void startGame() {
        Engine.greetUser();
        System.out.println("Answer 'yes' if the number is prime. Otherwise answer 'no'");
        String[] questions = questionGenerator();
        String[] answers = answerGenerator(questions);
        Engine.runGame(questions, answers);
    }

    public static String[] questionGenerator() {
        Random random = new Random();
        String[] question = new String[3];
        for (var i = 0; i < 3; i++) {
            question[i] = String.valueOf(random.nextInt(101));
        }
        return question;
    }

    public static String[] answerGenerator(String[] questions) {
        String[] answers = new String[3];
        for (int i = 0; i < 3; i++) {
            int number = Integer.parseInt(questions[i]);
            answers[i] = isPrime(number) ? "yes" : "no";
        }
        return answers;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
