package com.costetics.backend.service;

import com.costetics.backend.classes.Category;
import com.costetics.backend.classes.SubCategory;
import com.costetics.backend.classes.SubsubCategory;
import com.costetics.backend.repository.CategoryRepository;
import com.costetics.backend.repository.SubCategoryRepository;
import com.costetics.backend.repository.SubsubCategoryRepository;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final SubsubCategoryRepository subsubCategoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository, SubsubCategoryRepository subsubCategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.subsubCategoryRepository = subsubCategoryRepository;
    }

    // Категории

    @Transactional
    public void createCategory(String categoryName) {
        var categoryOptional = categoryRepository.findCategoryByName(categoryName);
        if (categoryOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category already exist");
        categoryRepository.save(new Category(categoryName));
    }

    public Optional<Category> getCategory(Long id) {
        if (id == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        var categoryOptional = categoryRepository.findCategoryById(id);
        if (categoryOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        return categoryOptional;
    }

    @Transactional
    public void updateCategory(Category providedCategory) {
        categoryRepository.findCategoryById(providedCategory.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Category with id " + providedCategory.getId() + " does not exist"
                ));
        categoryRepository.save(providedCategory);
    }

    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id " + id + " does not exist");
        categoryRepository.deleteById(id);
    }

    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    public JSONArray getFullList() {
        var main = new JSONArray();
        var categories = categoryRepository.findAll();
        for (var category : categories) {
            var cJson = new JSONObject();
            cJson.appendField("id", category.getId());
            cJson.appendField("name", category.getName());
            var subArray = new JSONArray();
            var subcategories = subCategoryRepository.findAllByCategoryId(category.getId());
            for (var subcategory : subcategories) {
                var scJson = new JSONObject();
                scJson.appendField("id", subcategory.getId());
                scJson.appendField("name", subcategory.getName());
                var subsubArray = new JSONArray();
                var subsubcategories = subsubCategoryRepository.findAllBySubCategoryId(subcategory.getId());
                for (var subsubcategory : subsubcategories) {
                    var sscJson = new JSONObject();
                    sscJson.appendField("id", subsubcategory.getId());
                    sscJson.appendField("name", subsubcategory.getName());
                    subsubArray.add(sscJson);
                }
                scJson.appendField("subsubcategories", subsubArray);
                subArray.add(scJson);
            }
            cJson.appendField("subcategories", subArray);
            main.add(cJson);
        }
        return main;
    }

    public List<SubCategory> getSubCategories(Long id) {
        return subCategoryRepository.findAllByCategoryId(id);
    }

    public ArrayList<Object> getSubsubCategories(Long id) {
        var subCategories = subCategoryRepository.findAllByCategoryId(id);
        var subsubCategories = new ArrayList<>();
        for (var subCategory : subCategories) {
            var tmp = subsubCategoryRepository.findAllBySubCategoryId(subCategory.getId());
            subsubCategories.add(tmp);
        }
        return subsubCategories;
    }


    // Подкатегории

    @Transactional
    public void createSubCategory(SubCategory subCategory) {
        var categoryOptional = categoryRepository.findCategoryById(subCategory.getCategory().getId());
        if (categoryOptional.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Category with id " + subCategory.getCategory().getId() + " does not exist");
        subCategoryRepository.save(subCategory);
    }

    public Optional<SubCategory> getSubCategory(Long id) {
        if (id == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        var subCategoryOptional = subCategoryRepository.findSubCategoryById(id);
        if (subCategoryOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SubCategory not found");
        return subCategoryOptional;
    }

    @Transactional
    public void updateSubCategory(SubCategory providedSubCategory) {
        subCategoryRepository.findSubCategoryById(providedSubCategory.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "SubCategory with id " + providedSubCategory.getId() + " does not exist"
                ));
        subCategoryRepository.save(providedSubCategory);
    }

    public void deleteSubCategory(Long id) {
        if (!subCategoryRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SubCategory with id " + id + " does not exist");
        subCategoryRepository.deleteById(id);
    }

    public List<SubCategory> getSubCategoryList() {
        return subCategoryRepository.findAll();
    }


    // Подподкатегории

    @Transactional
    public void createSubsubCategory(SubsubCategory subsubCategory) {
        var subCategoryOptional = subCategoryRepository.findSubCategoryById(subsubCategory.getSubCategory().getId());
        if (subCategoryOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SubCategory with id " + subsubCategory.getSubCategory().getId() + " does not exist");
        subsubCategoryRepository.save(subsubCategory);
    }

    public Optional<SubsubCategory> getSubsubCategory(Long id) {
        if (id == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        var subsubCategoryOptional = subsubCategoryRepository.findSubsubCategoryById(id);
        if (subsubCategoryOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SubsubCategory not found");
        return subsubCategoryOptional;
    }

    @Transactional
    public void updateSubsubCategory(SubsubCategory providedSubsubCategory) {
        subsubCategoryRepository.findSubsubCategoryById(providedSubsubCategory.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "SubsubCategory with id " + providedSubsubCategory.getId() + " does not exist"
                ));
        subsubCategoryRepository.save(providedSubsubCategory);
    }

    public void deleteSubsubCategory(Long id) {
        if (!subsubCategoryRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SubsubCategory with id " + id + " does not exist");
        subsubCategoryRepository.deleteById(id);
    }

    public List<SubsubCategory> getSubsubCategoryList() {
        return subsubCategoryRepository.findAll();
    }
}