package dev.mariel.eximc;

import java.util.Locale;
import java.util.Scanner;

import dev.mariel.eximc.services.ImcCalculator;
import dev.mariel.eximc.services.ImcEvaluator;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        ImcCalculator imcCalculator = new ImcCalculator();
        ImcEvaluator imcEvaluator = new ImcEvaluator();
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Welcome to the IMC calculation program");

            System.out.println("\nPlease, enter your weight in kilograms: ");

            double weight = scanner.nextDouble();

            System.out.println("\nPlease, enter your height in meters: ");

            double height = scanner.nextDouble();

            double imc = imcCalculator.calculateIMC(weight, height);

            String result = imcEvaluator.classifyImc(imc);

            System.out.printf("\nYour IMC is: %.2f%n", imc);
            System.out.println("\nClassification: " + result);
        }
        catch (IllegalArgumentException e){
            System.out.println("\nError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nAn unexpected error occurred. Please try again");
        } finally {
            scanner.close();
        }
    }
}
