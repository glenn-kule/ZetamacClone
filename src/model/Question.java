package model;

public class Question {
    private final int left;
    private final int right;
    private final Operation operator;

    public Question(int left, int right, Operation operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public Operation getOperator() {
        return operator;
    }

    public int answer() {
        return operator.apply(left, right);
    }

    public boolean isCorrect(int guess) {
        return answer() == guess;
    }

    @Override
    public String toString() {
        return left + " " + operator.symbol() + " " + right;
    }
}
