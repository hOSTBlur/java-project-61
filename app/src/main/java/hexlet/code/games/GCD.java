package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    private static final int MAX_RANGE = 101;
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        String[][] dataStorage = questionAndAnswerGenerator();
        String[] questions = dataStorage[0];
        String[] answers = dataStorage[1];
        Engine.runGame(GAME_RULE, questions, answers);
    }

    public static String[][] questionAndAnswerGenerator() {
        Random random = new Random();
        String[] questions = new String[Engine.getRoundCount()];
        String[] answers = new String[Engine.getRoundCount()];
        for (var i = 0; i < Engine.getRoundCount(); i++) {
            var a = random.nextInt(MAX_RANGE);
            var b = random.nextInt(MAX_RANGE);
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
