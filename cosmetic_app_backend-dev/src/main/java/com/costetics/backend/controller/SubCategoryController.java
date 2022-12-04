package com.costetics.backend.controller;

import com.costetics.backend.classes.SubCategory;
import com.costetics.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/subcategories")
public class SubCategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public void createSubCategory(@RequestBody SubCategory subCategory) {
        categoryService.createSubCategory(subCategory);
    }

    @GetMapping("/get/{id}")
    public Optional<SubCategory> getSubCategory(@PathVariable("id") Long id) {
        return categoryService.getSubCategory(id);
    }

    @PutMapping("/update")
    public void updateSubCategory(@RequestBody SubCategory subCategory) {
        categoryService.updateSubCategory(subCategory);
    }

    @PostMapping("/delete/{id}")
    public void deleteSubCategory(@PathVariable("id") Long id) {
        categoryService.deleteSubCategory(id);
    }

    @GetMapping("/list")
    public List<SubCategory> getSubCategoryList() {
        return categoryService.getSubCategoryList();
    }
}