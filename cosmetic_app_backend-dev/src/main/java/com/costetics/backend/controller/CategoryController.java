package com.costetics.backend.controller;

import com.costetics.backend.classes.Category;
import com.costetics.backend.classes.SubCategory;
import com.costetics.backend.service.CategoryService;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create/{name}")
    public void createNewCategory(@PathVariable("name") String name) {
        categoryService.createCategory(name);
    }

    @GetMapping("/get/{id}")
    public Optional<Category> getCategory(@PathVariable("id") Long id) {
        return categoryService.getCategory(id);
    }

    @PutMapping("/update")
    public void updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @PostMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }
    @GetMapping("/list")
    public List<Category> getCategoryList() {
        return categoryService.getCategoryList();
    }

    @GetMapping("/fulllist")
    public JSONArray getFullList() {
        return categoryService.getFullList();
    }

    @GetMapping("/get/{id}/subcategories")
    public List<SubCategory> getSubCategories(@PathVariable("id") Long id) {
        return categoryService.getSubCategories(id);
    }

    @GetMapping("/get/{id}/subsubcategories")
    public ArrayList<Object> getSubsubCategories(@PathVariable("id") Long id) {
        return categoryService.getSubsubCategories(id);
    }
}