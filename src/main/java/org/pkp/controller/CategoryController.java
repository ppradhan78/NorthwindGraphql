package org.pkp.controller;

import lombok.RequiredArgsConstructor;
import org.pkp.dto.request.CategoryRequest;
import org.pkp.dto.response.CategoryResponse;
import org.pkp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CategoryController {
    private final CategoryService service;

//    public CategoryController(CategoryService service) {
//        this.service = service;
//    }

    @QueryMapping
    public CategoryResponse getCategoryById(@Argument Integer categoryID) { // Name must match schema
        return service.getById(categoryID);
    }

    @QueryMapping
    public List<CategoryResponse> getAllCategories() {
        return service.getAll();
    }

    @MutationMapping
    public CategoryResponse createCategory(@Argument CategoryRequest input) { // Name 'input' must match schema
        return service.create(input);
    }

    @MutationMapping
    public CategoryResponse updateCategory(@Argument Integer categoryID, @Argument CategoryRequest input) {
        return service.update(categoryID, input);
    }
}