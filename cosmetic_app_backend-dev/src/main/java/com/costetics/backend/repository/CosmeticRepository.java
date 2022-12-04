package com.costetics.backend.repository;

import com.costetics.backend.classes.Cosmetic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CosmeticRepository extends JpaRepository<Cosmetic, Long> {

    List<Cosmetic> findAllByOwnerId(Long id);

    Optional<Cosmetic> findCosmeticById(Long id);
}