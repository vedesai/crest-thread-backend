// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * Newsletter Subscription Data Transfer Object
 * Follows Backend Code Standards - DTOs for API communication
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsletterSubscriptionDTO {
    
    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;
}
// AI Generated Code by Deloitte + Cursor (END)
