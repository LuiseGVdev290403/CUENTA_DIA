package com.luisedev.cuentadia.services.Category;

import com.luisedev.cuentadia.dto.requets.CategoryRequest;
import com.luisedev.cuentadia.dto.response.CategoryResponse;
import com.luisedev.cuentadia.entities.Category;
import com.luisedev.cuentadia.mappers.Category.ICategoryMapper;
import com.luisedev.cuentadia.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{
    private final CategoryRepository categoryRepository;
    private final ICategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ICategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        System.out.println(categoryRepository.findAll());
        List<Category> categoryList = categoryRepository.findAll();

        return categoryMapper.categoryResponseList(categoryList);
    }

    @Override
    public CategoryResponse categorySave(CategoryRequest categoryRequest) {
        Category category = categoryMapper.toCategoryEntity(categoryRequest);
        Category categorySaved = categoryRepository.save(category);
        return categoryMapper.toCategoryResponse(categorySaved);
    }

    @Override
    public boolean categoryDeletedById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryMapper.toCategoryResponse(category);
    }
}
