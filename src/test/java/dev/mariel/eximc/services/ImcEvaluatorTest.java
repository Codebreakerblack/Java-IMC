package dev.mariel.eximc.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ImcEvaluatorTest {
    @Test
    void testClassifyImc() {
        ImcEvaluator evaluator = new ImcEvaluator();

        assertEquals("Severe thinness", evaluator.classifyImc(10));
        assertEquals("Moderate thinness", evaluator.classifyImc(16.5));
        assertEquals("Slight thinness", evaluator.classifyImc(17.5));
        assertEquals("Normal weight", evaluator.classifyImc(22));
        assertEquals("Overweight", evaluator.classifyImc(27));
        assertEquals("Mild obesity", evaluator.classifyImc(32));
        assertEquals("Moderate obesity", evaluator.classifyImc(37));
        assertEquals("Morbid obesity", evaluator.classifyImc(48));
    }

}