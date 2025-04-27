package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    private static final int ROUND_COUNT = 3;
    private static final int MAX_RANGE = 101;
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        String[][] dataStorage = questAndAnswerGenerator();
        String[] questions = dataStorage[0];
        String[] answers = dataStorage[1];
        Engine.runGame(GAME_RULE, questions, answers);
    }

    public static String[][] questAndAnswerGenerator() {
        Random random = new Random();
        String[] questions = new String[ROUND_COUNT];
        String[] answers = new String[ROUND_COUNT];
        for (int i = 0; i < ROUND_COUNT; i++) {
            int a = random.nextInt(MAX_RANGE);
            int b = random.nextInt(MAX_RANGE);
            questions[i] = a + " " + b;
            answers[i] = String.valueOf(calculatedAnswer(a, b));
        }
        return new String[][]{questions, answers};
    }

    public static int calculatedAnswer(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
