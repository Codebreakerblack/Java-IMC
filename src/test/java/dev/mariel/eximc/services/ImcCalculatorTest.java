package dev.mariel.eximc.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ImcCalculatorTest {
    @Test
    void testCalculateIMC() {
        ImcCalculator calculator = new ImcCalculator();
        double weight = 70;
        double height = 1.75;
        double expectedImc = 70 / Math.pow(1.75, 2);

        assertEquals(expectedImc, calculator.calculateIMC(weight, height));
    }

    @Test
    void throwExceptionForHeight() {
        ImcCalculator calculator = new ImcCalculator();
        double weight = 70;
        double invalidHeight = 0;

        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> calculator.calculateIMC(weight, invalidHeight),
            "Expected an IllegalArgumentException for height <= 0");
        
        assertEquals("Height must be greater than 0", exception.getMessage());
    }

    @Test
    void throwExceptionForWeight() {
        ImcCalculator calculator = new ImcCalculator();
        double invalidWeight = 0;
        double height = 1.75;

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateIMC(invalidWeight, height),
                "Expected an IllegalArgumentException for height <= 0");

        assertEquals("Weight must be greater than 0", exception.getMessage());
    }
}
