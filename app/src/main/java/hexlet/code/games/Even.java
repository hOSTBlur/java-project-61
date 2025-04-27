package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Even {
    private static final int ROUND_COUNT = 3;
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

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
            int number = random.nextInt(101);
            questions[i] = String.valueOf(number);
            answers[i] = number % 2 == 0 ? "yes" : "no";
        }
        return new String[][]{questions, answers};
    }

}

