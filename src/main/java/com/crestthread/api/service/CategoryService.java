// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.service;

import com.crestthread.api.dto.CategoryDTO;
import com.crestthread.api.model.Category;
import com.crestthread.api.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Category Service for business logic
 * Follows Backend Code Standards - service layer pattern
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * Get all active categories
     */
    public List<CategoryDTO> getAllCategories() {
        log.debug("Fetching all active categories");
        return categoryRepository.findByActiveTrueOrderByDisplayOrderAsc()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get category by ID
     */
    public Optional<CategoryDTO> getCategoryById(Long id) {
        log.debug("Fetching category by ID: {}", id);
        return categoryRepository.findById(id)
                .map(this::mapToDTO);
    }

    /**
     * Get category by slug
     */
    public Optional<CategoryDTO> getCategoryBySlug(String slug) {
        log.debug("Fetching category by slug: {}", slug);
        return categoryRepository.findBySlug(slug)
                .map(this::mapToDTO);
    }

    /**
     * Map Category entity to DTO
     */
    private CategoryDTO mapToDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .slug(category.getSlug())
                .description(category.getDescription())
                .imageUrl(category.getImageUrl())
                .build();
    }
}
// AI Generated Code by Deloitte + Cursor (END)
