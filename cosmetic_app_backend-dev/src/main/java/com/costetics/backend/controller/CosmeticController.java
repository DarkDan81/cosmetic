package com.costetics.backend.controller;

import com.costetics.backend.classes.Cosmetic;
import com.costetics.backend.classes.CosmeticSummary;
import com.costetics.backend.service.CosmeticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cosmetics")
public class CosmeticController {

    @Autowired
    private CosmeticService cosmeticService;

    @PostMapping("/create")
    public Cosmetic addNewCosmetic(@RequestBody Cosmetic cosmetic) {
        return cosmeticService.addNewCosmetic(cosmetic);
    }

    @GetMapping("/get/{id}")
    public Optional<Cosmetic> getCosmetic(@PathVariable("id") Long id) {
        return cosmeticService.getCosmetic(id);
    }

    @PostMapping("/delete/{id}")
    public void deleteCosmetic(@PathVariable("id") Long id) {
        cosmeticService.deleteCosmetic(id);
    }

    @PutMapping("/update/{id}")
    public void updateCosmetic(@PathVariable("id") Long id,
                               @RequestBody CosmeticSummary cosmetic) {
        cosmeticService.updateCosmetic(id, cosmetic);
    }

    @GetMapping("/list")
    public List<Cosmetic> getFullList() {
        return cosmeticService.getFullList();
    }
}