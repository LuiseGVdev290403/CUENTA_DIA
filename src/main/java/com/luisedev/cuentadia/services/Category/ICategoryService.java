package com.luisedev.cuentadia.services.Category;

import com.luisedev.cuentadia.dto.requets.CategoryRequest;
import com.luisedev.cuentadia.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> getAllCategories();
    CategoryResponse categorySave (CategoryRequest categoryRequest);
    boolean categoryDeletedById(Long id);
    CategoryResponse getCategoryById(Long id);
}
