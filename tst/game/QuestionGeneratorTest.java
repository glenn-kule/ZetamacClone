package game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import model.Question;

public class QuestionGeneratorTest {
    
    @Test
    void multiplicationBoundsEnforced() {
        QuestionGenerator generator = new QuestionGenerator(new Random(42L));

        for (int i = 0; i < 1_000; i++) {
            Question q = generator.nextMultiplication();
            boolean leftSmall = q.getLeft() >= 2 && q.getLeft() <= 12 && q.getRight() >= 2 && q.getRight() <= 100;
            boolean rightSmall = q.getLeft() >= 2 && q.getLeft() <= 100 && q.getRight() >= 2 && q.getRight() <= 12;
            assertTrue(leftSmall || rightSmall, "Out of bounds: " + q);
        }
    }

    @Test
    void subtractionIsNonNegative() {
        QuestionGenerator generator = new QuestionGenerator(new Random(42L));

        for (int i = 0; i < 1_000; i++) {
            Question q = generator.nextSubtraction();
            assertTrue(q.answer() >= 0, "Negative Number: " + q);
        }
    }

    @Test
    void divisionDoesNotHaveZeroDivisorAndHasNoRemainder() {
        QuestionGenerator generator = new QuestionGenerator(new Random(42L));

        for (int i = 0; i < 1_000; i++) {
            Question q = generator.nextDivision();
            assertTrue(q.getRight() > 0);
            assertTrue(q.getLeft() % q.getRight() == 0);
        }
    }
}
