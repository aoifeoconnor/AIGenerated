package com.example.aigenerated.controller;

import com.example.aigenerated.DTOs.PetDTO;
import com.example.aigenerated.DTOs.Statistics;
import com.example.aigenerated.entities.Pet;
import com.example.aigenerated.services.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Pet> createPet(@Valid @RequestBody PetDTO petDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.createPet(petDTO));
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @Valid @RequestBody PetDTO petDTO) {
        return ResponseEntity.ok(petService.updatePet(id, petDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/byName/{name}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletePetsByName(@PathVariable String name) {
        petService.deletePetsByName(name);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/byAnimalType/{animalType}")
    public ResponseEntity<List<Pet>> findPetsByAnimalType(@PathVariable String animalType) {
        return ResponseEntity.ok(petService.findPetsByAnimalType(animalType));
    }

    @GetMapping("/byBreed/{breed}")
    public ResponseEntity<List<Pet>> findPetsByBreed(@PathVariable String breed) {
        return ResponseEntity.ok(petService.findPetsByBreed(breed));
    }

    @GetMapping("/statistics")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Statistics> getPetStatistics() {
        return ResponseEntity.ok(petService.getPetStatistics());
    }


    @PatchMapping("/{id}/name")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Pet> changePetName(@PathVariable Long id, @RequestParam String newName) {
        return ResponseEntity.ok(petService.changePetName(id, newName));
    }
}


