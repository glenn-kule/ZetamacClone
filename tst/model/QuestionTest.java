package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuestionTest {
    
    @Test
    void multiplicationCheckIfCorrectAnswerReturnsTrueAndWrongAnswerReturnsFalse() {
        Question q = new Question(8, 7, Operation.MULTIPLICATION);
        assertTrue(q.isCorrect(56));
        assertFalse(q.isCorrect(54));
    }

    @Test
    void additionCheckIfCorrectAnswerReturnsTrueAndWrongAnswerReturnsFalse() {
        Question q = new Question(20, 7, Operation.ADDITION);
        assertTrue(q.isCorrect(27));
        assertFalse(q.isCorrect(5));
    }

    @Test
    void subtractionCheckIfCorrectAnswerReturnsTrueAndWrongAnswerReturnsFalse() {
        Question q = new Question(50, 7, Operation.SUBTRACTION);
        assertTrue(q.isCorrect(43));
        assertFalse(q.isCorrect(42));
    }

    @Test
    void divisionCheckIfCorrectAnswerReturnsTrueAndWrongAnswerReturnsFalse() {
        Question q = new Question(56, 7, Operation.DIVISION);
        assertTrue(q.isCorrect(8));
        assertFalse(q.isCorrect(7));
    }

    @Test
    void stringFormattingIsLeftOperatorRight() {
        Question q = new Question(20, 17, Operation.ADDITION);
        assertEquals("20 + 17", q.toString());
    }
}
