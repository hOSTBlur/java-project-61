package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    private static final int ROUND_COUNT = 3;
    private static final int MAX_RANGE = 101;
    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        String[][] dataStorage = questionAndAnswerGenerator();
        String[] questions = dataStorage[0];
        String[] answers = dataStorage[1];
        Engine.runGame(GAME_RULE, questions, answers);
    }

    public static String[][] questionAndAnswerGenerator() {
        Random random = new Random();
        String[] questions = new String[ROUND_COUNT];
        String[] answers = new String[ROUND_COUNT];
        for (var i = 0; i < ROUND_COUNT; i++) {
            int number = random.nextInt(MAX_RANGE);
            questions[i] = String.valueOf(number);
            answers[i] = isPrime(number) ? "yes" : "no";
        }
        return new String[][]{questions, answers};
    }

    private static boolean isPrime(int number) {
        int firstNotPrimeNumber = 1;
        int secondNotPrimeNumber = 3;
        int startCheckPrime = 5;
        int stepCheckPrime = 6;
        int firstPrimeFactor = 2;
        int secondPrimeFactor = 3;
        int pairCheck = 2;
        if (number <= firstNotPrimeNumber) {
            return false;
        }
        if (number <= secondNotPrimeNumber) {
            return true;
        }
        if (number % firstPrimeFactor == 0 || number % secondPrimeFactor == 0) {
            return false;
        }

        for (int i = startCheckPrime; i * i <= number; i += stepCheckPrime) {
            if (number % i == 0 || number % (i + pairCheck) == 0) {
                return false;
            }
        }
        return true;
    }
}
