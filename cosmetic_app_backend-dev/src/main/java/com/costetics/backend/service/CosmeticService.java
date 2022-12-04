package com.costetics.backend.service;

import com.costetics.backend.classes.Cosmetic;
import com.costetics.backend.classes.CosmeticSummary;
import com.costetics.backend.repository.CosmeticRepository;
import com.costetics.backend.repository.SubsubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CosmeticService {

    @Autowired
    private CosmeticRepository cosmeticRepository;

    @Autowired
    private SubsubCategoryRepository subsubCategoryRepository;

    public List<Cosmetic> getFullList() {
        return cosmeticRepository.findAll();
    }

    public List<Cosmetic> getUserCosmeticList(Long id) {
        return cosmeticRepository.findAllByOwnerId(id);
    }

    @Transactional
    public Cosmetic addNewCosmetic(Cosmetic cosmetic) {
        cosmeticRepository.save(cosmetic);
        return cosmetic;
    }

    public Optional<Cosmetic> getCosmetic(Long id) {
        var cosmetic =  cosmeticRepository.findCosmeticById(id);
        if (cosmetic.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cosmetic not found");
        return cosmetic;
    }

    public void deleteCosmetic(Long id) {
        if (!cosmeticRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cosmetic with id " + id + " does not exist");
        cosmeticRepository.deleteById(id);
    }

    @Transactional
    public void updateCosmetic(Long id, CosmeticSummary providedCosmetic) {
        var cosmetic = cosmeticRepository.findCosmeticById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cosmetic with id " + id + " does not exist"));
        cosmetic.setName(providedCosmetic.getName());
        cosmetic.setBrand(providedCosmetic.getBrand());
        cosmetic.setDescription(providedCosmetic.getDescription());
        cosmetic.setPrice(providedCosmetic.getPrice());
        cosmetic.setExpiredIn(providedCosmetic.getExpiredIn());
        cosmetic.setOpenDate(providedCosmetic.getOpenDate());
        cosmetic.setArchived(providedCosmetic.isArchived());
        cosmetic.setFavourite(providedCosmetic.isFavourite());
        cosmetic.setAnimalTests(providedCosmetic.isAnimalTests());
        cosmetic.setSize(providedCosmetic.getSize());
        cosmetic.setSizeType(providedCosmetic.getSizeType());
        cosmetic.setRating(providedCosmetic.getRating());
        cosmetic.setSubsubCategory(providedCosmetic.getSubsubCategory());
        cosmetic.setPhotoUrl(providedCosmetic.getPhotoUrl());
    }
}