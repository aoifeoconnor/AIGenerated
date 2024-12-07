package com.example.aigenerated.services;

import com.example.aigenerated.DTOs.HouseholdDTO;
import com.example.aigenerated.entities.Household;
import com.example.aigenerated.exceptions.ResourceNotFoundException;
import com.example.aigenerated.repositories.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HouseholdService {
    @Autowired
    private HouseholdRepository householdRepository;

    public Household createHousehold(HouseholdDTO householdDTO) {
        Household household = new Household();
        updateHouseholdFromDTO(household, householdDTO);
        return householdRepository.save(household);
    }

    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    public Household getHouseholdById(String eircode) {
        return householdRepository.findById(eircode)
                .orElseThrow(() -> new ResourceNotFoundException("Household not found"));
    }

    public Household updateHousehold(String eircode, HouseholdDTO householdDTO) {
        Household household = getHouseholdById(eircode);
        updateHouseholdFromDTO(household, householdDTO);
        return householdRepository.save(household);
    }

    public void deleteHousehold(String eircode) {
        if (!householdRepository.existsById(eircode)) {
            throw new ResourceNotFoundException("Household not found");
        }
        householdRepository.deleteById(eircode);
    }

    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findByPetsIsEmpty();
    }

    public List<Household> findOwnerOccupiedHouseholds() {
        return householdRepository.findByOwnerOccupied(true);
    }

    public Map<String, Long> getHouseholdStatistics() {
        long emptyHouses = householdRepository.findByPetsIsEmpty().size();
        long fullHouses = householdRepository.findAll().stream()
                .filter(h -> h.getNumberOfOccupants() == h.getMaxNumberOfOccupants())
                .count();
        return Map.of("emptyHouses", emptyHouses, "fullHouses", fullHouses);
    }

    private void updateHouseholdFromDTO(Household household, HouseholdDTO householdDTO) {
        household.setEircode(householdDTO.eircode());
        household.setNumberOfOccupants(householdDTO.numberOfOccupants());
        household.setMaxNumberOfOccupants(householdDTO.maxNumberOfOccupants());
        household.setOwnerOccupied(householdDTO.ownerOccupied());
    }
}
