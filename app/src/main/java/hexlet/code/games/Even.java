package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Even {
    public static void startGame() {
        Engine.greetUser();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'");
        String[] questions = questionGenerator();
        String[] answers = answerGenerator(questions);
        Engine.runGame(questions, answers);
    }

    public static String[] questionGenerator() {
        Random random = new Random();
        String[] question = new String[3];
        for (var i = 0; i < 3; i++) {
            question[i] = String.valueOf(random.nextInt(101));
        }
        return question;
    }

    public static String[] answerGenerator(String[] quest) {
        String[] answers = new String[3];
        for (var i = 0; i < 3; i++) {
            int number = Integer.parseInt(quest[i]);
            answers[i] = number % 2 == 0 ? "yes" : "no";
        }
        return answers;
    }
}

