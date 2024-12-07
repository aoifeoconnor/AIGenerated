package com.example.aigenerated.repositories;

import com.example.aigenerated.entities.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, String> {
    List<Household> findByPetsIsEmpty();
    List<Household> findByOwnerOccupied(boolean ownerOccupied);
}
