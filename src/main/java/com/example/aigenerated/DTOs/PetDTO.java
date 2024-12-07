package com.example.aigenerated.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PetDTO(
        @NotNull(message = "Name cannot be null")
        @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
        String name,

        @NotNull(message = "Animal type cannot be null")
        String animalType,

        @NotNull(message = "Breed cannot be null")
        String breed,

        @Min(value = 0, message = "Age must be non-negative")
        int age,

        @NotNull(message = "Household eircode cannot be null")
        String householdEircode
) {}
