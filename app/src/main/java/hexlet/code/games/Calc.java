package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    private static final int ROUND_COUNT = 3;
    private static final int MAX_RANGE_OF_CALCULATOR = 21;
    private static final String[] MATH_OPERATOR = {"+", "-", "*"};
    private static final String GAME_RULE = "What is the result of the expression?";

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

        for (var i = 0; i < ROUND_COUNT; i++) {
            int a = random.nextInt(MAX_RANGE_OF_CALCULATOR);
            int b = random.nextInt(MAX_RANGE_OF_CALCULATOR);
            int randomOperation = random.nextInt(3);
            questions[i] = a + " " + MATH_OPERATOR[randomOperation] + " " + b;
            String operator = MATH_OPERATOR[randomOperation];
            int result = switch (operator) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                default -> 0;
            };
            answers[i] = String.valueOf(result);
        }
        return new String[][]{questions, answers};
    }

}
