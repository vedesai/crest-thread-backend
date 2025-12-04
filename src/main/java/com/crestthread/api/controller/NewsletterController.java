// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.controller;

import com.crestthread.api.dto.ApiResponse;
import com.crestthread.api.dto.NewsletterSubscriptionDTO;
import com.crestthread.api.service.NewsletterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Newsletter REST Controller
 * Follows Backend Code Standards - RESTful principles, proper status codes
 */
@RestController
@RequestMapping("/api/newsletter")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Newsletter", description = "Newsletter subscription APIs")
public class NewsletterController {

    private final NewsletterService newsletterService;

    @PostMapping("/subscribe")
    @Operation(summary = "Subscribe to newsletter", description = "Subscribe email to newsletter")
    public ResponseEntity<ApiResponse<Void>> subscribe(
            @Valid @RequestBody NewsletterSubscriptionDTO subscriptionDTO) {
        log.info("POST /api/newsletter/subscribe - Subscribing email: {}", subscriptionDTO.getEmail());
        newsletterService.subscribe(subscriptionDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(null, "Successfully subscribed to newsletter"));
    }

    @PostMapping("/unsubscribe")
    @Operation(summary = "Unsubscribe from newsletter", description = "Unsubscribe email from newsletter")
    public ResponseEntity<ApiResponse<Void>> unsubscribe(
            @Valid @RequestBody NewsletterSubscriptionDTO subscriptionDTO) {
        log.info("POST /api/newsletter/unsubscribe - Unsubscribing email: {}", subscriptionDTO.getEmail());
        newsletterService.unsubscribe(subscriptionDTO.getEmail());
        return ResponseEntity.ok(ApiResponse.success(null, "Successfully unsubscribed from newsletter"));
    }
}
// AI Generated Code by Deloitte + Cursor (END)
