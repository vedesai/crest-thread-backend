// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.repository;

import com.crestthread.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Category Repository for database operations
 * Follows Backend Code Standards - proper query methods
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Find category by slug
     */
    Optional<Category> findBySlug(String slug);

    /**
     * Find all active categories ordered by display order
     */
    List<Category> findByActiveTrueOrderByDisplayOrderAsc();

    /**
     * Check if category exists by slug
     */
    boolean existsBySlug(String slug);
}
// AI Generated Code by Deloitte + Cursor (END)
