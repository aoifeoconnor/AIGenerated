package com.example.aigenerated.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//added after first iteration
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String animalType;
    private String breed;
    private int age;

    @ManyToOne
    @JoinColumn(name = "household_eircode", nullable = false)
    private Household household;

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getAnimalType() { return animalType; }
    public String getBreed() { return breed; }
    public int getAge() { return age; }
    public Household getHousehold() { return household; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAnimalType(String animalType) { this.animalType = animalType; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setAge(int age) { this.age = age; }
    public void setHousehold(Household household) { this.household = household; }
}




