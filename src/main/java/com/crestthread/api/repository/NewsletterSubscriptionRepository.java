// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.repository;

import com.crestthread.api.model.NewsletterSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Newsletter Subscription Repository for database operations
 * Follows Backend Code Standards - proper query methods
 */
@Repository
public interface NewsletterSubscriptionRepository extends JpaRepository<NewsletterSubscription, Long> {

    /**
     * Find subscription by email
     */
    Optional<NewsletterSubscription> findByEmail(String email);

    /**
     * Check if email already subscribed
     */
    boolean existsByEmail(String email);
}
// AI Generated Code by Deloitte + Cursor (END)
