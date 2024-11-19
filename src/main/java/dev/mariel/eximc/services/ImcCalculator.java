package dev.mariel.eximc.services;

public class ImcCalculator {
    public double calculateIMC(double weight, double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        if (weight <= 0){
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        return weight / Math.pow(height, 2);
    }

}