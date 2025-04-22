package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    public static void startGame() {
        Engine.greetUser();
        System.out.println("What is the result of the expression?");
        String[] questions = questGenerator();
        String[] answers = answerGenerator(questions);
        Engine.runGame(questions, answers);
    }

    public static String[] questGenerator() {
        Random random = new Random();
        String[] questions = new String[3];
        String[] operations = {"+", "-", "*"};

        for (var i = 0; i < 3; i++) {
            int a = random.nextInt(21);
            int b = random.nextInt(21);
            int randomOperation = random.nextInt(3);
            questions[i] = a + " " + operations[randomOperation] + " " + b;
        }
        return questions;
    }

    public static String[] answerGenerator(String[] questions) {
        String[] answers = new String[3];
        for (var i = 0; i < 3; i++) {
            String[] parts = questions[i].split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[2]);
            String operator = parts[1];
            switch (operator) {
                case "+":
                    answers[i] = String.valueOf(a + b);
                    break;
                case "-":
                    answers[i] = String.valueOf(a - b);
                    break;
                case "*":
                    answers[i] = String.valueOf(a * b);
                    break;
                default:
                    answers[i] = String.valueOf(0);
                    break;
            }
        }
        return answers;
    }
}
