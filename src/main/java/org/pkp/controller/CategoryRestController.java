package org.pkp.controller;

import lombok.RequiredArgsConstructor;
import org.pkp.dto.response.CategoryResponse;
import org.pkp.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryRestController {

    private final CategoryService service;

    @GetMapping
    public List<CategoryResponse> getAll() {
        return service.getAll();
    }
}