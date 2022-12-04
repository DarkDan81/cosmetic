package com.costetics.backend.repository;

import com.costetics.backend.classes.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    Optional<SubCategory> findSubCategoryByName(String name);

    Optional<SubCategory> findSubCategoryById(Long id);

    List<SubCategory> findAllByCategoryId(Long id);
}