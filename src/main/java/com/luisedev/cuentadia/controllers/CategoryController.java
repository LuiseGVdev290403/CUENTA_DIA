package com.luisedev.cuentadia.controllers;

import com.luisedev.cuentadia.dto.requets.CategoryRequest;
import com.luisedev.cuentadia.dto.response.CategoryResponse;
import com.luisedev.cuentadia.services.Category.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final ICategoryService categoryMapper;

    public CategoryController(ICategoryService categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategoryList(){
        System.out.println(categoryMapper.getAllCategories());
        return ResponseEntity.ok(categoryMapper.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(Long id)  {
        return ResponseEntity.ok(categoryMapper.getCategoryById(id));
    }
    @PostMapping
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryMapper.categorySave(categoryRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryMapper.categoryDeletedById(id));
    }
}
