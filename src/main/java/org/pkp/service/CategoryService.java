package org.pkp.service;

import org.pkp.dto.request.CategoryRequest;
import org.pkp.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAll();
    CategoryResponse getById(Integer id);
    CategoryResponse create(CategoryRequest request);
    CategoryResponse update(Integer id, CategoryRequest request);
    boolean delete(Integer id);
}
