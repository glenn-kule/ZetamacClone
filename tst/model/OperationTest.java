package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OperationTest {
    
    @Test
    void additionApplyComputesCorrectAnswer() {
        Operation op = Operation.ADDITION;
        assertEquals(44, op.apply(20, 24));
    }

    @Test
    void subtractionApplyComputesCorrectAnswer() {
        Operation op = Operation.SUBTRACTION;
        assertEquals(20, op.apply(44, 24));
    }

    @Test
    void multiplicationApplyComputesCorrectAnswer() {
        Operation op = Operation.MULTIPLICATION;
        assertEquals(56, op.apply(8, 7));
    }

    @Test
    void divisionApplyComputesCorrectAnswer() {
        Operation op = Operation.DIVISION;
        assertEquals(8, op.apply(56,7));
    }

    @Test
    void divisionByZeroThrowsArithmeticException() {
        Operation op = Operation.DIVISION;
        assertThrows(ArithmeticException.class, () -> {
            op.apply(8, 0);
        });
    }

    @Test
    void subtractionResultingInNonNegativeThrows() {
        Operation op = Operation.SUBTRACTION;
        assertThrows(IllegalArgumentException.class, () -> {
            op.apply(8, 10);
        });
    }
}
