// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.controller;

import com.crestthread.api.dto.ApiResponse;
import com.crestthread.api.dto.CategoryDTO;
import com.crestthread.api.exception.ResourceNotFoundException;
import com.crestthread.api.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Category REST Controller
 * Follows Backend Code Standards - RESTful principles, proper status codes
 */
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Categories", description = "Category management APIs")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Get all categories", description = "Returns list of all active categories")
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> getAllCategories() {
        log.info("GET /api/categories - Fetching all categories");
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(ApiResponse.success(categories));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get category by ID", description = "Returns a single category by ID")
    public ResponseEntity<ApiResponse<CategoryDTO>> getCategoryById(@PathVariable Long id) {
        log.info("GET /api/categories/{} - Fetching category by ID", id);
        CategoryDTO category = categoryService.getCategoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CATEGORY_NOT_FOUND",
                        "Category not found with ID: " + id));
        return ResponseEntity.ok(ApiResponse.success(category));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get category by slug", description = "Returns a single category by slug")
    public ResponseEntity<ApiResponse<CategoryDTO>> getCategoryBySlug(@PathVariable String slug) {
        log.info("GET /api/categories/slug/{} - Fetching category by slug", slug);
        CategoryDTO category = categoryService.getCategoryBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("CATEGORY_NOT_FOUND",
                        "Category not found with slug: " + slug));
        return ResponseEntity.ok(ApiResponse.success(category));
    }
}
// AI Generated Code by Deloitte + Cursor (END)
