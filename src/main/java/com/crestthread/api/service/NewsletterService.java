// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.service;

import com.crestthread.api.dto.NewsletterSubscriptionDTO;
import com.crestthread.api.exception.DuplicateResourceException;
import com.crestthread.api.model.NewsletterSubscription;
import com.crestthread.api.repository.NewsletterSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Newsletter Service for business logic
 * Follows Backend Code Standards - service layer pattern
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NewsletterService {

    private final NewsletterSubscriptionRepository subscriptionRepository;

    /**
     * Subscribe to newsletter
     */
    @Transactional
    public void subscribe(NewsletterSubscriptionDTO subscriptionDTO) {
        String email = subscriptionDTO.getEmail().toLowerCase().trim();
        log.debug("Processing newsletter subscription for email: {}", email);

        if (subscriptionRepository.existsByEmail(email)) {
            log.warn("Email already subscribed: {}", email);
            throw new DuplicateResourceException("EMAIL_EXISTS", "This email is already subscribed to our newsletter");
        }

        NewsletterSubscription subscription = NewsletterSubscription.builder()
                .email(email)
                .active(true)
                .build();

        subscriptionRepository.save(subscription);
        log.info("Successfully subscribed email: {}", email);
    }

    /**
     * Unsubscribe from newsletter
     */
    @Transactional
    public void unsubscribe(String email) {
        log.debug("Processing newsletter unsubscription for email: {}", email);
        
        subscriptionRepository.findByEmail(email.toLowerCase().trim())
                .ifPresent(subscription -> {
                    subscription.setActive(false);
                    subscriptionRepository.save(subscription);
                    log.info("Successfully unsubscribed email: {}", email);
                });
    }
}
// AI Generated Code by Deloitte + Cursor (END)
