package com.example.aigenerated.DTOs;

public class Statistics {
    private final double averagePetAge;
    private final int oldestPetAge;

    // Constructor
    public Statistics(double averagePetAge, int oldestPetAge) {
        this.averagePetAge = averagePetAge;
        this.oldestPetAge = oldestPetAge;
    }

    // Getters
    public double getAveragePetAge() {
        return averagePetAge;
    }

    public int getOldestPetAge() {
        return oldestPetAge;
    }
}
