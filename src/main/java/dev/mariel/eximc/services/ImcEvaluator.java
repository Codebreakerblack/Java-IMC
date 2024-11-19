package dev.mariel.eximc.services;

import java.util.NavigableMap;
import java.util.TreeMap;

public class ImcEvaluator {
    private final NavigableMap<Double, String> imcCategories = new TreeMap<>();

    public ImcEvaluator() {
        imcCategories.put(16.0, "Severe thinness");
        imcCategories.put(17.0, "Moderate thinness");
        imcCategories.put(18.5, "Slight thinness");
        imcCategories.put(25.0, "Normal weight");
        imcCategories.put(30.0, "Overweight");
        imcCategories.put(35.0, "Mild obesity");
        imcCategories.put(40.0, "Moderate obesity");
        imcCategories.put(Double.MAX_VALUE, "Morbid obesity");
    }

    public String classifyImc(double imc) {
        return imcCategories.ceilingEntry(imc).getValue();
    }
}