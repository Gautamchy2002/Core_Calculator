package com.example.util;

public class CoreCalculator {

    private double width;
    private double height;
    private double depth;

   
    public CoreCalculator(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

   
    public double calculateCoreFactors() {
       
        return 1.5; 
    }

    // Calculate effective volume (Ve)
    public double calculateEffectiveVolume() {
        // Volume = width * height * depth
        return width * height * depth;
    }

    // Calculate effective length (le)
    public double calculateEffectiveLength() {
        // Effective length = 2 * (width + height)
        return 2 * (width + height);
    }

    // Calculate effective area (Ae)
    public double calculateEffectiveArea() {
        // Area = width * height
        return width * height;
    }

    // Calculate minimum area (An)
    public double calculateMinimumArea() {
        // Minimum area might be 90% of the effective area
        return calculateEffectiveArea() * 0.9;
    }
}
