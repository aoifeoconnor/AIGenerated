package com.example.aigenerated.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record HouseholdDTO(
        @NotNull(message = "Eircode cannot be null")
        @Pattern(regexp = "^[A-Z0-9]{7}$", message = "Invalid Eircode format")
        String eircode,

        @Min(value = 0, message = "Number of occupants must be non-negative")
        int numberOfOccupants,

        @Min(value = 1, message = "Max number of occupants must be at least 1")
        int maxNumberOfOccupants,

        boolean ownerOccupied
) {}