package com.example.aigenerated.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "household")//added after first iteration
public class Household {

    @Id
    private String eircode;
    private int numberOfOccupants;
    private int maxNumberOfOccupants;
    private boolean ownerOccupied;

    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();

    // Getters
    public String getEircode() { return eircode; }
    public int getNumberOfOccupants() { return numberOfOccupants; }
    public int getMaxNumberOfOccupants() { return maxNumberOfOccupants; }
    public boolean isOwnerOccupied() { return ownerOccupied; }
    public List<Pet> getPets() { return pets; }

    // Setters
    public void setEircode(String eircode) { this.eircode = eircode; }
    public void setNumberOfOccupants(int numberOfOccupants) { this.numberOfOccupants = numberOfOccupants; }
    public void setMaxNumberOfOccupants(int maxNumberOfOccupants) { this.maxNumberOfOccupants = maxNumberOfOccupants; }
    public void setOwnerOccupied(boolean ownerOccupied) { this.ownerOccupied = ownerOccupied; }
    public void setPets(List<Pet> pets) { this.pets = pets; }

    // Helper method to add a pet
    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setHousehold(this);
    }

    // Helper method to remove a pet
    public void removePet(Pet pet) {
        pets.remove(pet);
        pet.setHousehold(null);
    }
}
