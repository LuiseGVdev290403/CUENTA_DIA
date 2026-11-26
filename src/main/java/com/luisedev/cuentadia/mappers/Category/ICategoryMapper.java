package com.luisedev.cuentadia.mappers.Category;

import com.luisedev.cuentadia.dto.requets.CategoryRequest;
import com.luisedev.cuentadia.dto.response.CategoryResponse;
import com.luisedev.cuentadia.entities.Category;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    List<CategoryResponse> categoryResponseList (List<Category> categoryList);
    CategoryResponse toCategoryResponse (Category category);
    Category toCategoryEntity (CategoryRequest categoryRequest);
}
