package com.example.aigenerated.controller;

import com.example.aigenerated.DTOs.HouseholdDTO;
import com.example.aigenerated.entities.Household;
import com.example.aigenerated.services.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {
    @Autowired
    private HouseholdService householdService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Household> createHousehold(@Valid @RequestBody HouseholdDTO householdDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(householdService.createHousehold(householdDTO));
    }

    @GetMapping
    public ResponseEntity<List<Household>> getAllHouseholds() {
        return ResponseEntity.ok(householdService.getAllHouseholds());
    }

    @GetMapping("/{eircode}")
    public ResponseEntity<Household> getHouseholdById(@PathVariable String eircode) {
        return ResponseEntity.ok(householdService.getHouseholdById(eircode));
    }

    @PutMapping("/{eircode}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Household> updateHousehold(@PathVariable String eircode, @Valid @RequestBody HouseholdDTO householdDTO) {
        return ResponseEntity.ok(householdService.updateHousehold(eircode, householdDTO));
    }

    @DeleteMapping("/{eircode}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHousehold(eircode);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/noPets")
    public ResponseEntity<List<Household>> findHouseholdsWithNoPets() {
        return ResponseEntity.ok(householdService.findHouseholdsWithNoPets());
    }

    @GetMapping("/ownerOccupied")
    public ResponseEntity<List<Household>> findOwnerOccupiedHouseholds() {
        return ResponseEntity.ok(householdService.findOwnerOccupiedHouseholds());
    }

    @GetMapping("/statistics")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Map<String, Long>> getHouseholdStatistics() {
        return ResponseEntity.ok(householdService.getHouseholdStatistics());
    }
}


