package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Even {
    private static final int MAX_RANGE = 101;
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

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
            var number = random.nextInt(MAX_RANGE);
            questions[i] = String.valueOf(number);
            answers[i] = number % 2 == 0 ? "yes" : "no";
        }
        return new String[][]{questions, answers};
    }

}

