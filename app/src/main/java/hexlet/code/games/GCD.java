package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    private static final int ROUND_COUNT = 3;
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        String[] questions = questAndAnswerGenerator()[0];
        String[] answers = questAndAnswerGenerator()[1];
        Engine.runGame(GAME_RULE, questions, answers);
    }

    public static String[][] questAndAnswerGenerator() {
        Random random = new Random();
        String[] questions = new String[ROUND_COUNT];
        String[] answer = new String[ROUND_COUNT];
        for (int i = 0; i < ROUND_COUNT; i++) {
            int a = random.nextInt(101);
            int b = random.nextInt(101);
            String combinedNumber = a + " " + b;
            questions[i] = combinedNumber;
            answer[i] = String.valueOf(calculatedAnswer(a,b));
        }
        return new String[][]{questions, answer};
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
