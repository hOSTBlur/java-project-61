package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    private static final int ROUND_COUNT = 3;
    private static final String GAME_RULE ="Answer 'yes' if the number is prime. Otherwise answer 'no'";

    public static void startGame() {
        String[] questions = questionGenerator();
        String[] answers = answerGenerator(questions);
        Engine.runGame(GAME_RULE, questions, answers);
    }

    public static String[] questionGenerator() {
        Random random = new Random();
        String[] question = new String[ROUND_COUNT];
        for (var i = 0; i < ROUND_COUNT; i++) {

            question[i] = String.valueOf(random.nextInt(101));
        }
        return question;
    }

    public static String[] answerGenerator(String[] questions) {
        String[] answers = new String[ROUND_COUNT];
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
