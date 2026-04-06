package org.pkp.service.impl;


import lombok.RequiredArgsConstructor;
import org.pkp.dto.request.CategoryRequest;
import org.pkp.dto.response.CategoryResponse;
import org.pkp.entity.Category;
import org.pkp.mapper.CategoryMapper;
import org.pkp.repository.CategoryRepository;
import org.pkp.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }
    @Override
    @Transactional(readOnly = true)
    public CategoryResponse getById(Integer id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
    }
    @Override
    public CategoryResponse create(CategoryRequest request) {
        Category entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }
    @Override
    public CategoryResponse update(Integer id, CategoryRequest request) {
        Category existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot update: Category not found"));

        mapper.updateEntity(request, existing);
        return mapper.toResponse(repository.save(existing));
    }
    @Override
    public boolean delete(Integer id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}