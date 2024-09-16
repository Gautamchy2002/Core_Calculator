package com.example.util;

public class CoreCalculator {

    private double width;
    private double height;
    private double depth;

    // Constructor to accept width, height, and depth
    public CoreCalculator(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // Calculate core factors (example calculation)
    public double calculateCoreFactors() {
        // Example calculation for core factors
        return 1.5; // Placeholder value
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
