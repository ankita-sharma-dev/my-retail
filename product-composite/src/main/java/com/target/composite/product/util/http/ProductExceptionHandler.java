package com.target.composite.product.util.http;

import com.target.composite.product.util.exception.ProductException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.time.ZonedDateTime;

@RestController
public class ProductExceptionHandler {
    @ExceptionHandler(value = ProductException.class)
    ResponseEntity<Map<String, Object>> handleProductException(ProductException exception){
        return  ResponseEntity.status(exception.getErrorCode().getStatus())
        .body(createErrorInfo(exception.getErrorCode().getMessage()));
    }

    Map<String, Object> createErrorInfo(String message){
        Map<String, Object> errorInfo = new LinkedHashMap<>();
       errorInfo.put("TimeStamp", ZonedDateTime.now());
       errorInfo.put("Message", message);
       return errorInfo;
    }

}
