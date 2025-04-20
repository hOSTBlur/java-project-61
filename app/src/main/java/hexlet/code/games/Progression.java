package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Progression {
    public static void startGame() {
        Engine.greetUser();
        System.out.println("What number is missing in the progression?");
        String[] questions = questGenerator();
        String[] hiddenNumbers = hideIndex(questions);
        String[] answers = answerGenerator(questions, hiddenNumbers);
        Engine.runGame(hiddenNumbers, answers);
    }

    public static String[] questGenerator() {
        String[] questions = new String[3];
        for (int i = 0; i < 3; i++) {
            int length = ThreadLocalRandom.current().nextInt(5, 10 + 1);
            int start = ThreadLocalRandom.current().nextInt(1, 20 + 1);
            int step = ThreadLocalRandom.current().nextInt(1, 9 + 1);

            StringBuilder progression = new StringBuilder();
            for (int j = 0; j < length; j++) {
                progression.append(start + step * j).append(" ");
            }
            questions[i] = progression.toString().trim();
        }
        return questions;
    }

    public static String[] hideIndex(String[] questions) {
        String[] questWithHiddenIndex = new String[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            String[] numbers = questions[i].split(" ");
            int hiddenPos = random.nextInt(numbers.length);
            numbers[hiddenPos] = "..";
            questWithHiddenIndex[i] = String.join(" ", numbers);
        }
        return questWithHiddenIndex;
    }

    public static String[] answerGenerator(String[] questions, String[] hiddenNumbers) {
        String[] answers = new String[3];
        for (int i = 0; i < 3; i++) {
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
