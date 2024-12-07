package com.example.aigenerated.repositories;

import com.example.aigenerated.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByAnimalType(String animalType);
    List<Pet> findByBreedOrderByAgeAsc(String breed);
    void deleteByNameIgnoreCase(String name);
}
