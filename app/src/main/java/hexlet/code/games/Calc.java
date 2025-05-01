package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    private static final int MAX_RANGE_OF_CALCULATOR = 21;
    private static final int RANDOM_OPERATION = 3;
    private static final String[] MATH_OPERATOR = {"+", "-", "*"};
    private static final String GAME_RULE = "What is the result of the expression?";

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
            var a = random.nextInt(MAX_RANGE_OF_CALCULATOR);
            var b = random.nextInt(MAX_RANGE_OF_CALCULATOR);
            var randomOperation = random.nextInt(RANDOM_OPERATION);
            questions[i] = a + " " + MATH_OPERATOR[randomOperation] + " " + b;
            String operator = MATH_OPERATOR[randomOperation];
            var result = switch (operator) {
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
