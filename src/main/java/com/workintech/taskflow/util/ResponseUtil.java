package com.workintech.taskflow.util;

import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity<Object> createResponse(Object body, int statusCode) {
        return ResponseEntity.status(statusCode).body(body);
    }
}
