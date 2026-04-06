package org.pkp.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.pkp.dto.request.CategoryRequest;
import org.pkp.dto.response.CategoryResponse;
import org.pkp.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    // Entity -> Response DTO
    CategoryResponse toResponse(Category entity);

    // Request DTO -> Entity
    @Mapping(target = "categoryID", ignore = true)
    Category toEntity(CategoryRequest request);

    // Update existing entity
    @Mapping(target = "categoryID", ignore = true)
    void updateEntity(CategoryRequest request, @MappingTarget Category entity);
}