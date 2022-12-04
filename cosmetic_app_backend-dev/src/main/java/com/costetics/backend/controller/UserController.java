package com.costetics.backend.controller;

import com.costetics.backend.classes.Cosmetic;
import com.costetics.backend.classes.User;
import com.costetics.backend.classes.UserSummary;
import com.costetics.backend.service.CosmeticService;
import com.costetics.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CosmeticService cosmeticService;

    @GetMapping("/get/{id}")
    public Optional<User> getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/list")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/create")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public void updateUser(
            @PathVariable("id") Long id,
            @RequestBody UserSummary user) {
        userService.updateUser(id, user);
    }

    @GetMapping("/{id}/cosmetic/list")
    public List<Cosmetic> getUserCosmetic(@PathVariable("id") Long id) {
        return cosmeticService.getUserCosmeticList(id);
    }
}
