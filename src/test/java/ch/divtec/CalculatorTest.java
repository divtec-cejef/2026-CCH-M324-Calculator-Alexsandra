package ch.divtec;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();

        assertEquals(5, calculator.add(5, 5));
    }

    @Test
    void addNormal() {
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    void addNegative() {
        assertEquals(-1, calculator.add(2, -3));
    }

    @Test
    void subtractNormal() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    void subtractNegative() {
        assertEquals(4, calculator.subtract(1, -3));
    }

    @Test
    void subtractBothNegative() {
        assertEquals(-5, calculator.subtract(-8, -3));
    }

    @Test
    void multiplyNormal() {
        assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    void multiplyNegative() {
        assertEquals(-12, calculator.multiply(3, -4));
    }

    @Test
    void multiplyByZero() {
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    void divideNormal() {
        assertEquals(0.6, calculator.divide(3, 5));
    }

    @Test
    void divideNegative() {
        assertEquals(-0.6, calculator.divide(-3, 5));
    }

    @Test
    void factorialNormal() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    void factorialOfZero() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    void factorialDecimal() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(3.2);
        });
        String expectedMessage = "Number must be an integer";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    
    @Test
    void factorialNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(-5);
        });

        String expectedMessage = "Number must be positive";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}