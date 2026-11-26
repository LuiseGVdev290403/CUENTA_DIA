package com.luisedev.cuentadia.mappers.Category;

import com.luisedev.cuentadia.dto.requets.CategoryRequest;
import com.luisedev.cuentadia.dto.response.CategoryResponse;
import com.luisedev.cuentadia.entities.Category;

import java.util.Collections;
import java.util.List;

public class CategoryImp implements ICategoryMapper{

    @Override
    public List<CategoryResponse> categoryResponseList(List<Category> categoryList) {
        if (categoryList == null) {
            return Collections.emptyList();
        }
        return (List<CategoryResponse>) categoryList.stream().map(c -> {
            return new CategoryResponse(
                    c.getId(),
                    c.getName(),
                    c.getDescription(),
                    c.getType(),
                    c.isActive()
            );
        }).toList();
    }

    @Override
    public CategoryResponse toCategoryResponse(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getType(),
                category.isActive()
        );
    }

    @Override
    public Category toCategoryEntity(CategoryRequest categoryRequest) {
        if (categoryRequest == null) {
            return null;
        }
        return new Category(
                categoryRequest.name(),
                categoryRequest.description(),
                categoryRequest.type(),
                categoryRequest.active()
        );
    }
}
