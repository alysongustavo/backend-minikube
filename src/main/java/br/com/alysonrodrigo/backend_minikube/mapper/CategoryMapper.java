package br.com.alysonrodrigo.backend_minikube.mapper;


import br.com.alysonrodrigo.backend_minikube.domain.model.Category;
import br.com.alysonrodrigo.backend_minikube.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    // Método para mapear CategoryDTO para Category
    public Category toEntity(CategoryDTO dto) {
        if (dto == null) {
            return null;
        }
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }

    // Método para mapear Category para CategoryDTO
    public CategoryDTO toDto(Category entity) {
        if (entity == null) {
            return null;
        }
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    // Método para mapear uma lista de CategoryDTO para Category
    public List<Category> toEntityList(List<CategoryDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) {
            return List.of();
        }
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    // Método para mapear uma lista de Category para CategoryDTO
    public List<CategoryDTO> toDtoList(List<Category> entityList) {
        if (entityList == null || entityList.isEmpty()) {
            return List.of();
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
