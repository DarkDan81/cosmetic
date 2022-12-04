package com.costetics.backend.repository;

import com.costetics.backend.classes.SubsubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubsubCategoryRepository extends JpaRepository<SubsubCategory, Long> {

    Optional<SubsubCategory> findSubsubCategoryById(Long id);

    Optional<SubsubCategory> findSubsubCategoryByName(String name);

    List<SubsubCategory> findAllBySubCategoryId(Long id);
}