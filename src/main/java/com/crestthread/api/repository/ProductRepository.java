// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.repository;

import com.crestthread.api.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Product Repository for database operations
 * Follows Backend Code Standards - proper query methods
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Find all featured products
     */
    List<Product> findByFeaturedTrueAndInStockTrue();

    /**
     * Find products by category
     */
    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);

    /**
     * Find products by category slug
     */
    @Query("SELECT p FROM Product p WHERE p.category.slug = :slug AND p.inStock = true")
    Page<Product> findByCategorySlug(@Param("slug") String slug, Pageable pageable);

    /**
     * Search products by name or description
     */
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%')) " +
           "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    Page<Product> searchProducts(@Param("query") String query, Pageable pageable);

    /**
     * Find products in stock
     */
    Page<Product> findByInStockTrue(Pageable pageable);
}
// AI Generated Code by Deloitte + Cursor (END)
