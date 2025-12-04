// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.controller;

import com.crestthread.api.dto.ApiResponse;
import com.crestthread.api.dto.ProductDTO;
import com.crestthread.api.exception.ResourceNotFoundException;
import com.crestthread.api.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Product REST Controller
 * Follows Backend Code Standards - RESTful principles, proper status codes
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Products", description = "Product management APIs")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "Get all products", description = "Returns paginated list of products")
    public ResponseEntity<ApiResponse<Page<ProductDTO>>> getAllProducts(
            @PageableDefault(size = 12, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        log.info("GET /api/products - Fetching all products");
        Page<ProductDTO> products = productService.getAllProducts(pageable);
        return ResponseEntity.ok(ApiResponse.success(products));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Returns a single product by ID")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductById(@PathVariable Long id) {
        log.info("GET /api/products/{} - Fetching product by ID", id);
        ProductDTO product = productService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PRODUCT_NOT_FOUND", 
                        "Product not found with ID: " + id));
        return ResponseEntity.ok(ApiResponse.success(product));
    }

    @GetMapping("/featured")
    @Operation(summary = "Get featured products", description = "Returns list of featured products")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getFeaturedProducts() {
        log.info("GET /api/products/featured - Fetching featured products");
        List<ProductDTO> products = productService.getFeaturedProducts();
        return ResponseEntity.ok(ApiResponse.success(products));
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Get products by category ID", description = "Returns paginated products by category")
    public ResponseEntity<ApiResponse<Page<ProductDTO>>> getProductsByCategory(
            @PathVariable Long categoryId,
            @PageableDefault(size = 12) Pageable pageable) {
        log.info("GET /api/products/category/{} - Fetching products by category", categoryId);
        Page<ProductDTO> products = productService.getProductsByCategory(categoryId, pageable);
        return ResponseEntity.ok(ApiResponse.success(products));
    }

    @GetMapping("/category/slug/{slug}")
    @Operation(summary = "Get products by category slug", description = "Returns paginated products by category slug")
    public ResponseEntity<ApiResponse<Page<ProductDTO>>> getProductsByCategorySlug(
            @PathVariable String slug,
            @PageableDefault(size = 12) Pageable pageable) {
        log.info("GET /api/products/category/slug/{} - Fetching products by category slug", slug);
        Page<ProductDTO> products = productService.getProductsByCategorySlug(slug, pageable);
        return ResponseEntity.ok(ApiResponse.success(products));
    }

    @GetMapping("/search")
    @Operation(summary = "Search products", description = "Search products by name or description")
    public ResponseEntity<ApiResponse<Page<ProductDTO>>> searchProducts(
            @RequestParam String query,
            @PageableDefault(size = 12) Pageable pageable) {
        log.info("GET /api/products/search?query={} - Searching products", query);
        Page<ProductDTO> products = productService.searchProducts(query, pageable);
        return ResponseEntity.ok(ApiResponse.success(products));
    }
}
// AI Generated Code by Deloitte + Cursor (END)
