package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Progression {
    private static final Random RANDOM = new Random();
    private static final int MIN_RANGE_OF_PROGRESSION = 5;
    private static final int MAX_RANGE_OF_PROGRESSION = 11;
    private static final int MIN_START_PROGRESSION = 1;
    private static final int MAX_START_PROGRESSION = 21;
    private static final int MIN_STEP_PROGRESSION = 1;
    private static final int MAX_STEP_PROGRESSION = 10;
    private static final String GAME_RULE = "What number is missing in the progression?";

    public static void startGame() {
        String[][] dataStorage = questionAndAnswerGenerator();
        String[] questions = dataStorage[0];
        String[] answers = dataStorage[1];
        Engine.runGame(GAME_RULE, questions, answers);
    }

    public static String[][] questionAndAnswerGenerator() {
        String[] questions = new String[Engine.getRoundCount()];
        String[] answers = new String[Engine.getRoundCount()];
        for (var i = 0; i < Engine.getRoundCount(); i++) {
            var length = RANDOM.nextInt(MIN_RANGE_OF_PROGRESSION, MAX_RANGE_OF_PROGRESSION);
            var start = RANDOM.nextInt(MIN_START_PROGRESSION, MAX_START_PROGRESSION);
            var step = RANDOM.nextInt(MIN_STEP_PROGRESSION, MAX_STEP_PROGRESSION);

            StringBuilder progression = new StringBuilder();
            int[] progressions = new int[length];
            for (var j = 0; j < length; j++) {
                progressions[j] = start + step * j;
                progression.append(progressions[j]).append(" ");
            }
            String progressionString = progression.toString().trim();

            var hiddenPosition = RANDOM.nextInt(length);
            answers[i] = String.valueOf(progressions[hiddenPosition]);
            String[] numbers = progressionString.split(" ");
            numbers[hiddenPosition] = "..";
            questions[i] = String.join(" ", numbers);

        }

        return new String[][]{questions, answers};
    }

}
