package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    private static final int ROUND_COUNT = 3;
    private static final int MAX_RANGE = 101;
    static final int FIRST_NON_PRIME = 1;
    static final int SECOND_NON_PRIME = 3;
    static final int PRIME_CHECK_START = 5;
    static final int PRIME_CHECK_STEP = 6;
    static final int FIRST_PRIME_FACTOR = 2;
    static final int SECOND_PRIME_FACTOR = 3;
    static final int PAIR_CHECK = 2;
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
        if (number <= FIRST_NON_PRIME) {
            return false;
        }
        if (number <= SECOND_NON_PRIME) {
            return true;
        }
        if (number % FIRST_PRIME_FACTOR == 0 || number % SECOND_PRIME_FACTOR == 0) {
            return false;
        }

        for (int i = PRIME_CHECK_START; i * i <= number; i += PRIME_CHECK_STEP) {
            if (number % i == 0 || number % (i + PAIR_CHECK) == 0) {
                return false;
            }
        }
        return true;
    }
}
