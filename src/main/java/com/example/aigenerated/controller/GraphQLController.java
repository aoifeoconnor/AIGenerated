package com.example.aigenerated.controller;

import com.example.aigenerated.DTOs.HouseholdDTO;
import com.example.aigenerated.DTOs.Statistics;
import com.example.aigenerated.entities.Household;
import com.example.aigenerated.entities.Pet;
import com.example.aigenerated.services.HouseholdService;
import com.example.aigenerated.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {
    @Autowired
    private PetService petService;

    @Autowired
    private HouseholdService householdService;

    @QueryMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @QueryMapping
    public List<Pet> getPetsByAnimalType(@Argument String animalType) {
        return petService.findPetsByAnimalType(animalType);
    }

    @QueryMapping
    public Household getHousehold(@Argument String eircode) {
        return householdService.getHouseholdById(eircode);
    }

    @QueryMapping
    public Pet getPet(@Argument Long id) {
        return petService.getPetById(id);
    }

    @QueryMapping
    public Statistics getStatistics() {
        return petService.getPetStatistics();
    }




    @MutationMapping
    public Household createHousehold(@Argument HouseholdDTO input) {
        return householdService.createHousehold(input);
    }

    @MutationMapping
    public boolean deleteHousehold(@Argument String eircode) {
        householdService.deleteHousehold(eircode);
        return true;
    }

    @MutationMapping
    public boolean deletePet(@Argument Long id) {
        petService.deletePet(id);
        return true;
    }
}
