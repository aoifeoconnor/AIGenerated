package com.example.aigenerated.services;

import com.example.aigenerated.DTOs.PetDTO;
import com.example.aigenerated.DTOs.Statistics;
import com.example.aigenerated.entities.Household;
import com.example.aigenerated.entities.Pet;
import com.example.aigenerated.exceptions.ResourceNotFoundException;
import com.example.aigenerated.repositories.HouseholdRepository;
import com.example.aigenerated.repositories.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private HouseholdRepository householdRepository;

    public Pet createPet(PetDTO petDTO) {
        Household household = householdRepository.findById(petDTO.householdEircode())
                .orElseThrow(() -> new ResourceNotFoundException("Household not found"));
        Pet pet = new Pet();
        updatePetFromDTO(pet, petDTO);
        pet.setHousehold(household);
        return petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found"));
    }

    public Pet updatePet(Long id, PetDTO petDTO) {
        Pet pet = getPetById(id);
        updatePetFromDTO(pet, petDTO);
        return petRepository.save(pet);
    }

    public void deletePet(Long id) {
        if (!petRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pet not found");
        }
        petRepository.deleteById(id);
    }

    public void deletePetsByName(String name) {
        petRepository.deleteByNameIgnoreCase(name);
    }

    public List<Pet> findPetsByAnimalType(String animalType) {
        return petRepository.findByAnimalType(animalType);
    }

    public List<Pet> findPetsByBreed(String breed) {
        return petRepository.findByBreedOrderByAgeAsc(breed);
    }

    public Statistics getPetStatistics() {
        List<Pet> pets = petRepository.findAll();

        double averageAge = pets.stream()
                .mapToInt(Pet::getAge)
                .average()
                .orElse(0);

        int oldestAge = pets.stream()
                .mapToInt(Pet::getAge)
                .max()
                .orElse(0);

        return new Statistics(averageAge, oldestAge);
    }


    @Transactional
    public Pet changePetName(Long id, String newName) {
        Pet pet = getPetById(id);
        pet.setName(newName);
        return petRepository.save(pet);
    }

    private void updatePetFromDTO(Pet pet, PetDTO petDTO) {
        pet.setName(petDTO.name());
        pet.setAnimalType(petDTO.animalType());
        pet.setBreed(petDTO.breed());
        pet.setAge(petDTO.age());
    }
}




