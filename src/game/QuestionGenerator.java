package game;

import model.Operation;
import java.util.Random;

import model.Question;

public class QuestionGenerator {

    private static final int ADD_MIN = 2;
    private static final int ADD_MAX = 100;
    private static final int MULT_SMALL_MIN = 2;
    private static final int MULT_SMALL_MAX = 12;
    private static final int MULT_LARGE_MIN = 2;
    private static final int MULT_LARGE_MAX = 100;

    private final Random random;

    public QuestionGenerator() {
        this(new Random());
    }

    public QuestionGenerator(Random random) {
        this.random = random;
    }

    public Question nextQuestion() {
        Operation[] operations = Operation.values();
        Operation op = operations[random.nextInt(operations.length)];
        return switch (op) {
            case ADDITION -> nextAddition();
            case SUBTRACTION -> nextSubtraction();
            case MULTIPLICATION -> nextMultiplication();
            case DIVISION -> nextDivision();
        };
    }

    public Question nextAddition() {
        int left = random.nextInt(ADD_MIN, ADD_MAX + 1);
        int right = random.nextInt(ADD_MIN, ADD_MAX + 1);
        return new Question(left, right, Operation.ADDITION);
    }

    public Question nextSubtraction() {
        int left = random.nextInt(ADD_MIN, ADD_MAX + 1);
        int right = random.nextInt(ADD_MIN, ADD_MAX + 1);
        return random.nextBoolean() ? new Question(left+right, right, Operation.SUBTRACTION) : new Question(left+right, left, Operation.SUBTRACTION);
    }

    public Question nextMultiplication() {
        int left = random.nextInt(MULT_SMALL_MIN, MULT_SMALL_MAX + 1);
        int right = random.nextInt(MULT_LARGE_MIN, MULT_LARGE_MAX + 1);
        return random.nextBoolean() ? new Question(left, right, Operation.MULTIPLICATION) : new Question(right, left, Operation.MULTIPLICATION);
    }

    public Question nextDivision() {
        int divisor = random.nextInt(MULT_SMALL_MIN, MULT_SMALL_MAX + 1);
        int quotient = random.nextInt(MULT_LARGE_MIN, MULT_LARGE_MAX + 1);
        return new Question(divisor*quotient, divisor, Operation.DIVISION);
    }
}
