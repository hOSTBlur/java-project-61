package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Progression {
    private static final int ROUND_COUNT = 3;
    private static final String GAME_RULE = "What number is missing in the progression?";

    public static void startGame() {
        String[] questions = questGenerator();
        String[] hiddenNumbers = hideIndex(questions);
        String[] answers = answerGenerator(questions, hiddenNumbers);
        Engine.runGame(GAME_RULE, hiddenNumbers, answers);
    }

    public static String[] questGenerator() {
        String[] questions = new String[ROUND_COUNT];
        for (int i = 0; i < ROUND_COUNT; i++) {
            int length = ThreadLocalRandom.current().nextInt(5, 11);
            int start = ThreadLocalRandom.current().nextInt(1, 21);
            int step = ThreadLocalRandom.current().nextInt(1, 10);

            StringBuilder progression = new StringBuilder();
            for (int j = 0; j < length; j++) {
                progression.append(start + step * j).append(" ");
            }
            questions[i] = progression.toString().trim();
        }
        return questions;
    }

    public static String[] hideIndex(String[] questions) {
        String[] questWithHiddenIndex = new String[ROUND_COUNT];
        Random random = new Random();

        for (int i = 0; i < ROUND_COUNT; i++) {
            String[] numbers = questions[i].split(" ");
            int hiddenPos = random.nextInt(numbers.length);
            numbers[hiddenPos] = "..";
            questWithHiddenIndex[i] = String.join(" ", numbers);
        }
        return questWithHiddenIndex;
    }

    public static String[] answerGenerator(String[] questions, String[] hiddenNumbers) {
        String[] answers = new String[ROUND_COUNT];
        for (int i = 0; i < ROUND_COUNT; i++) {
            String[] original = questions[i].split(" ");
            String[] hidden = hiddenNumbers[i].split(" ");

            for (int j = 0; j < original.length; j++) {
                if (!original[j].equals(hidden[j])) {
                    answers[i] = original[j];
                    break;
                }
            }
        }
        return answers;
    }
}
