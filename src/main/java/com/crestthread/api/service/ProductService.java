// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.service;

import com.crestthread.api.dto.ProductDTO;
import com.crestthread.api.model.Product;
import com.crestthread.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Product Service for business logic
 * Follows Backend Code Standards - service layer pattern
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        log.debug("Fetching all products with pagination");
        return productRepository.findByInStockTrue(pageable)
                .map(this::mapToDTO);
    }

    public Optional<ProductDTO> getProductById(Long id) {
        log.debug("Fetching product by ID: {}", id);
        return productRepository.findById(id)
                .map(this::mapToDTO);
    }

    public List<ProductDTO> getFeaturedProducts() {
        log.debug("Fetching featured products");
        return productRepository.findByFeaturedTrueAndInStockTrue()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Page<ProductDTO> getProductsByCategory(Long categoryId, Pageable pageable) {
        log.debug("Fetching products by category ID: {}", categoryId);
        return productRepository.findByCategoryId(categoryId, pageable)
                .map(this::mapToDTO);
    }

    public Page<ProductDTO> getProductsByCategorySlug(String slug, Pageable pageable) {
        log.debug("Fetching products by category slug: {}", slug);
        return productRepository.findByCategorySlug(slug, pageable)
                .map(this::mapToDTO);
    }

    public Page<ProductDTO> searchProducts(String query, Pageable pageable) {
        log.debug("Searching products with query: {}", query);
        return productRepository.searchProducts(query, pageable)
                .map(this::mapToDTO);
    }

    private ProductDTO mapToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .originalPrice(product.getOriginalPrice())
                .imageUrl(product.getImageUrl())
                .category(product.getCategory() != null ? product.getCategory().getName() : null)
                .categoryId(product.getCategory() != null ? product.getCategory().getId() : null)
                .rating(product.getRating())
                .reviewCount(product.getReviewCount())
                .inStock(product.getInStock())
                .build();
    }
}
// AI Generated Code by Deloitte + Cursor (END)
