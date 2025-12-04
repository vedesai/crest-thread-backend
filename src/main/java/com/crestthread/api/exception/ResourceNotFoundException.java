// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.exception;

import lombok.Getter;

/**
 * Exception for resource not found errors
 * Follows Backend Code Standards - custom exception classes
 */
@Getter
public class ResourceNotFoundException extends RuntimeException {
    
    private final String code;

    public ResourceNotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }
}
// AI Generated Code by Deloitte + Cursor (END)
