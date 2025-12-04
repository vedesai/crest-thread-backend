// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.exception;

import lombok.Getter;

/**
 * Exception for duplicate resource errors
 * Follows Backend Code Standards - custom exception classes
 */
@Getter
public class DuplicateResourceException extends RuntimeException {
    
    private final String code;

    public DuplicateResourceException(String code, String message) {
        super(message);
        this.code = code;
    }
}
// AI Generated Code by Deloitte + Cursor (END)
