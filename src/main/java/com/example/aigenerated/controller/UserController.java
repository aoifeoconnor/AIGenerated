package com.example.aigenerated.controller;

import com.example.aigenerated.DTOs.UserDTO;
import com.example.aigenerated.entities.User;
import com.example.aigenerated.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.username());
        user.setPassword(userDTO.password());
        user.setRole(userDTO.role());
        user.setUnlocked(userDTO.unlocked());
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/{id}/reset-password")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> resetPassword(@PathVariable Long id, @RequestBody String newPassword) {
        return ResponseEntity.ok(userService.resetPassword(id, newPassword));
    }

    @PutMapping("/{id}/toggle-lock")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> toggleUnlockedStatus(@PathVariable Long id) {
        return ResponseEntity.ok(userService.toggleUnlockedStatus(id));
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')") //added after first iteraion
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        return ResponseEntity.ok(userService.createUser(user));
//    }
//
//    @PutMapping("/{id}/reset-password")
//    @PreAuthorize("hasRole('ADMIN')") //2nd iteration
//    public ResponseEntity<User> resetPassword(@PathVariable Long id, @RequestBody String newPassword) {
//        return ResponseEntity.ok(userService.resetPassword(id, newPassword));
//    }
//
//    @PutMapping("/{id}/toggle-lock")
//    @PreAuthorize("hasRole('ADMIN')") //2nd iteratioon
//    public ResponseEntity<User> toggleUnlockedStatus(@PathVariable Long id) {
//        return ResponseEntity.ok(userService.toggleUnlockedStatus(id));
//    }
//
//    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')") //2nd iteration
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return ResponseEntity.ok().build();
//    }
//}