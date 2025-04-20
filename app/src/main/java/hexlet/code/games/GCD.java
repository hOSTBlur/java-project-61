package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    public static void startGame() {
        Engine.greetUser();
        System.out.println("Find the greatest common divisor of given numbers.");
        String[] questions = questGenerator();
        String[] answers = answerGenerator(questions);
        Engine.runGame(questions, answers);
    }

    public static String[] questGenerator() {
        Random random = new Random();
        String[] questions = new String[3];
        for (int i = 0; i < 3; i++) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            String combinedNumber = a + " " + b;
            questions[i] = combinedNumber;
        }
        return questions;
    }

    public static String[] answerGenerator(String[] questions) {
        String[] answers = new String[3];
        for (int i = 0; i < 3; i++) {
            String[] parts = questions[i].split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            while (a != b) {
                if (a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            answers[i] = String.valueOf(a);
        }
        return answers;
    }
}
