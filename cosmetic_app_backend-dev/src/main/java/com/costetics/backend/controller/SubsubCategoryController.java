package com.costetics.backend.controller;


import com.costetics.backend.classes.SubsubCategory;
import com.costetics.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/subsubcategories")
public class SubsubCategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public void createSubsubCategory(@RequestBody SubsubCategory subsubCategory) {
        categoryService.createSubsubCategory(subsubCategory);
    }

    @GetMapping("/get/{id}")
    public Optional<SubsubCategory> getSubsubCategory(@PathVariable("id") Long id) {
        return categoryService.getSubsubCategory(id);
    }

    @PutMapping("/update")
    public void updateSubsubCategory(@RequestBody SubsubCategory subsubCategory) {
        categoryService.updateSubsubCategory(subsubCategory);
    }

    @PostMapping("/delete/{id}")
    public void deleteSubsubCategory(@PathVariable("id") Long id) {
        categoryService.deleteSubsubCategory(id);
    }

    @GetMapping("/list")
    public List<SubsubCategory> getSubsubCategoryList() {
        return categoryService.getSubsubCategoryList();
    }
}